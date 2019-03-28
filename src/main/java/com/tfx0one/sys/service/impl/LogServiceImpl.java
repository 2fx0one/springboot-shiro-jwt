package com.tfx0one.sys.service.impl;

import com.tfx0one.sys.entity.Log;
import com.tfx0one.sys.mapper.LogMapper;
import com.tfx0one.sys.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author 2fx0one
 * @since 2019-03-28
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
