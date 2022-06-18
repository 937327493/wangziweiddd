package com.wzw.wangziwei.ddd.cases.facade;


import com.wzw.wangziwei.ddd.api.servcie.people.PeopleFacade;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleDTO;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleQueryDTO;
import com.wzw.wangziwei.ddd.api.utils.UmsResult;
import com.wzw.wangziwei.ddd.cases.AbstractTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.Resource;
import java.util.ArrayList;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DirtiesContext
public class PeopleFacadeTest extends AbstractTest {
    @Resource
    PeopleFacade peopleFacade;

    @Test
    public void test_001PeopleFacadePut() {
        PeopleDTO peopleDTO = new PeopleDTO();//初次插入 内存数据库中表数据的id是1
        peopleDTO.setName("黑熊瞎子1");
        UmsResult put = peopleFacade.put(peopleDTO);
        Assert.assertNotNull(put);
        Assert.assertEquals(200, put.get("code"));
        System.out.println();
    }
    @Test
    public void test_002PeopleFacadePut() {
        PeopleDTO peopleDTO = new PeopleDTO();//再次插入 内存数据库中表数据的id是2
        peopleDTO.setName("黑熊瞎子2");
        UmsResult put = peopleFacade.put(peopleDTO);
        Assert.assertNotNull(put);
        Assert.assertEquals(200, put.get("code"));
        System.out.println();
    }
    @Test
    public void test_003PeopleFacadePut() {
        PeopleDTO peopleDTO = new PeopleDTO();//三次插入 内存数据库中表数据的id是3
        peopleDTO.setName("黑熊瞎子3");
        UmsResult put = peopleFacade.put(peopleDTO);
        Assert.assertNotNull(put);
        Assert.assertEquals(200, put.get("code"));
        System.out.println();
    }
    @Test
    public void test_004PeopleFacadePut() {
        PeopleDTO peopleDTO = new PeopleDTO();//四次插入 内存数据库中表数据的id是4
        peopleDTO.setName("黑熊瞎子4");
        UmsResult put = peopleFacade.put(peopleDTO);
        Assert.assertNotNull(put);
        Assert.assertEquals(200, put.get("code"));
        System.out.println();
    }

    @Test
    public void test_005PeopleFacadeUpdate() {
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setName("迪迦奥特曼");
        peopleDTO.setId(1L);
        UmsResult update = peopleFacade.update(peopleDTO);
        Assert.assertNotNull(update);
        Assert.assertEquals(200, update.get("code"));
        System.out.println();
    }

    @Test
    public void test_006PeopleFacadeSelect() {
        PeopleQueryDTO peopleQueryDTO = new PeopleQueryDTO();
        peopleQueryDTO.setPageNum(0);
        peopleQueryDTO.setPageSize(10086);
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(2L);
        longs.add(3L);
        longs.add(4L);
        peopleQueryDTO.setIds(longs);
        UmsResult get = peopleFacade.getPeople(peopleQueryDTO);
        Assert.assertNotNull(get);
        Assert.assertEquals(200, get.get("code"));
        System.out.println();
    }

    @Test
    public void test_007PeopleFacadeSelect() {
        PeopleQueryDTO peopleQueryDTO = new PeopleQueryDTO();
        peopleQueryDTO.setPageNum(1);
        peopleQueryDTO.setPageSize(10000);
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(2L);
        longs.add(3L);
        longs.add(4L);
        peopleQueryDTO.setIds(longs);
        UmsResult get = peopleFacade.getPeople(peopleQueryDTO);
        Assert.assertNotNull(get);
        Assert.assertEquals(200, get.get("code"));
        System.out.println();
    }
}
