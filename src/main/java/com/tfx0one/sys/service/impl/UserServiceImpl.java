package com.tfx0one.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
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
//        return baseMapper.selectOne(new LambdaQueryWrapper<>().select(i));
        return baseMapper.selectOne(new QueryWrapper<User>().eq("login_name", loginName));
    }
}
