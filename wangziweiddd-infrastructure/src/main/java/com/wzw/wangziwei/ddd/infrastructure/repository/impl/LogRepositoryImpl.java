package com.wzw.wangziwei.ddd.infrastructure.repository.impl;

import com.wzw.wangziwei.ddd.domain.Log.model.LogRepository;
import com.wzw.wangziwei.ddd.domain.Log.model.OpLog;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.converter.LogConverter;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.LogDO;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.mapper.LogMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LogRepositoryImpl implements LogRepository {
    @Resource
    private LogMapper logMapper;
    @Override
    public void create(OpLog opLog) {
        //把LogAttrKeyOb变为json字符串存入数据库
        LogDO logDO = LogConverter.logToLogDO(opLog);
        logMapper.insert(logDO);
    }
}
