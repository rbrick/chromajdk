package io.rcw.chromajdk.sdk.internals;

import io.rcw.chromajdk.sdk.*;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairChromaSDK;
import io.rcw.chromajdk.sdk.internals.razer.RazerChromaSDK;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class InternalDeviceManager implements DeviceManager {

    private static Map<Brand, Class<? extends ChromaSDK>> implementations = new HashMap<>();

    static {
        implementations.put(Brand.RAZER, RazerChromaSDK.class);
        implementations.put(Brand.CORSAIR, CorsairChromaSDK.class);
    }

    private final Map<DeviceType, List<ChromaDevice>> devicesByType = new ConcurrentHashMap<>();
    private final Map<Brand, List<ChromaDevice>> devicesByBrand = new ConcurrentHashMap<>();
    private final Map<Brand, ChromaSDK> implMap = new ConcurrentHashMap<>();
    private final ChromaConfiguration configuration;

    public InternalDeviceManager(ChromaConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void initialize() {

        for (Map.Entry<Brand, Class<? extends ChromaSDK>> sdk : implementations.entrySet()) {

            try {
                ChromaSDK sdk1 = sdk.getValue().newInstance();

                sdk1.initialize(this.configuration);

                implMap.putIfAbsent(sdk.getKey(), sdk1);

                for (DeviceType type : DeviceType.values()) {
                    List<ChromaDevice> deviceList = devicesByType.computeIfAbsent(type, (t) -> new ArrayList<>());

                    ChromaDevice device = sdk1.getDevice(type);
                    if (device != null) {
                        deviceList.add(device);
                    }
                }

                devicesByBrand.computeIfAbsent(sdk.getKey(), (b) -> new ArrayList<>()).addAll(sdk1.connectedDevices());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Optional<List<ChromaDevice>> devicesByBrand(Brand brand) {
        return Optional.ofNullable(devicesByBrand.get(brand));
    }

    @Override
    public Optional<List<ChromaDevice>> devicesByType(DeviceType deviceType) {
        return Optional.ofNullable(devicesByType.get(deviceType));
    }

    @Override
    public boolean hasDevice(Brand brand) {
        boolean result = false;
        if (implMap.containsKey(brand))
            result = implMap.get(brand).deviceCount() > 0;
        return result;
    }

    @Override
    public boolean hasSDK(Brand brand) {
        return this.implMap.containsKey(brand);
    }

    @Override
    public ChromaConfiguration config() {
        return this.configuration;
    }
}
