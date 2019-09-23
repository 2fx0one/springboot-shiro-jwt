package com.tfx0one.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.xss.SQLFilter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class Query {

    public static<T> IPage<T> page(Map<String, Object> params) {
        return getPage(params, null, false);
    }

    public static<T> IPage<T> getPage(Map<String, Object> params, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = 1;
        long limit = 10;

        if (params.get(GlobalConstant.PAGE) != null) {
            curPage = Long.parseLong((String) params.get(GlobalConstant.PAGE));
        }
        if (params.get(GlobalConstant.LIMIT) != null) {
            limit = Long.parseLong((String) params.get(GlobalConstant.LIMIT));
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //分页参数
        params.put(GlobalConstant.PAGE, page);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject((String) params.get(GlobalConstant.ORDER_FIELD));
        String order = (String) params.get(GlobalConstant.ORDER);

        //前端字段排序 如果前端给定分页参数
        if (StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)) {
            if (GlobalConstant.ASC.equalsIgnoreCase(order)) {
                return page.addOrder(OrderItem.asc(orderField));
            } else {
                return page.addOrder(OrderItem.desc(orderField));
            }
        }

        //没有排序字段，则不排序
        if (StringUtils.isBlank(defaultOrderField)) {
            return page;
        }

        //默认排序
        if (isAsc) {
            page.addOrder(OrderItem.asc(defaultOrderField));
        } else {
            page.addOrder(OrderItem.desc(defaultOrderField));
        }

        return page;
    }
}
