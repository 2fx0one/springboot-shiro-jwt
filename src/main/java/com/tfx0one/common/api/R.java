package com.tfx0one.common.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/30.
 */
@Data
@ApiModel("返回结果模型")
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(R.class);

    @ApiModelProperty(value = "状态码，20000 表示成功", required = true, position = -3)
    private Integer code = 20000;

    @ApiModelProperty(value = "提示信息", position = -2)
    private String msg;

    @ApiModelProperty(value = "数据", position = -1)
    private T data;

    //总记录数
    @ApiModelProperty(value = "总记录数", position = 1)
    protected Long total;

    @ApiModelProperty(value = "总页数", position = 3)
    private Long pages;

    @ApiModelProperty(value = "当前是第几页", position = 5)
    private Long current;

    @ApiModelProperty(value = "当前页记录的条数", position = 7)
    private Long size;

    private R() {
    }

    //公共方法
    private static <T> R<T> commonFunc(Integer code, String msg, T data) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        log.info("return R  code = " + code + "  msg = " + msg);
        return r;
    }

    private static Integer SUCCESS_CODE = 20000;
    private static Integer ERROR_CODE = 50000;


    public static <T> R<T> ok() {
        return commonFunc(SUCCESS_CODE, null, null);
    }

    public static <T> R<T> ok(String msg) {
        return commonFunc(SUCCESS_CODE, msg, null);
    }

    public static <T> R<T> ok(String msg, T data) {
        return commonFunc(SUCCESS_CODE, msg, data);
    }

    public static <T> R<T> ok(String msg, T data, IPage page) {
//        return commonFunc(SUCCESS_CODE, msg, data);
        return ok(msg, data)
                .setTotal(page.getTotal())
                .setPages(page.getPages())
                .setCurrent(page.getCurrent())
                .setSize(page.getSize());
    }

    //如果直接传 分页对象 特殊处理 需要把数据提取放到R对象的格式中
    public static <T> R<List<T>> ok(String msg, IPage<T> data) {
        return ok(msg, data.getRecords())
                .setTotal(data.getTotal())
                .setPages(data.getPages())
                .setCurrent(data.getCurrent())
                .setSize(data.getSize());
    }

    public static <T> R<T> error() {
        return commonFunc(ERROR_CODE, "系统错误，请联系管理员", null);
    }

    public static <T> R<T> error(String msg) {
        return commonFunc(ERROR_CODE, msg, null);
    }

    public static <T> R<T> error(Integer code, String msg) {
        return commonFunc(code, msg, null);
    }

}
