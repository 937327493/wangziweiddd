package com.wzw.wangziwei.ddd.infrastructure.query.converter;

import com.wzw.wangziwei.ddd.api.dto.people.PeopleDTO;
import com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.dataobj.PeopleDO;

import java.util.List;
import java.util.stream.Collectors;

public class PeopleQueryConverter {
    public static List<PeopleDTO> peopleQueryDOToPeopleDTO(List<PeopleDO> peopleDOS) {
        List<PeopleDTO> peopleDTOList = peopleDOS.stream().map(peopleDO -> {
            PeopleDTO peopleDTO = new PeopleDTO();
            peopleDTO.setId(peopleDO.getId());
            peopleDTO.setName(peopleDO.getName());
            return peopleDTO;
        }).collect(Collectors.toList());
        return peopleDTOList;
    }
}
