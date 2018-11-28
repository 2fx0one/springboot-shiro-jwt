package com.tfx0one.common.base;

/*
 * Create by 2fx0one on 2/6/18
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

//@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final byte DEL_FLAG_NORMAL = 0;
    public static final byte DEL_FLAG_DELETE = 1;
    public static final byte DEL_FLAG_AUDIT = 2;
}
