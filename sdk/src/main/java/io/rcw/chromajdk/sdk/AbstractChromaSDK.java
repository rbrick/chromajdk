package io.rcw.chromajdk.sdk;

import java.util.concurrent.ScheduledExecutorService;

public abstract class AbstractChromaSDK implements ChromaSDK {
    protected ScheduledExecutorService service;


    @Override
    public ScheduledExecutorService executorService() {
        return this.service;
    }

    @Override
    public void initialize(ChromaConfiguration configuration) {
        this.service = configuration.executorService();
    }

    @Override
    public void uninitialize() {
        this.service.shutdown();
    }
}
