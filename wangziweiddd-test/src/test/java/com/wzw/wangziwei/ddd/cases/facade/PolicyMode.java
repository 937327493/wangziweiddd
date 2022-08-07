package com.wzw.wangziwei.ddd.cases.facade;

import org.junit.Test;


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
     * 委托模式
     */
}
