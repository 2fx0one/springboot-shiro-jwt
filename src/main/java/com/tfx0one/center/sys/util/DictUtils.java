package com.tfx0one.center.sys.util;

import com.google.common.collect.Lists;
import com.tfx0one.center.sys.model.SysDict;
import com.tfx0one.center.sys.service.SysDictService;
import com.tfx0one.common.util.CacheUtils;
import com.tfx0one.common.util.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : 2fx0one
 * @date : 2018/11/28 17:02
 */
public class DictUtils {
    private static SysDictService sysDictService = SpringContextHolder.getBean(SysDictService.class);

    public static final String CACHE_DICT_MAP = "dictMap";

    public static String getDictLabel(String value, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)) {
            SysDict target = getDictList(type).stream()
                    .filter(d -> type.equals(d.getType()) && value.equals(d.getValue()))
                    .findFirst().orElse(new SysDict().withLabel(defaultValue));
            return target.getLabel();
        }
        return defaultValue;
    }

    public static String getDictLabels(String values, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)) {
            List<String> valueList = Lists.newArrayList();
            for (String value : StringUtils.split(values, ",")) {
                valueList.add(getDictLabel(value, type, defaultValue));
            }
            return StringUtils.join(valueList, ",");
        }
        return defaultValue;
    }

    public static String getDictValue(String label, String type, String defaultLabel) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
            SysDict target = getDictList(type).stream()
                    .filter(d -> type.equals(d.getType()) && label.equals(d.getLabel()))
                    .findFirst().orElse(new SysDict().withValue(defaultLabel));
            return target.getValue();
        }
        return defaultLabel;
    }

    private static List<SysDict> getDictList(String type) {
        Map<String, List<SysDict>> dictMap = CacheUtils.get(CACHE_DICT_MAP);

        dictMap = dictMap == null ? refreshDictMap() : dictMap;

        List<SysDict> dictList = dictMap.get(type);

        if (dictList == null) {
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    public static Map<String, List<SysDict>> refreshDictMap() {
        Map<String, List<SysDict>> dictMap = sysDictService.selectList(new SysDict()).stream().collect(Collectors.groupingBy(SysDict::getType));
        CacheUtils.put(CACHE_DICT_MAP, dictMap);
        return dictMap;
    }

}
