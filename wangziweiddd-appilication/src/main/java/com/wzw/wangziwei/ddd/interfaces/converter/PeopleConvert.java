package com.wzw.wangziwei.ddd.interfaces.converter;

import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleCreateCommand;

public class PeopleConvert {
     public static PeopleCreateCommand buildCreateCommand() {
        PeopleCreateCommand peopleCreateCommand = new PeopleCreateCommand();
        return peopleCreateCommand;
    }

}
