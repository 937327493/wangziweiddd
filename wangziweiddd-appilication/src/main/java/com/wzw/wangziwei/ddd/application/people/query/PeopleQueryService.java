package com.wzw.wangziwei.ddd.application.people.query;

import com.wzw.wangziwei.ddd.api.dto.people.PeopleDTO;
import com.wzw.wangziwei.ddd.api.dto.people.PeopleQueryDTO;

import java.util.List;

public interface PeopleQueryService {
    List<PeopleDTO> queryPeople(PeopleQueryDTO peopleQueryDTO);
}
