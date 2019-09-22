package com.tfx0one.modules.ec.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tfx0one.modules.ec.entity.CategoryEntity;
import com.tfx0one.modules.ec.service.CategoryService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-09-23 00:14:35
 */
@RestController
@RequestMapping("/ec/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("ec:category:list")
    public R<Pagination<CategoryEntity>> list(@RequestParam Map<String, Object> params, CategoryEntity category){
        Pagination<CategoryEntity> page = categoryService.queryPage(params, category);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("ec:category:info")
    public R<CategoryEntity> info(@PathVariable("id") Long id){
		CategoryEntity category = categoryService.getById(id);

        return R.ok(category);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("ec:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("ec:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("ec:category:delete")
    public R delete(@RequestBody Long[] ids){
		categoryService.removeByIds(Arrays.asList(ids));

        return R.ok("删除成功！");
    }

}
