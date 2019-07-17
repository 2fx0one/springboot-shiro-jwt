package com.tfx0one.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfx0one.modules.app.entity.StockEntity;
import com.tfx0one.modules.app.service.StockService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 库存表，代表库存，秒杀库存等信息
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@RestController
@RequestMapping("app/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:stock:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = stockService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{skuId}")
    @RequiresPermissions("app:stock:info")
    public R info(@PathVariable("skuId") Long skuId){
		StockEntity stock = stockService.getById(skuId);

        return R.ok(stock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:stock:save")
    public R save(@RequestBody StockEntity stock){
		stockService.save(stock);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:stock:update")
    public R update(@RequestBody StockEntity stock){
		stockService.updateById(stock);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:stock:delete")
    public R delete(@RequestBody Long[] skuIds){
		stockService.removeByIds(Arrays.asList(skuIds));

        return R.ok("删除成功！");
    }

}
