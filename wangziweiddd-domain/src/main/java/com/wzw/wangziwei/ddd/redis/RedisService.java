package com.wzw.wangziwei.ddd.redis;

public interface RedisService {
    String getValueByKey(String key);
    void setValueByKey(String key, String value);
}
