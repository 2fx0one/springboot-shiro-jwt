package com.tfx0one.center.sys.model;

import com.tfx0one.common.base.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色用户前端展示的名字
     */
    @Column(name = "office_id")
    private Integer officeId;

    /**
     * 名称
     */
    private String name;

    /**
     * 数据范围
     */
    @Column(name = "data_scope")
    private Byte dataScope;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private Byte delFlag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public SysRole withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色用户前端展示的名字
     *
     * @return office_id - 角色用户前端展示的名字
     */
    public Integer getOfficeId() {
        return officeId;
    }

    public SysRole withOfficeId(Integer officeId) {
        this.setOfficeId(officeId);
        return this;
    }

    /**
     * 设置角色用户前端展示的名字
     *
     * @param officeId 角色用户前端展示的名字
     */
    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    public SysRole withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取数据范围
     *
     * @return data_scope - 数据范围
     */
    public Byte getDataScope() {
        return dataScope;
    }

    public SysRole withDataScope(Byte dataScope) {
        this.setDataScope(dataScope);
        return this;
    }

    /**
     * 设置数据范围
     *
     * @param dataScope 数据范围
     */
    public void setDataScope(Byte dataScope) {
        this.dataScope = dataScope;
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
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    public SysRole withRemarks(String remarks) {
        this.setRemarks(remarks);
        return this;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    public SysRole withDelFlag(Byte delFlag) {
        this.setDelFlag(delFlag);
        return this;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
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
        sb.append(", dataScope=").append(dataScope);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}