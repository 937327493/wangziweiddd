package com.wzw.wangziwei.ddd.cases.facade;

import com.alibaba.fastjson.JSON;
import com.wzw.wangziwei.ddd.api.servcie.people.PeopleFacade;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleDTO;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleQueryDTO;
import com.wzw.wangziwei.ddd.api.utils.UmsResult;
import com.wzw.wangziwei.ddd.cases.AbstractTest;
import com.wzw.wangziwei.ddd.infrastructure.rocketmq.RocketMqService;
import com.wzw.wangziwei.ddd.infrastructure.rocketmq.RocketMqServiceImpl;
import com.wzw.wangziwei.ddd.redis.RedisService;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.DirtiesContext;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DirtiesContext
public class PeopleFacadeTest extends AbstractTest {
    @Resource
    private PeopleFacade peopleFacade;

    @Resource
    private RedisService redisService;

    @Resource
    private RocketMqService rocketMqService;

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

    @Test
    public void test_014PeopleFacadeSelect() {
        PeopleQueryDTO peopleQueryDTO = new PeopleQueryDTO();
        peopleQueryDTO.setPageNum(1);
        peopleQueryDTO.setPageSize(10000);
        UmsResult get = peopleFacade.getPeople(peopleQueryDTO);
        Assert.assertNotNull(get);
        Assert.assertEquals(200, get.get("code"));
        System.out.println();
    }

    /**
     * rocketmq真实环境放开
     */
//    @Test
//    public void test_008RocketMQOrigin() throws MQClientException, InterruptedException {
//        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("wzwwzw");
//        defaultMQProducer.setNamesrvAddr("192.168.71.130:9876");
//        defaultMQProducer.start();
//        for (int i = 0; i < 10; i++) {
//                PeopleDTO peopleDTO1 = new PeopleDTO();
//                peopleDTO1.setId(Long.valueOf(i));
//                peopleDTO1.setName("猪八戒" + i);
//                rocketMqService.peopleSend(peopleDTO1, defaultMQProducer);
//            System.out.println("peopleSend" + peopleDTO1);
////            TimeUnit.MILLISECONDS.sleep(100);
//        }
//    }
//
//    @Test
//    public void test_009RocketMQOrigin() throws MQClientException {
//        DefaultMQPullConsumer defaultMQPullConsumer = new DefaultMQPullConsumer();
//        defaultMQPullConsumer.setConsumerGroup("wzw");
//        defaultMQPullConsumer.setNamesrvAddr("192.168.71.130:9876");
//        defaultMQPullConsumer.start();
//        List<PeopleDTO> peopleDTOS = rocketMqService.peopleRecieve(defaultMQPullConsumer);
//        for (PeopleDTO peopleDTO : peopleDTOS) {
//            Assert.assertNotNull(peopleDTO);
//            Assert.assertNotNull(peopleDTO.getName());
//            Assert.assertNotNull(peopleDTO.getId());
//            System.out.println("peopleRecieve" + peopleDTO);
//        }
//    }


    /**
     * rocketmq   mock假数据
     */
//    @Test
//    public void test_010RocketMQOrigin() throws MQClientException, InterruptedException {
//        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("wzwwzw");
//        defaultMQProducer.setNamesrvAddr("192.168.71.130:9876");
//        defaultMQProducer.start();
//        for (int i = 0; i < 10; i++) {
//                PeopleDTO peopleDTO1 = new PeopleDTO();
//                peopleDTO1.setId(Long.valueOf(i));
//                peopleDTO1.setName("猪八戒" + i);
//                rocketMqService.peopleSend(peopleDTO1, defaultMQProducer);
//            System.out.println("peopleSend" + peopleDTO1);
////            TimeUnit.MILLISECONDS.sleep(100);
//        }
//    }

//    @Test
//    public void test_011RocketMQOrigin() throws MQClientException {
//        RocketMqServiceImpl rocketMqService = new RocketMqServiceImpl();
//        DefaultMQPullConsumer defaultMQPullConsumer = new DefaultMQPullConsumer();
//        defaultMQPullConsumer.setConsumerGroup("wzw");
//        defaultMQPullConsumer.setNamesrvAddr("192.168.71.130:9876");
//        defaultMQPullConsumer.start();
//        List<PeopleDTO> peopleDTOS = rocketMqService.peopleRecieve(defaultMQPullConsumer);
//        for (PeopleDTO peopleDTO : peopleDTOS) {
//            Assert.assertNotNull(peopleDTO);
//            Assert.assertNotNull(peopleDTO.getName());
//            Assert.assertNotNull(peopleDTO.getId());
//            System.out.println("peopleRecieve" + peopleDTO);
//        }
//    }

    /**
     * redis   mock假数据
     */
//    @Test
//    public void test_012RedisOrigin() {
//        PeopleDTO peopleDTO = new PeopleDTO();
//        peopleDTO.setId(Long.valueOf(5));
//        peopleDTO.setName("牛头人");
//        String jsonString = JSON.toJSONString(peopleDTO);
//        redisService.setValueByKey("peopleDTO", jsonString);
//    }

//    @Test
//    public void test_013RedisOrigin() {
//        String peopleDTO = redisService.getValueByKey("peopleDTO");
//        Assert.assertNotNull(peopleDTO);
//        PeopleDTO peopleDTO1 = JSON.parseObject(peopleDTO, PeopleDTO.class);
//        Assert.assertNotNull(peopleDTO1);
//    }

}
