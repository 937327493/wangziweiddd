package com.wzw.wangziwei.ddd.application.people.command;

import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleCreateCommand;
import com.wzw.wangziwei.ddd.domain.people.PeopleFactory;
import com.wzw.wangziwei.ddd.domain.people.model.People;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PeopleApplication {
    @Resource
    private PeopleFactory peopleFactory;
    public void create(PeopleCreateCommand peopleCreateCommand) {
        People people = peopleFactory.newPeople();
        people.create();
    }
}
