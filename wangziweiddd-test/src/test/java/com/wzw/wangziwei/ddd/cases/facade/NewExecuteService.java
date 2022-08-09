package com.wzw.wangziwei.ddd.cases.facade;

import org.slf4j.MDC;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

public class NewExecuteService extends AbstractExecutorService {

    private AbstractExecutorService abstractExecutorService;

    public NewExecuteService(AbstractExecutorService abstractExecutorService) {
        this.abstractExecutorService = abstractExecutorService;
    }

    @Override
    public void shutdown() {
        abstractExecutorService.shutdown();
    }
    @Override
    public void execute(Runnable command) {
        abstractExecutorService.execute(new NewRunnable(command, MDC.get("traceId")));
    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }


}
