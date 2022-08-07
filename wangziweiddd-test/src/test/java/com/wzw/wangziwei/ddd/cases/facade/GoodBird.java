package com.wzw.wangziwei.ddd.cases.facade;

public class GoodBird implements Bird{
    private Bird bird;
    public GoodBird(Bird bird) {
        this.bird = bird;
    }
    @Override
    public void doPlan(String take, String make) {
        bird.doPlan(take, make);
    }
}
