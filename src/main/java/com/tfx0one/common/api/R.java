package com.tfx0one.common.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by 2fx0one on 2018/6/30.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("返回结果模型")
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(R.class);

    //    私有构造
    private R() {
        super();
    }

    //公共方法
    private static <T> ResponseEntity<T> commonFunc(int status, T data) {
        log.info("===ResponseEntity=== status:" + status + "  data:" + data);
        return ResponseEntity.status(status).body(data);
    }

    public static <T> ResponseEntity<T> ok(T data) {
        return commonFunc(HttpStatus.OK.value(), data);
    }

    //如果直接传 分页对象 特殊处理 需要把数据提取放到R对象的格式中
    public static <T> ResponseEntity<Pagination<T>> ok(IPage<T> page) {
        return commonFunc(HttpStatus.OK.value(), new Pagination<>(page));
    }

    public static <T> ResponseEntity<T> status(Integer status, T data) {
        return commonFunc(status, data);
    }


}
