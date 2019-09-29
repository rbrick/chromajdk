package io.rcw.chromajdk.sdk.internals.corsair.device;

import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairDeviceCaps;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairDeviceType;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairLogicalLayout;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairPhysicalLayout;
@Structure.FieldOrder({"deviceType", "model", "physicalLayout", "logicalLayout", "capsMask", "ledsCount"})
public class CorsairDeviceInfo extends Structure {
    public int deviceType;
    public String model;
    public int physicalLayout;
    public int logicalLayout;
    public int capsMask, ledsCount;

    public CorsairDeviceInfo() {}

    public CorsairDeviceInfo(CorsairDeviceType deviceType,
                             String model,
                             CorsairPhysicalLayout physicalLayout,
                             CorsairLogicalLayout logicalLayout,
                             int capsMask, int ledsCount) {
        this.deviceType = deviceType.ordinal();
        this.model = model;
        this.physicalLayout = physicalLayout.ordinal();
        this.logicalLayout = logicalLayout.ordinal();
        this.capsMask = capsMask;
        this.ledsCount = ledsCount;
    }

    public boolean hasLighting() {
        return (this.capsMask & CorsairDeviceCaps.LIGHTING.ordinal()) > 0;
    }

    public CorsairDeviceType getDeviceType() {
        return CorsairDeviceType.values()[deviceType];
    }

    public String getModel() {
        return model;
    }

    public CorsairPhysicalLayout getPhysicalLayout() {
        return CorsairPhysicalLayout.values()[physicalLayout];
    }

    public CorsairLogicalLayout getLogicalLayout() {
        return CorsairLogicalLayout.values()[logicalLayout];
    }

    public int getLedsCount() {
        return ledsCount;
    }


    public static class ByValue extends CorsairDeviceInfo implements Structure.ByValue {
    }

    public static class ByReference extends CorsairDeviceInfo implements Structure.ByReference {
    }

}
