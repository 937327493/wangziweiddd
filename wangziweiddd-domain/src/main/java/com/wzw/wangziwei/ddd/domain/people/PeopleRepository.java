package com.wzw.wangziwei.ddd.domain.people;

import com.wzw.wangziwei.ddd.domain.people.model.People;

public interface PeopleRepository {
    void save(People people);
}
