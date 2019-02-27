package com.tfx0one.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.mapper.UserMapper;
import com.tfx0one.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 2fx0one
 * @since 2019-01-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User getByLoginName(String loginName) {
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getLoginName, loginName));
    }

    @Override
    public IPage<User> pageBy(User search, long pageNo, long pageSize) {
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        if (search.getOfficeId() != null) {
            query.eq(User::getOfficeId, search.getOfficeId());
        }
        return baseMapper.selectPage(new Page<>(pageNo, pageSize), query);
    }

}
