package com.wzw.wangziwei.ddd.infrastructure.repository.impl;

import com.wzw.wangziwei.ddd.domain.people.PeopleRepository;
import com.wzw.wangziwei.ddd.domain.people.model.People;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.converter.PeopleConverter;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.PeopleDO;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.mapper.PeopleMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PeopleRepositoryImpl implements PeopleRepository {
    @Resource
    private PeopleMapper peopleMapper;
    @Override
    public void save(People people) {
        PeopleDO peopleDO = PeopleConverter.peopleToPeopleDO(people);
        if (peopleDO.getId() == null) {
            peopleMapper.insert(peopleDO.getName());
        } else {
            peopleMapper.update(peopleDO.getId(), peopleDO.getName());
        }
    }


    @Override
    public People find(Long id) {
        return PeopleConverter.peopleDOToPeople(peopleMapper.findById(id));
    }
}
