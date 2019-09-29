package io.rcw.chromajdk.sdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Supplier;

public interface ChromaConfiguration {

    Supplier<ChromaConfiguration> defaultInstance = new Supplier<ChromaConfiguration>() {

        ChromaConfiguration instance;

        @Override
        public ChromaConfiguration get() {
            if (instance == null)
                instance = new ChromaConfiguration() {
                    @Override
                    public ScheduledExecutorService executorService() {
                        return Executors.newSingleThreadScheduledExecutor();
                    }
                };
            return instance;
        }
    };

    static ChromaConfiguration defaultConfiguration() {
        return defaultInstance.get();
    }

    ScheduledExecutorService executorService();

}
