package com.wzw.wangziwei.ddd.infrastructure.redis;

import com.wzw.wangziwei.ddd.redis.RedisService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public String getValueByKey(String key) {
        String o = (String) redisTemplate.opsForValue().get(key);
        redisTemplate.multi();
        Object execute = redisTemplate.execute(new SessionCallback() {

            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                return null;
            }
        });
        redisTemplate.exec();
        return o;
    }

    @Override
    public void setValueByKey(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
