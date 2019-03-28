package com.tfx0one.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName: base-web
 * @author: 2fx0one
 * @date: 2019/1/23 09:17
 * @Version: 1.0
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    @TableField(exist = false)
    public static final String DEL_FLAG_NORMAL = "0";
    @TableField(exist = false)
    public static final String DEL_FLAG_DELETE = "1";
}
