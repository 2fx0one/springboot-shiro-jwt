package com.tfx0one.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.tfx0one.common.exception.CommonException;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.Query;
import com.tfx0one.modules.sys.dao.SysConfigDao;
import com.tfx0one.modules.sys.entity.SysConfigEntity;
import com.tfx0one.modules.sys.service.SysConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Map;

@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao, SysConfigEntity> implements SysConfigService {

    @Override
    public Pagination queryPage(Map<String, Object> params, SysConfigEntity sysConfig) {
        String paramKey = sysConfig.getParamKey();//  (String)params.get("paramKey");

        IPage<SysConfigEntity> page = this.page(
                Query.page(params),
                Wrappers.<SysConfigEntity>lambdaQuery()
                        .like(StringUtils.isNotBlank(paramKey), SysConfigEntity::getParamKey, paramKey)
                        .eq(SysConfigEntity::getParamKey, 1)
        );

        return Pagination.create(page);
    }

    @Override
    public void saveConfig(SysConfigEntity config) {
        this.save(config);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysConfigEntity config) {
        this.updateById(config);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateValueByKey(String key, String value) {
        baseMapper.updateValueByKey(key, value);
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(Long[] ids) {
		for(Long id : ids){
			SysConfigEntity config = this.getById(id);
//			sysConfigRedis.delete(config.getParamKey());
		}

        this.removeByIds(Arrays.asList(ids));
    }

    @Override
    @Cacheable(value = "sys:config", key = "#key")
    public String getValue(String key) {
        SysConfigEntity config = baseMapper.queryByKey(key);

        return config == null ? null : config.getParamValue();
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if (StringUtils.isNotBlank(value)) {
            return new Gson().fromJson(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new CommonException("获取参数失败");
        }
    }
}
