package com.wzw.wangziwei.ddd.infrastructure.query;

import com.wzw.wangziwei.ddd.api.dto.people.PeopleDTO;
import com.wzw.wangziwei.ddd.api.dto.people.PeopleQueryDTO;
import com.wzw.wangziwei.ddd.application.people.query.PeopleQueryService;
import com.wzw.wangziwei.ddd.infrastructure.query.converter.PeopleQueryConverter;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.PeopleDO;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.mapper.PeopleMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class PeopleQueryServiceImpl implements PeopleQueryService {
    @Resource
    private PeopleMapper peopleMapper;

    @Override
    public List<PeopleDTO> queryPeople(PeopleQueryDTO peopleQueryDTO) {
        Integer pageNum = peopleQueryDTO.getPageNum();
        Integer pagestart = (pageNum - 1) * peopleQueryDTO.getPageSize();
        List<PeopleDO> peopleDOS = peopleMapper.select(peopleQueryDTO.getIds(), pagestart, peopleQueryDTO.getPageSize());
        return PeopleQueryConverter.peopleQueryDOToPeopleDTO(peopleDOS);
    }
}
