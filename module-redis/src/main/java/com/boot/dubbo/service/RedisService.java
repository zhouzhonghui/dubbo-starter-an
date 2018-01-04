package com.boot.dubbo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisService{
    @Autowired
    private RedisTemplate redisTemplate;

    public void set(Object key, Object value, final long timeout, final TimeUnit unit){
        redisTemplate.opsForValue().set(key,value,timeout,unit);
    }

    public Object get(Object key){
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(Object key){
        redisTemplate.delete(key);
    }


}
