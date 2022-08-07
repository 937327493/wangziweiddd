package com.wzw.wangziwei.ddd.cases.facade;

public class BirdEatFood implements Bird{
    @Override
    public void doPlan(String take, String make) {
        System.out.println("到" + take + "吃" + make);
    }
}
