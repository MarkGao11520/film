package com.gwf.family.business.category.controller;
import com.gwf.family.business.core.results.Result;
import com.gwf.family.business.core.results.ResultGenerator;
import com.gwf.family.business.category.entity.Category;
import com.gwf.family.business.category.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import java.util.List;

/**
* Created by gwf on 2017-10-20 11:37:15.
*/
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation("添加类目")
    public Result add(Category category) {
        categoryService.save(category);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation("删除类目")
    public Result delete(@ApiParam(value = "id") @PathVariable  Integer id) {
        categoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/{id:\\d+}")
    @ApiOperation("根据id修改类目")
    public Result update(Category category) {
        categoryService.update(category);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation("根据id查询类目详情")
    public Result detail(@ApiParam(value = "id")@PathVariable Integer id) {
        Category category = categoryService.findById(id);
        return ResultGenerator.genSuccessResult(category);
    }

    @GetMapping
    @ApiOperation("分页查询类目列表")
    public Result list(@ApiParam(value = "页数")@RequestParam(name = "page",defaultValue = "1") Integer page,
                       @ApiParam(value = "每页行数")@RequestParam(name = "size",defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<Category> list = categoryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
