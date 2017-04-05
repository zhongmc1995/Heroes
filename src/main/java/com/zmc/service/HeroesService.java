package com.zmc.service;

import com.zmc.domain.Heroes;

import java.util.List;

/**
 * Created by zhongmc on 2017/4/5.
 */
public interface HeroesService {
    //查询一个英雄
    Heroes getOneHeroById(Integer id) throws Exception;
    //查询英雄列表
    List<Heroes> getAllHeroesAsList() throws Exception;
    //添加一个英雄
    Heroes addOneHero(Heroes heroes) throws Exception;
    //删除一个英雄
    void delOneHeroById(Integer id) throws Exception;
    //更新一个英雄
    Heroes updataOneHeroById(Heroes heroes) throws Exception;
}
