package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.ec.dao.UserDao;
import com.tfx0one.modules.ec.entity.UserEntity;
import com.tfx0one.modules.ec.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new QueryPage<UserEntity>().getPage(params),
                new LambdaQueryWrapper<UserEntity>()
        );

        return new Pagination(page);
    }

}