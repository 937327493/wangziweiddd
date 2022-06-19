package com.wzw.wangziwei.ddd.infrastructure.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisServiceImpl implements RedisService{
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public String getValueByKey(String key) {
        String o = (String) redisTemplate.opsForValue().get(key);
        return o;
    }

    @Override
    public void setValueByKey(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
