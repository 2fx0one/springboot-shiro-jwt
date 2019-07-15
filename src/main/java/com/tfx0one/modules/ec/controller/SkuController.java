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

import com.tfx0one.modules.ec.entity.SkuEntity;
import com.tfx0one.modules.ec.service.SkuService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * sku表,该表表示具体的商品实体,如黑色的 64g的iphone 8
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@RestController
@RequestMapping("ec/sku")
public class SkuController {
    @Autowired
    private SkuService skuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ec:sku:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = skuService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ec:sku:info")
    public R info(@PathVariable("id") Long id){
		SkuEntity sku = skuService.getById(id);

        return R.ok(sku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ec:sku:save")
    public R save(@RequestBody SkuEntity sku){
		skuService.save(sku);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ec:sku:update")
    public R update(@RequestBody SkuEntity sku){
		skuService.updateById(sku);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ec:sku:delete")
    public R delete(@RequestBody Long[] ids){
		skuService.removeByIds(Arrays.asList(ids));

        return R.ok("删除成功！");
    }

}
