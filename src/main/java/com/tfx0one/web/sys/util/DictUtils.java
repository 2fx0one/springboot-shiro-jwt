package com.tfx0one.web.sys.util;

import com.tfx0one.common.util.CacheUtils;
import com.tfx0one.common.util.SpringContextHolder;
import com.tfx0one.web.sys.entity.SysDict;
import com.tfx0one.web.sys.service.SysDictService;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
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


    public static String getDictLabel(String value, String type, String defaultLabel) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)) {
            for (SysDict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
                    return dict.getLabel();
                }
            }
        }
        return defaultLabel;
    }

    public static String getDictLabels(String values, String type, String defaultLabels) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)) {
            List<String> valueList = Arrays.asList(StringUtils.split(values, ","));
            return getDictList(type).stream()
                    .filter(d -> valueList.contains(d.getValue()))
                    .map(SysDict::getLabel)
                    .collect(Collectors.joining(","));
        }
        return defaultLabels;
    }

    private static SysDict getDict(String type, String value) {
        return getDictList(type).stream().filter(d -> value.equals(d.getValue())).findFirst().orElse(new SysDict());
    }

    private static List<SysDict> getDictList(String type) {
        List<SysDict> dictList = getDictMap().get(type);
        return dictList == null ? Collections.emptyList() : dictList;
    }


    public static Map<String, List<SysDict>> getDictMap() {
        Map<String, List<SysDict>> dictMap = CacheUtils.get(CACHE_DICT_MAP);
        return dictMap == null ? refreshDictMap() : dictMap;
    }

    public static Map<String, List<SysDict>> refreshDictMap() {
        Map<String, List<SysDict>> dictMap = sysDictService.list(new SysDict()).stream().collect(Collectors.groupingBy(SysDict::getType));
        CacheUtils.put(CACHE_DICT_MAP, dictMap);
        return dictMap;
    }

}
