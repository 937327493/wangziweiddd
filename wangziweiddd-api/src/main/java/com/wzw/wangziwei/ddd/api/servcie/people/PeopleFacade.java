package com.wzw.wangziwei.ddd.api.servcie.people;

import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleDTO;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleQueryDTO;
import com.wzw.wangziwei.ddd.api.utils.UmsResult;

import java.util.List;

/**
 * 测试用的接口
 */
public interface PeopleFacade {
    UmsResult put(PeopleDTO peopleDTO);
    UmsResult update(PeopleDTO peopleDTO);
    UmsResult getPeople(PeopleQueryDTO peopleQueryDTO);
}
