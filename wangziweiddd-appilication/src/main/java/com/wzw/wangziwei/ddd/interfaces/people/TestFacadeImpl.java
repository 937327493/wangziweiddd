package com.wzw.wangziwei.ddd.interfaces.people;

import com.wzw.wangziwei.ddd.api.servcie.people.TestFacade;
import com.wzw.wangziwei.ddd.application.people.command.PeopleApplication;
import com.wzw.wangziwei.ddd.application.people.command.cmd.PeopleCreateCommand;
import com.wzw.wangziwei.ddd.interfaces.converter.PeopleConvert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TestFacadeImpl implements TestFacade {
    @Resource
    private PeopleApplication peopleApplication;
    @RequestMapping("/wangziwei")
    @Override
    public String test() {
        PeopleCreateCommand peopleCreateCommand = PeopleConvert.buildCreateCommand();
        peopleApplication.create(peopleCreateCommand);
        return "王梓崴测试";
    }
}
