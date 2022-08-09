package com.wzw.wangziwei.ddd.interfaces.converter;

import com.wzw.wangziwei.ddd.application.log.command.cmd.LogCommand;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleModifyCommand;
import com.wzw.wangziwei.ddd.domain.people.model.People;

import java.time.LocalDateTime;

public class LogConverter {
    public static LogCommand buildLogCommand(PeopleModifyCommand peopleModifyCommand, People people) {
        LogCommand logCommand = new LogCommand();
        logCommand.setLogTime(LocalDateTime.now());
        logCommand.setAfter(peopleModifyCommand.getName());
        logCommand.setBefore(people.getName());
        logCommand.setIdentifierKey(people.getId().toString());
        logCommand.setOpPeopleName("王梓崴");
        return logCommand;
    }
}
