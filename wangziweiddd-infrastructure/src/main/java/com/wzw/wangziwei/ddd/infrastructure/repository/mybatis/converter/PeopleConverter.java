package com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.converter;

import com.wzw.wangziwei.ddd.domain.people.model.People;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.PeopleDO;

public class PeopleConverter {
    public static PeopleDO peopleToPeopleDO(People people) {
        PeopleDO peopleDO = new PeopleDO();
        peopleDO.setName(people.getName());
        peopleDO.setId(people.getId());
        return peopleDO;
    }

    public static People peopleDOToPeople(PeopleDO peopleDO) {
        People people = new People();
        people.setName(peopleDO.getName());
        people.setId(peopleDO.getId());
        return people;
    }
}
