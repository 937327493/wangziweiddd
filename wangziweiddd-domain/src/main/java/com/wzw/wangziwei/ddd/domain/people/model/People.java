package com.wzw.wangziwei.ddd.domain.people.model;

import com.wzw.wangziwei.ddd.domain.people.PeopleRepository;
import lombok.Data;

@Data
public class People {
    private PeopleRepository peopleRepository;
    private String name;
    public void create() {
        peopleRepository.save(this);
    }
}
