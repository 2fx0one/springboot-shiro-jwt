package com.tfx0one.modules.sys.dao;

import com.tfx0one.modules.sys.entity.SysDeptEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门管理
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2020-04-14 17:30:08
 */
@Mapper
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {
	
}
