package com.tfx0one.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.sys.entity.SysDeptEntity;
import com.tfx0one.modules.sys.service.SysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tfx0one.common.utils.R;



/**
 * 部门管理
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2020-04-14 17:30:08
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:dept:list")
    public R<Pagination<SysDeptEntity>> list(@RequestParam Map<String, Object> params, SysDeptEntity dept){
        Pagination<SysDeptEntity> page = sysDeptService.queryPage(params, dept);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{deptId}")
    @RequiresPermissions("sys:dept:info")
    public R<SysDeptEntity> info(@PathVariable("deptId") Integer deptId){
        SysDeptEntity dept = sysDeptService.getById(deptId);

        return R.ok(dept);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("sys:dept:save")
    public R save(@RequestBody SysDeptEntity dept){
        sysDeptService.save(dept);

        return R.ok("保存成功！");
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("sys:dept:update")
    public R update(@RequestBody SysDeptEntity dept){
        sysDeptService.updateById(dept);

        return R.ok("修改成功！");
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("sys:dept:delete")
    public R delete(@RequestBody Integer[] deptIds){
        sysDeptService.removeByIds(Arrays.asList(deptIds));

        return R.ok("删除成功！");
    }

}
