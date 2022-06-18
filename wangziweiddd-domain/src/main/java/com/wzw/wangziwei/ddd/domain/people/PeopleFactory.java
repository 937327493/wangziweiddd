package com.wzw.wangziwei.ddd.domain.people;

import com.wzw.wangziwei.ddd.domain.people.model.People;
import org.springframework.stereotype.Component;

@Component
public class PeopleFactory {
    public People newPeople() {
        return new People();
    }
}
