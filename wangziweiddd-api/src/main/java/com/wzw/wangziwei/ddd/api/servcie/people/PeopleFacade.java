package com.wzw.wangziwei.ddd.api.servcie.people;

import com.wzw.wangziwei.ddd.api.dto.people.PeopleDTO;
import com.wzw.wangziwei.ddd.api.dto.people.PeopleQueryDTO;
import com.wzw.wangziwei.ddd.api.utils.UmsResult;

/**
 * 测试用的接口
 */
public interface PeopleFacade {
    UmsResult put(PeopleDTO peopleDTO);
    UmsResult update(PeopleDTO peopleDTO);
    UmsResult getPeople(PeopleQueryDTO peopleQueryDTO);
}
