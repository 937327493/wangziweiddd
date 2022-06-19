package com.wzw.wangziwei.ddd.infrastructure.rocketmq;

import com.alibaba.fastjson.JSON;
import com.wzw.wangziwei.ddd.api.servcie.people.dto.PeopleDTO;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
@Component
public class RocketMqServiceImpl implements RocketMqService{
    private static Map<MessageQueue, Long> OFFSET_TABLE = new HashMap<>();

    /**
     * 数据发送
     * @param peopleDTO
     */
    @Override
    public void peopleSend(PeopleDTO peopleDTO, DefaultMQProducer defaultMQProducer) throws MQClientException {

        String jsonString = JSON.toJSONString(peopleDTO);
        Message peopleTopic = new Message("peopleTopic", null, jsonString.getBytes(StandardCharsets.UTF_8));
        try {
            defaultMQProducer.send(peopleTopic);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据拉取
     * @return
     */
    @Override
    public List<PeopleDTO> peopleRecieve(DefaultMQPullConsumer defaultMQPullConsumer) {
        List<PeopleDTO> collect = new ArrayList<>();
        try {

            Set<MessageQueue> peopleTopic = defaultMQPullConsumer.fetchSubscribeMessageQueues("peopleTopic");
            for (MessageQueue messageQueue : peopleTopic) {
                while (true) {
                    //拉取队列参数偏移量到当前最新偏移量的32个message
                    PullResult pullResult = defaultMQPullConsumer.pullBlockIfNotFound(messageQueue, null, getMessageQueueOffset(messageQueue),
                            999);
                    putMessageQueueOffset(messageQueue, pullResult.getNextBeginOffset());
                    switch (pullResult.getPullStatus()) {
                        case FOUND:
                            List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
                            List<PeopleDTO> collect1 = msgFoundList.stream().map(messageExt -> {
                                byte[] body = messageExt.getBody();
                                String people = null;
                                try {
                                    people = new String(body, "utf-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                PeopleDTO peopleDTO = JSON.parseObject(people, PeopleDTO.class);
                                return peopleDTO;
                            }).collect(Collectors.toList());
                            collect.addAll(collect1);
                            break;
                        case NO_MATCHED_MSG:
                            break;
                        case NO_NEW_MSG:
                            break;
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                    break;
                }
            }
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return collect;

    }

    /**
     * 返回上次消费的偏移量
     * @param messageQueue
     * @return
     */
    private Long getMessageQueueOffset(MessageQueue messageQueue) {
        Long aLong = OFFSET_TABLE.get(messageQueue);
        if (aLong == null) {
            return 0L;
        }
        return aLong;
    }

    /**
     * 返保存最后一次消费的偏移量
     * @param messageQueue
     * @return
     */
    private void putMessageQueueOffset(MessageQueue messageQueue, Long offset) {
        OFFSET_TABLE.put(messageQueue, offset);
    }
}
