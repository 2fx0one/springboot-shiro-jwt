package com.tfx0one.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tfx0one.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author 2fx0one
 * @since 2019-01-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父级编号
     */
    private String parentId;

    /**
     * 所有父级编号
     */
    private String parentIds;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private BigDecimal sort;

    /**
     * 链接
     */
    private String href;

    /**
     * 目标
     */
    private String target;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否在菜单中显示
     */
    private String isShow;

    /**
     * 权限标识
     */
    private String permission;


}
