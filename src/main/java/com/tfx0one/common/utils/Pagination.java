package com.tfx0one.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auth 2fx0one
 * 2019/3/26 16:23
 */
@Data
@ApiModel("返回结果模型 包装IPage对象")
public class Pagination {
    private List<?> records;// 当前页数据
    //总记录数
    @ApiModelProperty(value = "总记录数", position = 1)
    protected Long total;

    @ApiModelProperty(value = "总页数", position = 3)
    private Long pages;

    @ApiModelProperty(value = "当前是第几页", position = 5)
    private Long current;

    @ApiModelProperty(value = "当前页记录的条数", position = 7)
    private Long size;

    public Pagination(IPage page) {
        this.total = page.getTotal();
        this.records = page.getRecords();
        this.pages = page.getPages();
        this.size = page.getSize();
        this.current = page.getCurrent();
    }
}
