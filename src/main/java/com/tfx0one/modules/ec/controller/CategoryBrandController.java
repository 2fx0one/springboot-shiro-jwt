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

import com.tfx0one.modules.ec.entity.CategoryBrandEntity;
import com.tfx0one.modules.ec.service.CategoryBrandService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 商品分类和品牌的中间表，两者是多对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@RestController
@RequestMapping("ec/categorybrand")
public class CategoryBrandController {
    @Autowired
    private CategoryBrandService categoryBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ec:categorybrand:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = categoryBrandService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{categoryId}")
    @RequiresPermissions("ec:categorybrand:info")
    public R info(@PathVariable("categoryId") Long categoryId){
		CategoryBrandEntity categoryBrand = categoryBrandService.getById(categoryId);

        return R.ok(categoryBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ec:categorybrand:save")
    public R save(@RequestBody CategoryBrandEntity categoryBrand){
		categoryBrandService.save(categoryBrand);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ec:categorybrand:update")
    public R update(@RequestBody CategoryBrandEntity categoryBrand){
		categoryBrandService.updateById(categoryBrand);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ec:categorybrand:delete")
    public R delete(@RequestBody Long[] categoryIds){
		categoryBrandService.removeByIds(Arrays.asList(categoryIds));

        return R.ok("删除成功！");
    }

}
