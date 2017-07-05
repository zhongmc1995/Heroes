package com.zmc.controller;

import com.zmc.domain.ResultStatus;
import com.zmc.exception.HeroesException;
import com.zmc.domain.Heroes;
import com.zmc.domain.Result;
import com.zmc.service.HeroesService;
import com.zmc.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhongmc on 2017/4/5.
 */
@RestController
@RequestMapping("/heroes")
public class HeroesController {
    @Autowired
    private HeroesService heroesService;
    /*
     * 通过id获取heroes
     * */
    @ApiOperation(value = "获取英雄详情",notes = "根据ID获取英雄详情")
    @ApiImplicitParam(name = "id",value = "英雄ID",required = true,dataType = "Integer")
    @GetMapping("/{id}")
    public Result getHeroesById(@PathVariable("id") Integer id) throws Exception {
        Heroes heroes = heroesService.getOneHeroById(id);
        return ResultUtil.success(heroes,heroes==null?0:1);
    }

    /*
    * 获取英雄列表
    * */
    @ApiOperation(value = "获取英雄列表")
    @GetMapping("/")
    public Result getAllHeroes() throws Exception {
        List<Heroes> heroes = heroesService.getAllHeroesAsList();
        return ResultUtil.success(heroes,heroes==null?0:heroes.size());
    }
    /*
    * 添加英雄
    * */
    @ApiOperation(value = "新增英雄")
    @ApiImplicitParam(name = "heroes",value = "新增的英雄",required = true,dataType = "Heroes")
    @PostMapping("/")
    public Result addHeroes(@Validated Heroes heroes, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            throw new HeroesException(ResultStatus.ARGUMENT_BINDING_ERROR);
        }else {
            return ResultUtil.success(heroesService.addOneHero(heroes),1);
        }
    }

    /*
    * 删除英雄
    * */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除英雄",notes = "根据ID删除英雄")
    @ApiImplicitParam(name = "id",value = "英雄ID",required = true,dataType = "Integer")
    @ResponseStatus
    public Result delHeroById(@PathVariable("id") Integer id) {
        try {
            heroesService.delOneHeroById(id);
        } catch (Exception e) {
            throw new HeroesException(ResultStatus.NO_SUCH_HERO);
        }
        return ResultUtil.success(null,0);
    }

    /*
    * 更新英雄
    * */
    @ApiOperation(value = "更新英雄",notes = "根据ID更新英雄")
    @ApiImplicitParam(name = "id",value = "英雄ID",required = true,dataType = "Integer")
    @PutMapping("/{id}")
    public Result updataHeroById(@PathVariable("id") Integer id,
                                 @Validated  Heroes heroes,BindingResult result) throws Exception {
        if (result.hasErrors()){
            throw new HeroesException(ResultStatus.ARGUMENT_BINDING_ERROR);
        }else {
            heroes.setId(id);
            Heroes newHeroes = heroesService.updataOneHeroById(heroes);
            return ResultUtil.success(newHeroes,1);
        }
    }
}
