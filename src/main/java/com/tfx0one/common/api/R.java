package com.tfx0one.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created by 2fx0one on 2018/6/30.
 */
@Data
@ApiModel("返回结果模型")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(R.class);

    @ApiModelProperty(value = "状态码，200 表示成功", required = true, position = -3)
    private Integer code = 200;

    @ApiModelProperty(value = "提示信息", position = -2)
    private String msg;

    @ApiModelProperty(value = "数据", position = -1)
    private T data;

    //总记录数
    @ApiModelProperty(value = "总记录数", position = 1)
    protected Long  total;

    //当前页
    @ApiModelProperty(value = "当前页", position = 5)
    private Integer pageNum;

    //每页的数量
    @ApiModelProperty(value = "每页的数量", position = 7)
    private Integer pageSize;

    //当前页的数量
    @ApiModelProperty(value = "当前页的数量", position = 9)
    private Integer size;

    //总页数
    @ApiModelProperty(value = "总页数", position = 11)
    private Integer pages;

    private R() {
    }

    //公共方法
    public static <T> R<T> commonFunc(Integer code, String msg, T data, PageInfo pageInfo) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        if (pageInfo != null) {
            r.setTotal(pageInfo.getTotal());
            r.setPageNum(pageInfo.getPageNum());
            r.setPageSize(pageInfo.getPageSize());
            r.setSize(pageInfo.getSize());
            r.setPages(pageInfo.getPages());
        }
        log.info("return R  code = " + code + "  msg = " + msg);
        return r;
    }

    public static <T> R<T> ok() {
        return commonFunc(HttpStatus.OK.value(), null, null, null);
    }

    public static <T> R<T> ok(String msg) {
        return commonFunc(HttpStatus.OK.value(), msg, null, null);
    }

    public static <T> R<T> ok(String msg, T data) {
        return commonFunc(HttpStatus.OK.value(), msg, data, null);
    }

    //带分页器的
    public static <T> R<T> ok(String msg, T data, PageInfo pageInfo) {
        return commonFunc(HttpStatus.OK.value(), msg, data, pageInfo);
    }

    public static <T> R<T> error() {
        return commonFunc(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统错误，请联系管理员", null, null);
    }

    public static <T> R<T> error(String msg) {
        return commonFunc(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null, null);
    }

    public static <T> R<T> error(Integer code, String msg) {
        return commonFunc(code, msg, null, null);
    }

}
