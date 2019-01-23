package com.tfx0one.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @projectName: base-web
 * @author: 2fx0one
 * @date: 2019/1/23 09:17
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
public class BaseEntity {

    private String id;
    /**
     * 创建者
     */

    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    @TableField("del_flag")
    private String delFlag;

}
