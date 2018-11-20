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

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final byte DEL_FLAG_NORMAL = 0;
    public static final byte DEL_FLAG_DELETE = 1;
    public static final byte DEL_FLAG_AUDIT = 2;

    private static final long serialVersionUID = 1L;

    private Integer id; // 主键ID
    /**
     * 创建者
     */
    protected String createBy;

    /**
     * 创建时间
     */
    protected Date createDate;

    /**
     * 更新着
     */
    protected String updateBy;

    /**
     * 更新时间
     */
    protected Date updateDate;

    /**
     * 备注
     */
    protected String remarks;

    protected Byte delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}
