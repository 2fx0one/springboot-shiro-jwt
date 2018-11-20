package com.tfx0one.center.sys.model;

import com.tfx0one.common.base.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父级ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 菜单名字
     */
    private String name;

    /**
     * 菜单图片
     */
    private String icon;

    /**
     * 菜单类型
     */
    private Byte type;

    /**
     * 是否显示
     */
    private Byte show;

    /**
     * 菜单链接
     */
    private String permission;

    /**
     * 菜单URL
     */
    private String href;

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
     * 更新者
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

    public SysMenu withId(Integer id) {
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
     * 获取父级ID
     *
     * @return parent_id - 父级ID
     */
    public Integer getParentId() {
        return parentId;
    }

    public SysMenu withParentId(Integer parentId) {
        this.setParentId(parentId);
        return this;
    }

    /**
     * 设置父级ID
     *
     * @param parentId 父级ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Byte getSort() {
        return sort;
    }

    public SysMenu withSort(Byte sort) {
        this.setSort(sort);
        return this;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Byte sort) {
        this.sort = sort;
    }

    /**
     * 获取菜单名字
     *
     * @return name - 菜单名字
     */
    public String getName() {
        return name;
    }

    public SysMenu withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * 设置菜单名字
     *
     * @param name 菜单名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取菜单图片
     *
     * @return icon - 菜单图片
     */
    public String getIcon() {
        return icon;
    }

    public SysMenu withIcon(String icon) {
        this.setIcon(icon);
        return this;
    }

    /**
     * 设置菜单图片
     *
     * @param icon 菜单图片
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取菜单类型
     *
     * @return type - 菜单类型
     */
    public Byte getType() {
        return type;
    }

    public SysMenu withType(Byte type) {
        this.setType(type);
        return this;
    }

    /**
     * 设置菜单类型
     *
     * @param type 菜单类型
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取是否显示
     *
     * @return show - 是否显示
     */
    public Byte getShow() {
        return show;
    }

    public SysMenu withShow(Byte show) {
        this.setShow(show);
        return this;
    }

    /**
     * 设置是否显示
     *
     * @param show 是否显示
     */
    public void setShow(Byte show) {
        this.show = show;
    }

    /**
     * 获取菜单链接
     *
     * @return permission - 菜单链接
     */
    public String getPermission() {
        return permission;
    }

    public SysMenu withPermission(String permission) {
        this.setPermission(permission);
        return this;
    }

    /**
     * 设置菜单链接
     *
     * @param permission 菜单链接
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * 获取菜单URL
     *
     * @return href - 菜单URL
     */
    public String getHref() {
        return href;
    }

    public SysMenu withHref(String href) {
        this.setHref(href);
        return this;
    }

    /**
     * 设置菜单URL
     *
     * @param href 菜单URL
     */
    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    public SysMenu withCreateDate(Date createDate) {
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

    public SysMenu withUpdateDate(Date updateDate) {
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
     * 获取更新者
     *
     * @return create_by - 更新者
     */
    public String getCreateBy() {
        return createBy;
    }

    public SysMenu withCreateBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    /**
     * 设置更新者
     *
     * @param createBy 更新者
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

    public SysMenu withUpdateBy(String updateBy) {
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

    public SysMenu withRemarks(String remarks) {
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

    public SysMenu withDelFlag(Byte delFlag) {
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
        sb.append(", parentId=").append(parentId);
        sb.append(", sort=").append(sort);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", type=").append(type);
        sb.append(", show=").append(show);
        sb.append(", permission=").append(permission);
        sb.append(", href=").append(href);
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