package com.wzw.wangziwei.ddd.domain.Log;

import com.wzw.wangziwei.ddd.domain.Log.model.LogAttrKeyOb;
import com.wzw.wangziwei.ddd.domain.Log.model.OpLog;
import com.wzw.wangziwei.ddd.domain.enums.LogTypeEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LogFactory {
    public OpLog build(LocalDateTime time, String after, String before, String key, String name) {
        OpLog opLog = new OpLog();
        opLog.setLogTime(time);
        opLog.setLogTypeEnum(LogTypeEnum.PEOPLENAMETYPE);
        opLog.setKey(key);
        opLog.setOpPeopleName(name);
        LogAttrKeyOb logAttrKeyOb = new LogAttrKeyOb();
        logAttrKeyOb.setAfter(after);
        logAttrKeyOb.setBefore(before);
        opLog.setValue(logAttrKeyOb);
        return opLog;
    };
}
