package com.wzw.wangziwei.ddd.cases.facade;

public class BirdMakeWarehouse implements Bird{
    @Override
    public void doPlan(String take, String make) {
        System.out.println("用" + take + "筑巢" + make);
    }
}
