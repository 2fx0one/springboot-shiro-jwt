package com.tfx0one.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tfx0one.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 机构表
 * </p>
 *
 * @author kelvin
 * @since 2019-01-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_office")
public class Office extends BaseEntity {

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
     * 归属区域
     */
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
    @TableField("USEABLE")
    private String useable;

    /**
     * 主负责人
     */
    @TableField("PRIMARY_PERSON")
    private String primaryPerson;

    /**
     * 副负责人
     */
    @TableField("DEPUTY_PERSON")
    private String deputyPerson;


}
