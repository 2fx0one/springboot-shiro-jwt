package com.tfx0one.center.sys.model;

import com.tfx0one.common.base.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_office")
public class SysOffice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 部门名字
     */
    private String name;

    private Short sort;

    /**
     * 部门类型
     */
    private String type;

    /**
     * 部门等级
     */
    private String grade;

    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    private String fax;

    private String email;

    @Column(name = "primary_person")
    private String primaryPerson;

    @Column(name = "deputy_person")
    private String deputyPerson;

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
     * 删除标记 0：正常， -1：删除
     */
    @Column(name = "del_flag")
    private Byte delFlag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public SysOffice withId(Integer id) {
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
     * 获取父ID
     *
     * @return parent_id - 父ID
     */
    public Integer getParentId() {
        return parentId;
    }

    public SysOffice withParentId(Integer parentId) {
        this.setParentId(parentId);
        return this;
    }

    /**
     * 设置父ID
     *
     * @param parentId 父ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取部门名字
     *
     * @return name - 部门名字
     */
    public String getName() {
        return name;
    }

    public SysOffice withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * 设置部门名字
     *
     * @param name 部门名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return sort
     */
    public Short getSort() {
        return sort;
    }

    public SysOffice withSort(Short sort) {
        this.setSort(sort);
        return this;
    }

    /**
     * @param sort
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * 获取部门类型
     *
     * @return type - 部门类型
     */
    public String getType() {
        return type;
    }

    public SysOffice withType(String type) {
        this.setType(type);
        return this;
    }

    /**
     * 设置部门类型
     *
     * @param type 部门类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取部门等级
     *
     * @return grade - 部门等级
     */
    public String getGrade() {
        return grade;
    }

    public SysOffice withGrade(String grade) {
        this.setGrade(grade);
        return this;
    }

    /**
     * 设置部门等级
     *
     * @param grade 部门等级
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    public SysOffice withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return zip_code
     */
    public String getZipCode() {
        return zipCode;
    }

    public SysOffice withZipCode(String zipCode) {
        this.setZipCode(zipCode);
        return this;
    }

    /**
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * @return fax
     */
    public String getFax() {
        return fax;
    }

    public SysOffice withFax(String fax) {
        this.setFax(fax);
        return this;
    }

    /**
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    public SysOffice withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return primary_person
     */
    public String getPrimaryPerson() {
        return primaryPerson;
    }

    public SysOffice withPrimaryPerson(String primaryPerson) {
        this.setPrimaryPerson(primaryPerson);
        return this;
    }

    /**
     * @param primaryPerson
     */
    public void setPrimaryPerson(String primaryPerson) {
        this.primaryPerson = primaryPerson == null ? null : primaryPerson.trim();
    }

    /**
     * @return deputy_person
     */
    public String getDeputyPerson() {
        return deputyPerson;
    }

    public SysOffice withDeputyPerson(String deputyPerson) {
        this.setDeputyPerson(deputyPerson);
        return this;
    }

    /**
     * @param deputyPerson
     */
    public void setDeputyPerson(String deputyPerson) {
        this.deputyPerson = deputyPerson == null ? null : deputyPerson.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    public SysOffice withCreateDate(Date createDate) {
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

    public SysOffice withUpdateDate(Date updateDate) {
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

    public SysOffice withCreateBy(String createBy) {
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

    public SysOffice withUpdateBy(String updateBy) {
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

    public SysOffice withRemarks(String remarks) {
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
     * 获取删除标记 0：正常， -1：删除
     *
     * @return del_flag - 删除标记 0：正常， -1：删除
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    public SysOffice withDelFlag(Byte delFlag) {
        this.setDelFlag(delFlag);
        return this;
    }

    /**
     * 设置删除标记 0：正常， -1：删除
     *
     * @param delFlag 删除标记 0：正常， -1：删除
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
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", type=").append(type);
        sb.append(", grade=").append(grade);
        sb.append(", address=").append(address);
        sb.append(", zipCode=").append(zipCode);
        sb.append(", fax=").append(fax);
        sb.append(", email=").append(email);
        sb.append(", primaryPerson=").append(primaryPerson);
        sb.append(", deputyPerson=").append(deputyPerson);
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