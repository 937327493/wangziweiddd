package com.wzw.wangziwei.ddd.cases.facade;

import org.slf4j.MDC;

public class NewRunnable implements Runnable{
    private Runnable runnable;
    private String traceId;

    public NewRunnable(Runnable runnable, String traceId) {
        this.runnable = runnable;
        this.traceId = traceId;
    }

    @Override
    public void run() {
        MDC.put("traceId", traceId);
        runnable.run();
        MDC.remove("traceId");
    }
}
