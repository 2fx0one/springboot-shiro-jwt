package com.tfx0one.modules.ec.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tfx0one.modules.ec.entity.BrandEntity;
import com.tfx0one.modules.ec.service.BrandService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 品牌表，一个品牌下有多个商品（spu），一对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-09-22 23:17:30
 */
@RestController
@RequestMapping("/ec/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("ec:brand:list")
    public R<Pagination<BrandEntity>> list(@RequestParam Map<String, Object> params){
        Pagination<BrandEntity> page = brandService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("ec:brand:info")
    public R<BrandEntity> info(@PathVariable("id") Long id){
		BrandEntity brand = brandService.getById(id);

        return R.ok(brand);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("ec:brand:save")
    public R save(@RequestBody BrandEntity brand){
		brandService.save(brand);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("ec:brand:update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("ec:brand:delete")
    public R delete(@RequestBody Long[] ids){
		brandService.removeByIds(Arrays.asList(ids));

        return R.ok("删除成功！");
    }

}
