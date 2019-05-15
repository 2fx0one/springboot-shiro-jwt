package com.tfx0one.common.api;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created by 2fx0one on 2018/6/30.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("返回结果模型")
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(R.class);

    @ApiModelProperty(value = "数据")
    private T data;
    @ApiModelProperty(value = "状态")
    private int code;
    @ApiModelProperty(value = "提示")
    private String msg;
    @ApiModelProperty(value = "时间戳")
    private Long timestamp;

    //    私有构造
    private R() {
    }

    //    @Override
//    public R put(String key, Object value) {
//        super.put(key, value);
//        return this;
//    }
//
    public R<T> status(int status) {
        this.code = status;
        return this;
    }

//    public R status(HttpStatus status) {
//        return this.setStatus(status.value());
//    }

    public R<T> msg(String msg) {
        return this.setMsg(msg);
    }

    public R<T> data(T data) {
        return this.setData(data);
    }

    //公共方法
//    private static <T> R<T> commonFunc(HttpStatus status, String msg, T data) {
//        return commonFunc(status.value(), msg, data);
//    }

    private static <T> R<T> commonFunc(int status, String msg, T data) {
        R<T> r = new R<>();
        r.status(status).data(data);
        log.info("return R  status = " + status + "  msg = " + msg);
        return r;
    }

    public static <T> R<T> ok() {
        return ok(null);
//        return commonFunc(HttpStatus.OK.value(), "success", null);
    }

    public static <T> R<T> ok(T data) {
        return ok(data, "success");
    }

    public static <T> R<T> ok(T data, String msg) {
        return commonFunc(HttpStatus.OK.value(), msg, data);
    }

    public static R error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static R error(int status, String msg) {
        return commonFunc(status, msg, null);
    }

//
//    //公共方法
//    private static <T> ResponseEntity<T> commonFunc(int status, T data) {
//        log.info("===ResponseEntity=== status:" + status + "  data:" + data);
//        return ResponseEntity.status(status).body(data);
//    }
//
////    public static <T> ResponseEntity<T> ok(T data) {
////        return commonFunc(HttpStatus.OK.value(), data);
////    }
//
//    //如果直接传 分页对象 特殊处理 需要把数据提取放到R对象的格式中
//    public static <T> ResponseEntity<Pagination<T>> ok(IPage<T> page) {
//        return commonFunc(HttpStatus.OK.value(), new Pagination<>(page));
//    }
//
//    public static <T> ResponseEntity<T> status(Integer status, T data) {
//        return commonFunc(status, data);
//    }


}
