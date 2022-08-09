package com.wzw.wangziwei.ddd.application.people.command;

import com.wzw.wangziwei.ddd.application.log.command.LogApplication;
import com.wzw.wangziwei.ddd.application.log.command.cmd.LogCommand;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleCreateCommand;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleModifyCommand;
import com.wzw.wangziwei.ddd.domain.people.PeopleFactory;
import com.wzw.wangziwei.ddd.domain.people.PeopleRepository;
import com.wzw.wangziwei.ddd.domain.people.model.People;
import com.wzw.wangziwei.ddd.interfaces.converter.LogConverter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class PeopleApplication {
    @Resource
    private PeopleRepository peopleRepository;

    @Resource
    private PeopleFactory peopleFactory;

    @Resource
    private LogApplication logApplication;

    public void create(PeopleCreateCommand peopleCreateCommand) {
        People people = peopleFactory.newPeople(peopleCreateCommand.getName());
        people.create();
    }

    public void update(PeopleModifyCommand peopleModifyCommand) {
        People people = peopleRepository.find(peopleModifyCommand.getId());
        if (Objects.equals(peopleModifyCommand.getName(), people.getName())) {
            return;
        }
        people.setName(peopleModifyCommand.getName());
        people.create();

        LogCommand logCommand = LogConverter.buildLogCommand(peopleModifyCommand, people);
        logApplication.create(logCommand);
    }

}
