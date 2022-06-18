package com.wzw.wangziwei.ddd.cases.facade;


import com.wzw.wangziwei.ddd.api.servcie.people.PeopleFacade;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleDTO;
import com.wzw.wangziwei.ddd.api.utils.UmsResult;
import com.wzw.wangziwei.ddd.cases.AbstractTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.Resource;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DirtiesContext
public class PeopleFacadeTest extends AbstractTest {
    @Resource
    PeopleFacade peopleFacade;
    @Test
    public void test_001() {
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setName("黑熊瞎子");
        UmsResult put = peopleFacade.put(peopleDTO);
        Assert.assertNotNull(put);
        Assert.assertEquals(200, put.get("code"));
        System.out.println();
    }
}
