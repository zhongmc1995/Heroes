package com.zmc.controller;

import com.zmc.domain.ResultStatus;
import com.zmc.exception.HeroesException;
import com.zmc.domain.Heroes;
import com.zmc.domain.Result;
import com.zmc.service.HeroesService;
import com.zmc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhongmc on 2017/4/5.
 */
@RestController
public class HeroesController {
    @Autowired
    private HeroesService heroesService;
    /*
     * 通过id获取heroes
     * */
    @GetMapping("/heroes/{id}")
    public Result getHeroesById(@PathVariable("id") Integer id) throws Exception {
        Heroes heroes = heroesService.getOneHeroById(id);
        return ResultUtil.success(heroes,heroes==null?0:1);
    }

    /*
    * 获取英雄列表
    * */
    @GetMapping("/heroes")
    public Result getAllHeroes() throws Exception {
        List<Heroes> heroes = heroesService.getAllHeroesAsList();
        return ResultUtil.success(heroes,heroes==null?0:heroes.size());
    }
    /*
    * 添加英雄
    * */
    @PostMapping("/heroes")
    public Heroes addHeroes(@Validated Heroes heroes, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            throw new HeroesException(ResultStatus.ARGUMENT_BINDING_ERROR);
        }else {
            return heroesService.addOneHero(heroes);
        }
    }

    /*
    * 删除英雄
    * */
    @DeleteMapping("/heroes/{id}")
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
    @PutMapping("/heroes/{id}")
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
