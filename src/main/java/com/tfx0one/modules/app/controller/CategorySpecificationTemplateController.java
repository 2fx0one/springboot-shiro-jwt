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

import com.tfx0one.modules.app.entity.CategorySpecificationTemplateEntity;
import com.tfx0one.modules.app.service.CategorySpecificationTemplateService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 商品规格参数模板，json格式。
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:42:40
 */
@RestController
@RequestMapping("app/category/specification/template")
public class CategorySpecificationTemplateController {
    @Autowired
    private CategorySpecificationTemplateService categorySpecificationTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:categorySpecificationTemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = categorySpecificationTemplateService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{categoryId}")
    @RequiresPermissions("app:categorySpecificationTemplate:info")
    public R info(@PathVariable("categoryId") Long categoryId){
		CategorySpecificationTemplateEntity categorySpecificationTemplate = categorySpecificationTemplateService.getById(categoryId);

        return R.ok(categorySpecificationTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:categorySpecificationTemplate:save")
    public R save(@RequestBody CategorySpecificationTemplateEntity categorySpecificationTemplate){
		categorySpecificationTemplateService.save(categorySpecificationTemplate);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:categorySpecificationTemplate:update")
    public R update(@RequestBody CategorySpecificationTemplateEntity categorySpecificationTemplate){
		categorySpecificationTemplateService.updateById(categorySpecificationTemplate);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:categorySpecificationTemplate:delete")
    public R delete(@RequestBody Long[] categoryIds){
		categorySpecificationTemplateService.removeByIds(Arrays.asList(categoryIds));

        return R.ok("删除成功！");
    }

}
