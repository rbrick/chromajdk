package io.rcw.chromajdk.sdk.internals.corsair.device;

import io.rcw.chromajdk.sdk.internals.corsair.CorsairDeviceCaps;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairDeviceType;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairLogicalLayout;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairPhysicalLayout;

public final class CorsairDeviceInfo {
    private CorsairDeviceType deviceType;
    private String model;
    private CorsairPhysicalLayout physicalLayout;
    private CorsairLogicalLayout logicalLayout;
    private int capsMask;

    public CorsairDeviceInfo(CorsairDeviceType deviceType,
                             String model,
                             CorsairPhysicalLayout physicalLayout,
                             CorsairLogicalLayout logicalLayout,
                             int capsMask) {
        this.deviceType = deviceType;
        this.model = model;
        this.physicalLayout = physicalLayout;
        this.logicalLayout = logicalLayout;
        this.capsMask = capsMask;
    }

    public boolean hasLighting() {
        return (this.capsMask & CorsairDeviceCaps.LIGHTING.ordinal()) > 0;
    }

    public CorsairDeviceType getDeviceType() {
        return deviceType;
    }

    public String getModel() {
        return model;
    }

    public CorsairPhysicalLayout getPhysicalLayout() {
        return physicalLayout;
    }

    public CorsairLogicalLayout getLogicalLayout() {
        return logicalLayout;
    }
}
