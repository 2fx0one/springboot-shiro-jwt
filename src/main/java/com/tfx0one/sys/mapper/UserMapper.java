package com.tfx0one.sys.mapper;

import com.tfx0one.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author kelvin
 * @since 2019-01-23
 */
public interface UserMapper extends BaseMapper<User> {
    User getByLoginName(@Param("loginName") String loginName);
}
