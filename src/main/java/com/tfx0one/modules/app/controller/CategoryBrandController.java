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

import com.tfx0one.modules.app.entity.CategoryBrandEntity;
import com.tfx0one.modules.app.service.CategoryBrandService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 商品分类和品牌的中间表，两者是多对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@RestController
@RequestMapping("app/category/brand")
public class CategoryBrandController {
    @Autowired
    private CategoryBrandService categoryBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:categoryBrand:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = categoryBrandService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{categoryId}")
    @RequiresPermissions("app:categoryBrand:info")
    public R info(@PathVariable("categoryId") Long categoryId){
		CategoryBrandEntity categoryBrand = categoryBrandService.getById(categoryId);

        return R.ok(categoryBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:categoryBrand:save")
    public R save(@RequestBody CategoryBrandEntity categoryBrand){
		categoryBrandService.save(categoryBrand);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:categoryBrand:update")
    public R update(@RequestBody CategoryBrandEntity categoryBrand){
		categoryBrandService.updateById(categoryBrand);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:categoryBrand:delete")
    public R delete(@RequestBody Long[] categoryIds){
		categoryBrandService.removeByIds(Arrays.asList(categoryIds));

        return R.ok("删除成功！");
    }

}
