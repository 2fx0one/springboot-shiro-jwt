package com.tfx0one.center.sys.model;

import com.tfx0one.common.base.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_office")
public class SysOffice extends BaseEntity {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 父级编号
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 所有父级编号
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 归属区域
     */
    @Column(name = "area_id")
    private String areaId;

    /**
     * 区域编码
     */
    private String code;

    /**
     * 机构类型
     */
    private String type;

    /**
     * 机构等级
     */
    private String grade;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 邮政编码
     */
    @Column(name = "zip_code")
    private String zipCode;

    /**
     * 负责人
     */
    private String master;

    /**
     * 电话
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否启用
     */
    @Column(name = "USEABLE")
    private String useable;

    /**
     * 主负责人
     */
    @Column(name = "PRIMARY_PERSON")
    private String primaryPerson;

    /**
     * 副负责人
     */
    @Column(name = "DEPUTY_PERSON")
    private String deputyPerson;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    public SysOffice withId(String id) {
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
     * 获取父级编号
     *
     * @return parent_id - 父级编号
     */
    public String getParentId() {
        return parentId;
    }

    public SysOffice withParentId(String parentId) {
        this.setParentId(parentId);
        return this;
    }

    /**
     * 设置父级编号
     *
     * @param parentId 父级编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取所有父级编号
     *
     * @return parent_ids - 所有父级编号
     */
    public String getParentIds() {
        return parentIds;
    }

    public SysOffice withParentIds(String parentIds) {
        this.setParentIds(parentIds);
        return this;
    }

    /**
     * 设置所有父级编号
     *
     * @param parentIds 所有父级编号
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    public SysOffice withName(String name) {
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
     * 获取排序
     *
     * @return sort - 排序
     */
    public Long getSort() {
        return sort;
    }

    public SysOffice withSort(Long sort) {
        this.setSort(sort);
        return this;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 获取归属区域
     *
     * @return area_id - 归属区域
     */
    public String getAreaId() {
        return areaId;
    }

    public SysOffice withAreaId(String areaId) {
        this.setAreaId(areaId);
        return this;
    }

    /**
     * 设置归属区域
     *
     * @param areaId 归属区域
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**
     * 获取区域编码
     *
     * @return code - 区域编码
     */
    public String getCode() {
        return code;
    }

    public SysOffice withCode(String code) {
        this.setCode(code);
        return this;
    }

    /**
     * 设置区域编码
     *
     * @param code 区域编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取机构类型
     *
     * @return type - 机构类型
     */
    public String getType() {
        return type;
    }

    public SysOffice withType(String type) {
        this.setType(type);
        return this;
    }

    /**
     * 设置机构类型
     *
     * @param type 机构类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取机构等级
     *
     * @return grade - 机构等级
     */
    public String getGrade() {
        return grade;
    }

    public SysOffice withGrade(String grade) {
        this.setGrade(grade);
        return this;
    }

    /**
     * 设置机构等级
     *
     * @param grade 机构等级
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    /**
     * 获取联系地址
     *
     * @return address - 联系地址
     */
    public String getAddress() {
        return address;
    }

    public SysOffice withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    /**
     * 设置联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取邮政编码
     *
     * @return zip_code - 邮政编码
     */
    public String getZipCode() {
        return zipCode;
    }

    public SysOffice withZipCode(String zipCode) {
        this.setZipCode(zipCode);
        return this;
    }

    /**
     * 设置邮政编码
     *
     * @param zipCode 邮政编码
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * 获取负责人
     *
     * @return master - 负责人
     */
    public String getMaster() {
        return master;
    }

    public SysOffice withMaster(String master) {
        this.setMaster(master);
        return this;
    }

    /**
     * 设置负责人
     *
     * @param master 负责人
     */
    public void setMaster(String master) {
        this.master = master == null ? null : master.trim();
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    public SysOffice withPhone(String phone) {
        this.setPhone(phone);
        return this;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取传真
     *
     * @return fax - 传真
     */
    public String getFax() {
        return fax;
    }

    public SysOffice withFax(String fax) {
        this.setFax(fax);
        return this;
    }

    /**
     * 设置传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    public SysOffice withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取是否启用
     *
     * @return USEABLE - 是否启用
     */
    public String getUseable() {
        return useable;
    }

    public SysOffice withUseable(String useable) {
        this.setUseable(useable);
        return this;
    }

    /**
     * 设置是否启用
     *
     * @param useable 是否启用
     */
    public void setUseable(String useable) {
        this.useable = useable == null ? null : useable.trim();
    }

    /**
     * 获取主负责人
     *
     * @return PRIMARY_PERSON - 主负责人
     */
    public String getPrimaryPerson() {
        return primaryPerson;
    }

    public SysOffice withPrimaryPerson(String primaryPerson) {
        this.setPrimaryPerson(primaryPerson);
        return this;
    }

    /**
     * 设置主负责人
     *
     * @param primaryPerson 主负责人
     */
    public void setPrimaryPerson(String primaryPerson) {
        this.primaryPerson = primaryPerson == null ? null : primaryPerson.trim();
    }

    /**
     * 获取副负责人
     *
     * @return DEPUTY_PERSON - 副负责人
     */
    public String getDeputyPerson() {
        return deputyPerson;
    }

    public SysOffice withDeputyPerson(String deputyPerson) {
        this.setDeputyPerson(deputyPerson);
        return this;
    }

    /**
     * 设置副负责人
     *
     * @param deputyPerson 副负责人
     */
    public void setDeputyPerson(String deputyPerson) {
        this.deputyPerson = deputyPerson == null ? null : deputyPerson.trim();
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
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    public SysOffice withRemarks(String remarks) {
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

    public SysOffice withDelFlag(String delFlag) {
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
        sb.append(", parentId=").append(parentId);
        sb.append(", parentIds=").append(parentIds);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", areaId=").append(areaId);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", grade=").append(grade);
        sb.append(", address=").append(address);
        sb.append(", zipCode=").append(zipCode);
        sb.append(", master=").append(master);
        sb.append(", phone=").append(phone);
        sb.append(", fax=").append(fax);
        sb.append(", email=").append(email);
        sb.append(", useable=").append(useable);
        sb.append(", primaryPerson=").append(primaryPerson);
        sb.append(", deputyPerson=").append(deputyPerson);
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