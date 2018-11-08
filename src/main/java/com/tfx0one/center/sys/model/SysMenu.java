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
    @Column(name = "sort_order")
    private Byte sortOrder;

    /**
     * 菜单名字
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单图片
     */
    private String icon;

    /**
     * 菜单描述
     */
    private String description;

    /**
     * 菜单链接
     */
    private String path;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * @return sort_order - 排序
     */
    public Byte getSortOrder() {
        return sortOrder;
    }

    public SysMenu withSortOrder(Byte sortOrder) {
        this.setSortOrder(sortOrder);
        return this;
    }

    /**
     * 设置排序
     *
     * @param sortOrder 排序
     */
    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取菜单名字
     *
     * @return menu_name - 菜单名字
     */
    public String getMenuName() {
        return menuName;
    }

    public SysMenu withMenuName(String menuName) {
        this.setMenuName(menuName);
        return this;
    }

    /**
     * 设置菜单名字
     *
     * @param menuName 菜单名字
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
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
     * 获取菜单描述
     *
     * @return description - 菜单描述
     */
    public String getDescription() {
        return description;
    }

    public SysMenu withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * 设置菜单描述
     *
     * @param description 菜单描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取菜单链接
     *
     * @return path - 菜单链接
     */
    public String getPath() {
        return path;
    }

    public SysMenu withPath(String path) {
        this.setPath(path);
        return this;
    }

    /**
     * 设置菜单链接
     *
     * @param path 菜单链接
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取菜单URL
     *
     * @return url - 菜单URL
     */
    public String getUrl() {
        return url;
    }

    public SysMenu withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    /**
     * 设置菜单URL
     *
     * @param url 菜单URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public SysMenu withCreateTime(Date createTime) {
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public SysMenu withUpdateTime(Date updateTime) {
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
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", menuName=").append(menuName);
        sb.append(", icon=").append(icon);
        sb.append(", description=").append(description);
        sb.append(", path=").append(path);
        sb.append(", url=").append(url);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}