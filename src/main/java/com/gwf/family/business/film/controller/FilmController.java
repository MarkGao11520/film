package com.gwf.family.business.film.controller;
import com.gwf.family.business.core.results.Result;
import com.gwf.family.business.core.results.ResultGenerator;
import com.gwf.family.business.film.dto.FilmQueryCondition;
import com.gwf.family.business.film.dto.FilmResult;
import com.gwf.family.business.film.entity.Film;
import com.gwf.family.business.film.service.FilmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import java.util.List;

/**
* Created by gwf on 2017-10-19 21:50:28.
*/
@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @PostMapping
    @ApiOperation("添加电影")
    public Result add(Film film) {
        filmService.save(film);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation("删除电影")
    public Result delete(@ApiParam(value = "id") @PathVariable  Integer id) {
        filmService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/{id:\\d+}")
    @ApiOperation("根据id修改电影")
    public Result update(Film film) {
        filmService.update(film);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation("根据id查询电影详情")
    public Result detail(@ApiParam(value = "id")@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return ResultGenerator.genSuccessResult(film);
    }

    @GetMapping
    @ApiOperation("根据条件分页查询电影列表")
    public Result list(@ApiParam(value = "页数")@RequestParam(name = "page",defaultValue = "1") Integer page,
                       @ApiParam(value = "每页行数")@RequestParam(name = "size",defaultValue = "10") Integer size,
                       FilmQueryCondition filmQueryCondition) {
        PageHelper.startPage(page, size);
        List<FilmResult> list = filmService.findbyQueryCondition(filmQueryCondition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/actor/{id:\\d+}")
    @ApiOperation("根据演员id查询参演电影列表")
    public Result list(@ApiParam(value = "演员id")@PathVariable("id") Integer actorId,
                       @ApiParam(value = "页数")@RequestParam(name = "page",defaultValue = "1") Integer page,
                       @ApiParam(value = "每页行数")@RequestParam(name = "size",defaultValue = "10") Integer size){
        PageHelper.startPage(page, size);
        List<FilmResult> list = filmService.findByActorId(actorId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
