package com.wzw.wangziwei.ddd.interfaces.converter;

import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleDTO;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleCreateCommand;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleModifyCommand;

public class PeopleConvert {
     public static PeopleCreateCommand buildCreateCommand(PeopleDTO peopleDTO) {
         if (peopleDTO == null || (peopleDTO != null && peopleDTO.getName() ==null)) {
             throw new RuntimeException("PeopleConvert#buildCreateCommand为null");
         }
         PeopleCreateCommand peopleCreateCommand = new PeopleCreateCommand();
         peopleCreateCommand.setName(peopleDTO.getName());
         return peopleCreateCommand;
    }

    public static PeopleModifyCommand buildUpdateCommand(PeopleDTO peopleDTO) {
        if (peopleDTO == null || (peopleDTO != null && (peopleDTO.getName() == null || peopleDTO.getId() == null))) {
            throw new RuntimeException("PeopleConvert#buildUpdateCommand为null");
        }
        PeopleModifyCommand peopleModifyCommand = new PeopleModifyCommand();
        peopleModifyCommand.setName(peopleDTO.getName());
        peopleModifyCommand.setId(peopleDTO.getId());
        return peopleModifyCommand;
    }

}
