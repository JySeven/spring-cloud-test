package jy.config;

import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisUtils {
    //JedisPool 有一个就够用了
    private static JedisPool pool;

    public static JedisPool getPool(){
        if (pool == null){
            pool = new JedisPool();
            synchronized (pool) {
            }
        }

        return pool;
    }

}
