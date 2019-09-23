

package com.tfx0one.modules.oss.cloud;


import com.tfx0one.common.constant.ConfigConstant;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.utils.SpringContextUtils;
import com.tfx0one.modules.sys.service.SysConfigService;

/**
 * 文件上传Factory
 *
 */
public final class OSSFactory {
    private static SysConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == GlobalConstant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == GlobalConstant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == GlobalConstant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }

        return null;
    }

}
