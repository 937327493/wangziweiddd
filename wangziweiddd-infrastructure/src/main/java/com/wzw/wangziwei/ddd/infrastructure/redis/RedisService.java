package com.wzw.wangziwei.ddd.infrastructure.redis;

public interface RedisService {
    String getValueByKey(String key);
    void setValueByKey(String key, String value);
}
