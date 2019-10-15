package io.rcw.chromajdk.sdk;

import io.rcw.chromajdk.sdk.internals.InternalDeviceManager;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface DeviceManager {

    Function<ChromaConfiguration, DeviceManager> instance = new Function<ChromaConfiguration, DeviceManager>() {
        private DeviceManager instance;

        @Override
        public DeviceManager apply(ChromaConfiguration configuration) {
            if (instance == null) {
                (instance = new InternalDeviceManager(configuration)).initialize();
            }
            return instance;
        }
    };

    static DeviceManager getInstance(ChromaConfiguration configuration) {
        return instance.apply(configuration);
    }


    void initialize();

    Optional<List<ChromaDevice>> devicesByBrand(Brand brand);

    Optional<List<ChromaDevice>> devicesByType(DeviceType deviceType);

    boolean hasDevice(Brand brand);

    boolean hasSDK(Brand brand);

    ChromaConfiguration config();
}
