package com.tfx0one.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tfx0one.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 区域表
 * </p>
 *
 * @author 2fx0one
 * @since 2019-01-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_area")
public class Area extends BaseEntity {

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
     * 区域编码
     */
    private String code;

    /**
     * 区域类型
     */
    private String type;


}
