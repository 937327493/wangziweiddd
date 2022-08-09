package com.wzw.wangziwei.ddd.cases.facade;

import com.alibaba.fastjson.JSONPath;
import org.junit.Test;
import org.slf4j.MDC;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executors;


public class PolicyMode {
    /**
     * 策略模式——关注的是行为
     */
    @Test
    public void Test_001() {
        Bird birdEatFood = new BirdEatFood();
        Bird goodBird = new GoodBird(birdEatFood);
        goodBird.doPlan("海底捞", "玉米");
    }

    /**
     * 委托模式——多线程传递对象
     */
    @Test
    public void Test_002() {
        MDC.put("traceId", "123");
        new NewExecuteService((AbstractExecutorService) Executors.newSingleThreadExecutor()).execute(() -> {
            System.out.println(MDC.get("traceId"));
        });
    }
}
