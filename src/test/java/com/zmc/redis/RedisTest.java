package com.zmc.redis;


/**
 * Created by zhongmc on 2017/4/9.
 */
public class RedisTest {
    /*private Jedis jedis;
    @Before
    public void setUp(){
        jedis = new Jedis("120.24.78.196",6379);
        System.out.println("PONG".equals(jedis.ping())?"连接成功":"连接异常");
    }
    @Test
    public void testString() {
        //-----添加数据----------
        jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));//执行结果：xinxin

        jedis.append("name", " is my lover"); //拼接
        System.out.println(jedis.get("name"));

        jedis.del("name");  //删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name","liuling","age","23","qq","476777XXX");
        jedis.incr("age"); //进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));

    }*/
}
