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

import com.tfx0one.modules.app.entity.CategoryEntity;
import com.tfx0one.modules.app.service.CategoryService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:03
 */
@RestController
@RequestMapping("app/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:category:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = categoryService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("app:category:info")
    public R info(@PathVariable("id") Long id){
		CategoryEntity category = categoryService.getById(id);

        return R.ok(category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:category:delete")
    public R delete(@RequestBody Long[] ids){
		categoryService.removeByIds(Arrays.asList(ids));

        return R.ok("删除成功！");
    }

}
