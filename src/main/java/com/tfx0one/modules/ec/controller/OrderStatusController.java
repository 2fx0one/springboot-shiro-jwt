package com.tfx0one.modules.ec.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfx0one.modules.ec.entity.OrderStatusEntity;
import com.tfx0one.modules.ec.service.OrderStatusService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 订单状态表
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@RestController
@RequestMapping("ec/orderstatus")
public class OrderStatusController {
    @Autowired
    private OrderStatusService orderStatusService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ec:orderstatus:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = orderStatusService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderId}")
    @RequiresPermissions("ec:orderstatus:info")
    public R info(@PathVariable("orderId") Long orderId){
		OrderStatusEntity orderStatus = orderStatusService.getById(orderId);

        return R.ok(orderStatus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ec:orderstatus:save")
    public R save(@RequestBody OrderStatusEntity orderStatus){
		orderStatusService.save(orderStatus);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ec:orderstatus:update")
    public R update(@RequestBody OrderStatusEntity orderStatus){
		orderStatusService.updateById(orderStatus);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ec:orderstatus:delete")
    public R delete(@RequestBody Long[] orderIds){
		orderStatusService.removeByIds(Arrays.asList(orderIds));

        return R.ok("删除成功！");
    }

}
