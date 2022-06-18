package com.wzw.wangziwei.ddd.domain.people.model;

import com.wzw.wangziwei.ddd.domain.people.PeopleRepository;

import javax.annotation.Resource;

public class People {
    @Resource
    private PeopleRepository peopleRepository;

    public void create() {
        peopleRepository.save(this);
    }
}
