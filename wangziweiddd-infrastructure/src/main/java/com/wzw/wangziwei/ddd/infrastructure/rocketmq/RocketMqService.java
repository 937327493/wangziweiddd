package com.wzw.wangziwei.ddd.infrastructure.rocketmq;

import com.wzw.wangziwei.ddd.api.dto.people.PeopleDTO;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

import java.util.List;

public interface RocketMqService {

    void peopleSend(PeopleDTO peopleDTO, DefaultMQProducer defaultMQProducer) throws MQClientException;

    List<PeopleDTO> peopleRecieve(DefaultMQPullConsumer defaultMQPullConsumer);
}
