package com.tfx0one.common.shiro;

import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.sys.entity.Menu;
import com.tfx0one.sys.entity.Role;
import com.tfx0one.sys.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ShiroService {

    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId) {
//        User user = (User) principals.getPrimaryPrincipal();
//        List<Role> roleList = user.getRoleList();
//
//        //角色字符串
//        List<String> roles = roleList.stream().map(Role::getRoleType).collect(Collectors.toList());
//        simpleAuthorizationInfo.addRoles(roles);
//
//        //权限字符串
//        Set<String> permissions = user.getMenuList().stream()
////                .map(Role::getMenuList).flatMap(Collection::stream)
//                .map(Menu::getPermission).filter(StringUtils::isNotEmpty) //过滤空
//                .flatMap(s -> Arrays.stream(s.split(GlobalConstant.SPLIT_DELIMETER)))
////                .sorted()
//                .collect(Collectors.toSet());
        return null;
    }

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    User queryUser(Long userId){
        return null;
    }
}
