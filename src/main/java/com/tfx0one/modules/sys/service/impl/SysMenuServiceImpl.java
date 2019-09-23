package com.tfx0one.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.utils.MapUtils;
import com.tfx0one.modules.sys.dao.SysMenuDao;
import com.tfx0one.modules.sys.entity.SysMenuEntity;
import com.tfx0one.modules.sys.service.SysMenuService;
import com.tfx0one.modules.sys.service.SysRoleMenuService;
import com.tfx0one.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    @Override
    public List<SysMenuEntity> listByParentId(Long parentId) {
        return this.list(
                Wrappers.<SysMenuEntity>lambdaQuery().eq(SysMenuEntity::getParentId, parentId).orderByAsc(SysMenuEntity::getOrderNum));
//        return baseMapper.queryListParentId(parentId);
    }

    @Override
    public List<SysMenuEntity> queryNotButtonList() {
        return this.list(
                Wrappers.<SysMenuEntity>lambdaQuery().ne(SysMenuEntity::getType, 2).orderByAsc(SysMenuEntity::getOrderNum));
    }

    @Override
    public List<SysMenuEntity> getUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if (userId == GlobalConstant.SUPER_ADMIN) {
            return getAllMenuRecursive(null);
        }

        //用户菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuRecursive(menuIdList);
    }

    @Override
    public void delete(Long menuId) {
        //删除菜单
        this.removeById(menuId);
        //删除菜单与角色关联
        sysRoleMenuService.removeByMap(new MapUtils().put("menu_id", menuId));
    }

    @Override
    public Boolean updateMenuById(SysMenuEntity menu) {
        return this.updateById(menu);
    }


    /**
     * 获取所有菜单列表
     */
    private List<SysMenuEntity> getAllMenuRecursive(List<Long> menuIdList) {
        //递归获取子菜单
        return getMenuTreeList(0L, menuIdList);

//        return parentList;
    }

    /**
     * 递归
     */
    private List<SysMenuEntity> getMenuTreeList(Long parentId, List<Long> menuIdList) {

        return listByParentId(parentId).stream()
                //节点过滤 需要用户持有的id
                .filter(menu -> menuIdList == null || menuIdList.contains(menu.getMenuId()))
                .peek(menu -> {
                    if (menu.getType() == GlobalConstant.MenuType.CATALOG.getValue()) {
                        //只递归目录
                        menu.setChildren(getMenuTreeList(menu.getMenuId(), menuIdList));
                    }
                })
                .collect(Collectors.toList());
    }
}
