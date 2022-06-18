package com.wzw.wangziwei.ddd.domain.people;

import com.wzw.wangziwei.ddd.domain.people.model.People;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PeopleFactory {
    @Resource
    private PeopleRepository peopleRepository;

    public People newPeople() {
        People people = new People();
        people.setName("wangziwei");
        people.setPeopleRepository(peopleRepository);
        return people;
    }
}
