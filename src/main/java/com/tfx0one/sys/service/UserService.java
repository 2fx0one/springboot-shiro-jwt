package com.tfx0one.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tfx0one.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 2fx0one
 * @since 2019-01-24
 */
public interface UserService extends IService<User> {

    User getByLoginName(String username);

    IPage<User> listBySearch();
}
