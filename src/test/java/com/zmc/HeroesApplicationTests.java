package com.zmc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroesApplicationTests {

	@Autowired
	private StringRedisTemplate redisTemplate;
	@Test
	public void test() throws Exception {

		// 保存字符串
		redisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));

	}
}
