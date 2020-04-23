package com.tfx0one.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 部门管理
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2020-04-14 17:30:08
 */
@Data
@TableName("sys_dept")
@Accessors(chain = true)
public class SysDeptEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer deptId;
	/**
	 * 
	 */
	private Integer parentId;

	private String parentIds;
	/**
	 * 
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;
	/**
	 * 
	 */
	private Integer tenantId;
	/**
	 * 
	 */
	private String delFlag;

}
