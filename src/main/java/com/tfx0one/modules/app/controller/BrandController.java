package com.tfx0one.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfx0one.modules.app.entity.BrandEntity;
import com.tfx0one.modules.app.service.BrandService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.R;



/**
 * 品牌表，一个品牌下有多个商品（spu），一对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@RestController
@RequestMapping("app/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = brandService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:brand:info")
    public R info(@PathVariable("id") Long id){
		BrandEntity brand = brandService.getById(id);

        return R.ok(brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:brand:save")
    public R save(@RequestBody BrandEntity brand){
		brandService.save(brand);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:brand:update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:brand:delete")
    public R delete(@RequestBody Long[] ids){
		brandService.removeByIds(Arrays.asList(ids));

        return R.ok("删除成功！");
    }

}
