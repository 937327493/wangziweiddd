package com.wzw.wangziwei.ddd.domain.people;

import com.wzw.wangziwei.ddd.domain.people.model.People;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class PeopleFactory {
    @Resource
    private PeopleRepository peopleRepository;

    public People newPeople(String name) {
        People people = new People();
        people.setName(name);
        people.setPeopleRepository(peopleRepository);
        return people;
    }
}
