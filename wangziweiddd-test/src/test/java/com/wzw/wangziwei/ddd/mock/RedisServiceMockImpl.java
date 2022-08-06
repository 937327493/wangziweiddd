package com.wzw.wangziwei.ddd.mock;

import com.wzw.wangziwei.ddd.redis.RedisService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class RedisServiceMockImpl implements RedisService {
    private Map<String, String> map = new HashMap<>();
    @Override
    public String getValueByKey(String key) {
        String value = map.get(key);
        return value;
    }

    @Override
    public void setValueByKey(String key, String value) {
        map.put(key, value);
    }
}
