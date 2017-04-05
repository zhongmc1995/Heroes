package com.zmc.repository;

import com.zmc.domain.Heroes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhongmc on 2017/4/5.
 */
public interface HeroesRepository extends JpaRepository<Heroes,Integer> {
}
