package com.zmc.serviceImpl;

import com.zmc.domain.Heroes;
import com.zmc.domain.ResultStatus;
import com.zmc.exception.HeroesException;
import com.zmc.repository.HeroesRepository;
import com.zmc.service.HeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongmc on 2017/4/5.
 */
@Service
public class HeroesServiceImpl implements HeroesService {
    @Autowired
    private HeroesRepository heroesRepository;
    @Override
    public Heroes getOneHeroById(Integer id) throws Exception {
        return heroesRepository.findOne(id);
    }

    @Override
    public List<Heroes> getAllHeroesAsList() throws Exception {
        return heroesRepository.findAll();
    }

    @Override
    public Heroes addOneHero(Heroes heroes) throws Exception {
        return heroesRepository.save(heroes);
    }

    @Override
    public void delOneHeroById(Integer id) throws Exception {
        heroesRepository.delete(id);
    }

    @Override
    public Heroes updataOneHeroById(Heroes heroes) throws Exception {
        boolean isExisted = heroesRepository.exists(heroes.getId());
        if (isExisted){
            return heroesRepository.save(heroes);
        }else {
            throw new HeroesException(ResultStatus.NO_SUCH_HERO);
        }

    }
}
