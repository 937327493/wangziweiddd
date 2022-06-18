package com.wzw.wangziwei.ddd.application.people.command.cmd;

import lombok.Data;

@Data
public class PeopleModifyCommand {
    private String name;
    private Long id;
}
