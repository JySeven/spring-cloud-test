package jy.controller;

import javax.annotation.Resource;
import jy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private JedisPool jedisPool;

    @RequestMapping("/test")
    @ResponseBody
    public void test(){
        Jedis jedis = jedisPool.getResource();

        //testService.test();
    }

}
