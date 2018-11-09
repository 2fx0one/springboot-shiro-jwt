package com.tfx0one.common.base;

/*
 * Create by 2fx0one on 2/6/18
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // 主键ID
    protected String remarks; // 备注
    protected String createBy; // 创建者
    protected Date createDate; // 创建日期
    protected String updateBy; // 更新者
    protected Date updateDate; // 更新日期
    protected String delFlag; // 删除标记（0：正常；1：删除；2：审核）
}
