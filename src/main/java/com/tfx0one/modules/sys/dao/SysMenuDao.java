package com.tfx0one.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfx0one.modules.sys.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单管理
 *
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {

    /**
     * 获取不包含按钮的菜单列表
     */
//    List<SysMenuEntity> queryNotButtonList();

}
