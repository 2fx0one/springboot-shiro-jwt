package com.tfx0one.center.sys.model;

import com.tfx0one.common.base.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 机构Id
     */
    @Column(name = "office_id")
    private Integer officeId;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户类型（管理员， 普通用户）
     */
    @Column(name = "user_type")
    private Byte userType;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 登录地址
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 登录时间
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * 前端展示名字
     */
    @Column(name = "dispaly_name")
    private String dispalyName;

    /**
     * 工号
     */
    private String no;

    /**
     * 电话
     */
    private String telphone;

    /**
     * 手机号
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新着
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String remarks;

    @Column(name = "del_flag")
    private Byte delFlag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public SysUser withId(Integer id) {
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
     * 获取机构Id
     *
     * @return office_id - 机构Id
     */
    public Integer getOfficeId() {
        return officeId;
    }

    public SysUser withOfficeId(Integer officeId) {
        this.setOfficeId(officeId);
        return this;
    }

    /**
     * 设置机构Id
     *
     * @param officeId 机构Id
     */
    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取登录账号
     *
     * @return username - 登录账号
     */
    public String getUsername() {
        return username;
    }

    public SysUser withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    /**
     * 设置登录账号
     *
     * @param username 登录账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    public SysUser withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户类型（管理员， 普通用户）
     *
     * @return user_type - 用户类型（管理员， 普通用户）
     */
    public Byte getUserType() {
        return userType;
    }

    public SysUser withUserType(Byte userType) {
        this.setUserType(userType);
        return this;
    }

    /**
     * 设置用户类型（管理员， 普通用户）
     *
     * @param userType 用户类型（管理员， 普通用户）
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * 获取电子邮件
     *
     * @return email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    public SysUser withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取登录地址
     *
     * @return login_ip - 登录地址
     */
    public String getLoginIp() {
        return loginIp;
    }

    public SysUser withLoginIp(String loginIp) {
        this.setLoginIp(loginIp);
        return this;
    }

    /**
     * 设置登录地址
     *
     * @param loginIp 登录地址
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 获取登录时间
     *
     * @return login_date - 登录时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    public SysUser withLoginDate(Date loginDate) {
        this.setLoginDate(loginDate);
        return this;
    }

    /**
     * 设置登录时间
     *
     * @param loginDate 登录时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取前端展示名字
     *
     * @return dispaly_name - 前端展示名字
     */
    public String getDispalyName() {
        return dispalyName;
    }

    public SysUser withDispalyName(String dispalyName) {
        this.setDispalyName(dispalyName);
        return this;
    }

    /**
     * 设置前端展示名字
     *
     * @param dispalyName 前端展示名字
     */
    public void setDispalyName(String dispalyName) {
        this.dispalyName = dispalyName == null ? null : dispalyName.trim();
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
     * 获取电话
     *
     * @return telphone - 电话
     */
    public String getTelphone() {
        return telphone;
    }

    public SysUser withTelphone(String telphone) {
        this.setTelphone(telphone);
        return this;
    }

    /**
     * 设置电话
     *
     * @param telphone 电话
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile_phone - 手机号
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    public SysUser withMobilePhone(String mobilePhone) {
        this.setMobilePhone(mobilePhone);
        return this;
    }

    /**
     * 设置手机号
     *
     * @param mobilePhone 手机号
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
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
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public SysUser withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新着
     *
     * @return update_by - 更新着
     */
    public String getUpdateBy() {
        return updateBy;
    }

    public SysUser withUpdateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    /**
     * 设置更新着
     *
     * @param updateBy 更新着
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public SysUser withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    public SysUser withRemarks(String remarks) {
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
     * @return del_flag
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    public SysUser withDelFlag(Byte delFlag) {
        this.setDelFlag(delFlag);
        return this;
    }

    /**
     * @param delFlag
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
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", userType=").append(userType);
        sb.append(", email=").append(email);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", dispalyName=").append(dispalyName);
        sb.append(", no=").append(no);
        sb.append(", telphone=").append(telphone);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}