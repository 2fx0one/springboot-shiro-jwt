package com.tfx0one.sys.service.impl;

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
 * @since 2019-03-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
