package com.gwf.family.business.language.controller;
import com.gwf.family.business.core.results.Result;
import com.gwf.family.business.core.results.ResultGenerator;
import com.gwf.family.business.language.entity.Language;
import com.gwf.family.business.language.service.LanguageService;
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
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @PostMapping
    @ApiOperation("添加语言")
    public Result add(Language language) {
        languageService.save(language);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation("删除语言")
    public Result delete(@ApiParam(value = "id") @PathVariable  Integer id) {
        languageService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/{id:\\d+}")
    @ApiOperation("根据id修改语言")
    public Result update(Language language) {
        languageService.update(language);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation("根据id查询语言详情")
    public Result detail(@ApiParam(value = "id")@PathVariable Integer id) {
        Language language = languageService.findById(id);
        return ResultGenerator.genSuccessResult(language);
    }

    @GetMapping
    @ApiOperation("分页查询语言列表")
    public Result list(@ApiParam(value = "页数")@RequestParam(name = "page",defaultValue = "1") Integer page,
                       @ApiParam(value = "每页行数")@RequestParam(name = "size",defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<Language> list = languageService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
