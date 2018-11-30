package com.tfx0one.web.sys.entity;

import com.tfx0one.common.base.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole extends BaseEntity {
    /**
     * 归属机构
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 英文名称
     */
    private String enname;

    /**
     * 角色类型
     */
    @Column(name = "role_type")
    private String roleType;

    /**
     * 数据范围
     */
    @Column(name = "data_scope")
    private String dataScope;

    /**
     * 是否系统数据
     */
    @Column(name = "is_sys")
    private String isSys;

    /**
     * 是否可用
     */
    private String useable;


    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    public SysRole withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取归属机构
     *
     * @return office_id - 归属机构
     */
    public String getOfficeId() {
        return officeId;
    }

    public SysRole withOfficeId(String officeId) {
        this.setOfficeId(officeId);
        return this;
    }

    /**
     * 设置归属机构
     *
     * @param officeId 归属机构
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId == null ? null : officeId.trim();
    }

    /**
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    public SysRole withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取英文名称
     *
     * @return enname - 英文名称
     */
    public String getEnname() {
        return enname;
    }

    public SysRole withEnname(String enname) {
        this.setEnname(enname);
        return this;
    }

    /**
     * 设置英文名称
     *
     * @param enname 英文名称
     */
    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
    }

    /**
     * 获取角色类型
     *
     * @return role_type - 角色类型
     */
    public String getRoleType() {
        return roleType;
    }

    public SysRole withRoleType(String roleType) {
        this.setRoleType(roleType);
        return this;
    }

    /**
     * 设置角色类型
     *
     * @param roleType 角色类型
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    /**
     * 获取数据范围
     *
     * @return data_scope - 数据范围
     */
    public String getDataScope() {
        return dataScope;
    }

    public SysRole withDataScope(String dataScope) {
        this.setDataScope(dataScope);
        return this;
    }

    /**
     * 设置数据范围
     *
     * @param dataScope 数据范围
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope == null ? null : dataScope.trim();
    }

    /**
     * 获取是否系统数据
     *
     * @return is_sys - 是否系统数据
     */
    public String getIsSys() {
        return isSys;
    }

    public SysRole withIsSys(String isSys) {
        this.setIsSys(isSys);
        return this;
    }

    /**
     * 设置是否系统数据
     *
     * @param isSys 是否系统数据
     */
    public void setIsSys(String isSys) {
        this.isSys = isSys == null ? null : isSys.trim();
    }

    /**
     * 获取是否可用
     *
     * @return useable - 是否可用
     */
    public String getUseable() {
        return useable;
    }

    public SysRole withUseable(String useable) {
        this.setUseable(useable);
        return this;
    }

    /**
     * 设置是否可用
     *
     * @param useable 是否可用
     */
    public void setUseable(String useable) {
        this.useable = useable == null ? null : useable.trim();
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    public SysRole withCreateBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    public SysRole withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    public SysRole withUpdateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    public SysRole withUpdateDate(Date updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    public SysRole withRemarks(String remarks) {
        this.setRemarks(remarks);
        return this;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    public SysRole withDelFlag(String delFlag) {
        this.setDelFlag(delFlag);
        return this;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", officeId=").append(officeId);
        sb.append(", name=").append(name);
        sb.append(", enname=").append(enname);
        sb.append(", roleType=").append(roleType);
        sb.append(", dataScope=").append(dataScope);
        sb.append(", isSys=").append(isSys);
        sb.append(", useable=").append(useable);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}