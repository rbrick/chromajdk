package io.rcw.chromajdk.sdk;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public interface ChromaSDK {
    ScheduledExecutorService executorService();

    void initialize(ChromaConfiguration configuration);

    void uninitialize();

    int deviceCount();

    Collection<ChromaDevice> connectedDevices();

    ChromaDevice getDevice(DeviceType type);
}
