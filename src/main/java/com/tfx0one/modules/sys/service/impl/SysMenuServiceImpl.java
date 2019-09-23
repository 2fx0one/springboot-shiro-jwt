package com.tfx0one.modules.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.utils.MapUtils;
import com.tfx0one.modules.sys.dao.SysMenuDao;
import com.tfx0one.modules.sys.entity.SysMenuEntity;
import com.tfx0one.modules.sys.service.SysMenuService;
import com.tfx0one.modules.sys.service.SysRoleMenuService;
import com.tfx0one.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<SysMenuEntity> listByParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenuEntity> parentList = listByParentId(parentId);

        return parentList.stream()
                .filter(menu -> menuIdList == null || menuIdList.contains(menu.getMenuId()))
                .collect(Collectors.toList());

//        if (menuIdList == null) {
//            return parentList;
//        } else {
//            return parentList.stream()
//                    .filter(menu -> menuIdList == null || menuIdList.contains(menu.getMenuId()))
//                    .collect(Collectors.toList());
//        }


//        List<SysMenuEntity> tempList = new ArrayList<>();
//        for (SysMenuEntity menu : parentList) {
//            if (menuIdList.contains(menu.getMenuId())) {
//                tempList.add(menu);
//            }
//        }
//        return tempList;
    }

    @Override
    public List<SysMenuEntity> listByParentId(Long parentId) {
        return baseMapper.queryListParentId(parentId);
    }

    @Override
    public List<SysMenuEntity> queryNotButtonList() {
        return baseMapper.queryNotButtonList();
    }

    @Override
    public List<SysMenuEntity> getUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if (userId == GlobalConstant.SUPER_ADMIN) {
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    @Override
    public void delete(Long menuId) {
        //删除菜单
        this.removeById(menuId);
        //删除菜单与角色关联
        sysRoleMenuService.removeByMap(new MapUtils().put("menu_id", menuId));
    }

    /**
     * 获取所有菜单列表
     */
    private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList) {
        //查询根菜单列表
        List<SysMenuEntity> parentList = listByParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(parentList, menuIdList);

        return parentList;
    }

    /**
     * 递归
     */
    private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> parentList, List<Long> menuIdList) {
//        List<SysMenuEntity> subMenuList = new ArrayList<>();

        parentList.stream()
                .filter(menu -> menu.getType() == GlobalConstant.MenuType.CATALOG.getValue())
                .forEach(
                        menu -> menu.setChildren(getMenuTreeList(listByParentId(menu.getMenuId(), menuIdList), menuIdList))
                );
//        for (SysMenuEntity entity : parentList) {
//            //目录
//            if (entity.getType() == Constant.MenuType.CATALOG.getValue()) {
//                entity.setChildren(getMenuTreeList(listByParentId(entity.getMenuId(), menuIdList), menuIdList));
//            }
//            subMenuList.add(entity);
//        }

        return parentList;
    }
}
