package com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.converter;

import com.alibaba.fastjson.JSON;
import com.wzw.wangziwei.ddd.domain.Log.model.LogAttrKeyOb;
import com.wzw.wangziwei.ddd.domain.Log.model.OpLog;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.LogDO;

public class LogConverter {
    public static LogDO logToLogDO(OpLog opLog) {
        LogDO logDO = new LogDO();
        logDO.setLogTime(opLog.getLogTime());
        logDO.setId(opLog.getId());
        logDO.setItemkey(opLog.getKey());
        logDO.setLogTypeEnum(opLog.getLogTypeEnum());
        logDO.setOpPeopleName(opLog.getOpPeopleName());
        logDO.setValue(JSON.toJSONString(opLog.getValue()));
        return logDO;
    }

    public static OpLog logDOTolog(LogDO logDO) {
        OpLog opLog = new OpLog();
        opLog.setLogTime(logDO.getLogTime());
        opLog.setId(logDO.getId());
        opLog.setKey(logDO.getItemkey());
        opLog.setOpPeopleName(logDO.getOpPeopleName());
        opLog.setLogTypeEnum(logDO.getLogTypeEnum());
        opLog.setValue(JSON.parseObject(logDO.getValue(), LogAttrKeyOb.class));
        return opLog;
    }
}
