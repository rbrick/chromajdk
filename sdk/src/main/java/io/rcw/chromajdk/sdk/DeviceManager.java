package io.rcw.chromajdk.sdk;

import java.util.List;
import java.util.Optional;

public interface DeviceManager {
    void initialize();

    Optional<List<ChromaDevice>> devicesByBrand(Brand brand);

    Optional<List<ChromaDevice>> devicesByType(DeviceType deviceType);

    boolean hasDevice(Brand brand);

    boolean hasSDK(Brand brand);

    ChromaConfiguration config();
}
