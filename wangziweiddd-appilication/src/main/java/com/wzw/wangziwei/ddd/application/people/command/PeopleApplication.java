package com.wzw.wangziwei.ddd.application.people.command;

import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleCreateCommand;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleModifyCommand;
import com.wzw.wangziwei.ddd.domain.people.PeopleFactory;
import com.wzw.wangziwei.ddd.domain.people.PeopleRepository;
import com.wzw.wangziwei.ddd.domain.people.model.People;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PeopleApplication {
    @Resource
    private PeopleRepository peopleRepository;

    @Resource
    private PeopleFactory peopleFactory;

    public void create(PeopleCreateCommand peopleCreateCommand) {
        People people = peopleFactory.newPeople(peopleCreateCommand.getName());
        people.create();
    }

    public void update(PeopleModifyCommand peopleModifyCommand) {
        People people = peopleRepository.find(peopleModifyCommand.getId());
        people.setName(peopleModifyCommand.getName());
        people.create();
    }

}
