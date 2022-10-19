package jy.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

@Controller
@RequestMapping(value = "/RedisTest")
public class RedisController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public void Test(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        listTest(jedis);
        jedis.flushAll();

    }

    // 操作字符串
    public void StringTest(Jedis jedis) {
        // 1.操作字符串
        jedis.set("helloworld","Jy");
        System.out.println(jedis.get("helloworld"));
        // 2.批量操作字符串
        jedis.mset("user","admin","pwd","123456");
        // 获取多个key的值
        List<String> values = jedis.mget("name ","user","pwd");
        // values.forEach(v -> System.out.println(v));
        for(String v: values){
            System.out.println(v);
        }
        if (jedis.exists("student:1")){
            String student = jedis.get("student:1");
        }else {
            //访问数据库， Student对象
            //把Stuent转为json数据
            jedis.set("student:1", "{student}");
            System.out.println(11);
        }
    }

    public void listTest(Jedis jedis){
        String key = "listKey1";
        jedis.lpush(key,"list");
        System.out.println(jedis.get("key"));
        jedis.lpush(key,"hash","sortlist","string","set");
        System.out.println(jedis.get("key"));
    }

}
