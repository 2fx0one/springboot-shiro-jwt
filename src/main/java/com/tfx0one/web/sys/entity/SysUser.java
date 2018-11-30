package com.tfx0one.web.sys.entity;

import com.tfx0one.common.base.BaseEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser extends BaseEntity {
    /**
     * 归属公司
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 归属部门
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 最后登陆IP
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 最后登陆时间
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * 是否可登录
     */
    @Column(name = "login_flag")
    private String loginFlag;

   @Transient
   private List<SysRole> roleList;

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    public SysUser withId(String id) {
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
     * 获取归属公司
     *
     * @return company_id - 归属公司
     */
    public String getCompanyId() {
        return companyId;
    }

    public SysUser withCompanyId(String companyId) {
        this.setCompanyId(companyId);
        return this;
    }

    /**
     * 设置归属公司
     *
     * @param companyId 归属公司
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * 获取归属部门
     *
     * @return office_id - 归属部门
     */
    public String getOfficeId() {
        return officeId;
    }

    public SysUser withOfficeId(String officeId) {
        this.setOfficeId(officeId);
        return this;
    }

    /**
     * 设置归属部门
     *
     * @param officeId 归属部门
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId == null ? null : officeId.trim();
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    public SysUser withLoginName(String loginName) {
        this.setLoginName(loginName);
        return this;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    public SysUser withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取工号
     *
     * @return no - 工号
     */
    public String getNo() {
        return no;
    }

    public SysUser withNo(String no) {
        this.setNo(no);
        return this;
    }

    /**
     * 设置工号
     *
     * @param no 工号
     */
    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    public SysUser withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    public SysUser withEmail(String email) {
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
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    public SysUser withPhone(String phone) {
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
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    public SysUser withMobile(String mobile) {
        this.setMobile(mobile);
        return this;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public String getUserType() {
        return userType;
    }

    public SysUser withUserType(String userType) {
        this.setUserType(userType);
        return this;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取用户头像
     *
     * @return photo - 用户头像
     */
    public String getPhoto() {
        return photo;
    }

    public SysUser withPhoto(String photo) {
        this.setPhoto(photo);
        return this;
    }

    /**
     * 设置用户头像
     *
     * @param photo 用户头像
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 获取最后登陆IP
     *
     * @return login_ip - 最后登陆IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    public SysUser withLoginIp(String loginIp) {
        this.setLoginIp(loginIp);
        return this;
    }

    /**
     * 设置最后登陆IP
     *
     * @param loginIp 最后登陆IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 获取最后登陆时间
     *
     * @return login_date - 最后登陆时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    public SysUser withLoginDate(Date loginDate) {
        this.setLoginDate(loginDate);
        return this;
    }

    /**
     * 设置最后登陆时间
     *
     * @param loginDate 最后登陆时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取是否可登录
     *
     * @return login_flag - 是否可登录
     */
    public String getLoginFlag() {
        return loginFlag;
    }

    public SysUser withLoginFlag(String loginFlag) {
        this.setLoginFlag(loginFlag);
        return this;
    }

    /**
     * 设置是否可登录
     *
     * @param loginFlag 是否可登录
     */
    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag == null ? null : loginFlag.trim();
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    public SysUser withCreateBy(String createBy) {
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

    public SysUser withCreateDate(Date createDate) {
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

    public SysUser withUpdateBy(String updateBy) {
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

    public SysUser withUpdateDate(Date updateDate) {
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

    public SysUser withRemarks(String remarks) {
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

    public SysUser withDelFlag(String delFlag) {
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
        sb.append(", companyId=").append(companyId);
        sb.append(", officeId=").append(officeId);
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append(", no=").append(no);
        sb.append(", name=").append(name);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", mobile=").append(mobile);
        sb.append(", userType=").append(userType);
        sb.append(", photo=").append(photo);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", loginFlag=").append(loginFlag);
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