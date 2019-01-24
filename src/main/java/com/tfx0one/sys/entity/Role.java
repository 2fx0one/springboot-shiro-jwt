package com.tfx0one.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tfx0one.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 2fx0one
 * @since 2019-01-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 归属机构
     */
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
    private String roleType;

    /**
     * 数据范围
     */
    private String dataScope;

    /**
     * 是否系统数据
     */
    private String isSys;

    /**
     * 是否可用
     */
    private String useable;


}
