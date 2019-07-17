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

import com.tfx0one.modules.app.entity.SpuDetailEntity;
import com.tfx0one.modules.app.service.SpuDetailService;
import com.tfx0one.common.utils.Pagination;;
import com.tfx0one.common.utils.R;



/**
 * 
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@RestController
@RequestMapping("app/spu/detail")
public class SpuDetailController {
    @Autowired
    private SpuDetailService spuDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:spuDetail:list")
    public R list(@RequestParam Map<String, Object> params){
        Pagination page = spuDetailService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{spuId}")
    @RequiresPermissions("app:spuDetail:info")
    public R info(@PathVariable("spuId") Long spuId){
		SpuDetailEntity spuDetail = spuDetailService.getById(spuId);

        return R.ok(spuDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:spuDetail:save")
    public R save(@RequestBody SpuDetailEntity spuDetail){
		spuDetailService.save(spuDetail);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:spuDetail:update")
    public R update(@RequestBody SpuDetailEntity spuDetail){
		spuDetailService.updateById(spuDetail);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:spuDetail:delete")
    public R delete(@RequestBody Long[] spuIds){
		spuDetailService.removeByIds(Arrays.asList(spuIds));

        return R.ok("删除成功！");
    }

}
