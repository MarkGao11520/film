package com.gwf.family.business.actor.controller;
import com.gwf.family.business.core.results.Result;
import com.gwf.family.business.core.results.ResultGenerator;
import com.gwf.family.business.actor.entity.Actor;
import com.gwf.family.business.actor.service.ActorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import java.util.List;

/**
* Created by gwf on 2017-10-21 17:14:15.
*/
@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @PostMapping
    @ApiOperation("添加Actor")
    public Result add(Actor actor) {
        actorService.save(actor);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation("删除Actor")
    public Result delete(@ApiParam(value = "id") @PathVariable  Integer id) {
        actorService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/{id:\\d+}")
    @ApiOperation("修改Actor")
    public Result update(Actor actor) {
        actorService.update(actor);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation("Actor根据id查询详情")
    public Result detail(@ApiParam(value = "id")@PathVariable Integer id) {
        Actor actor = actorService.findById(id);
        return ResultGenerator.genSuccessResult(actor);
    }

    @GetMapping
    @ApiOperation("Actor分页查询列表")
    public Result list(@ApiParam(value = "页数")@RequestParam(name = "page",defaultValue = "1") Integer page,
                       @ApiParam(value = "每页行数")@RequestParam(name = "size",defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<Actor> list = actorService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
