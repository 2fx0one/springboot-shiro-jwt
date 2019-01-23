package com.tfx0one.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tfx0one.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 日志表
 * </p>
 *
 * @author kelvin
 * @since 2019-01-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_log")
public class Log extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 日志类型
     */
    private String type;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 操作IP地址
     */
    private String remoteAddr;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 操作方式
     */
    private String method;

    /**
     * 操作提交的数据
     */
    private String params;

    /**
     * 异常信息
     */
    private String exception;


}
