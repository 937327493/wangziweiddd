package com.wzw.wangziwei.ddd.application.people.query;

import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleDTO;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleQueryDTO;

import java.util.List;

public interface PeopleQueryService {
    List<PeopleDTO> queryPeople(PeopleQueryDTO peopleQueryDTO);
}
