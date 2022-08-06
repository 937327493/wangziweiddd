package com.wzw.wangziwei.ddd.mock;

import com.wzw.wangziwei.ddd.api.dto.people.PeopleDTO;
import com.wzw.wangziwei.ddd.infrastructure.rocketmq.RocketMqService;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RocketMqServiceMockImpl implements RocketMqService {
    private List<PeopleDTO> list = new ArrayList<>();
    @Override
    public void peopleSend(PeopleDTO peopleDTO, DefaultMQProducer defaultMQProducer) throws MQClientException {
        for (int i = 0; i < 10; i++) {
            PeopleDTO peopleDTO1 = new PeopleDTO();
            peopleDTO1.setId(Long.valueOf(i));
            peopleDTO1.setName("猪八戒" + i);
            list.add(peopleDTO1);
        }
    }

    @Override
    public List<PeopleDTO> peopleRecieve(DefaultMQPullConsumer defaultMQPullConsumer) {
        return list;
    }
}
