package com.wzw.wangziwei.ddd.application.log.command;

import com.wzw.wangziwei.ddd.application.log.command.cmd.LogCommand;
import com.wzw.wangziwei.ddd.domain.Log.LogFactory;
import com.wzw.wangziwei.ddd.domain.Log.model.LogRepository;
import com.wzw.wangziwei.ddd.domain.Log.model.OpLog;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LogApplication {
    @Resource
    private LogRepository logRepository;

    @Resource
    private LogFactory logFactory;

    public void create(LogCommand logCommand) {
        OpLog opLog = logFactory.build(logCommand.getLogTime(), logCommand.getAfter(), logCommand.getBefore(), logCommand.getIdentifierKey(), logCommand.getOpPeopleName());
        logRepository.create(opLog);
    }
}
