package io.rcw.chromajdk.sdk.internals.razer;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public final class RazerDeviceInfo {

    private ChromaDeviceType deviceType;
    private int connected;

    public int getConnected() {
        return connected;
    }

    public ChromaDeviceType getDeviceType() {
        return deviceType;
    }

    public RazerDeviceInfo(int connected, int deviceType) {
        this.deviceType = ChromaDeviceType.values()[deviceType];
        this.connected = connected;
    }

    @Structure.FieldOrder({"deviceType", "connected"})
    public static class RazerDeviceInfoStruct extends Structure {
        public int deviceType, connected;

        public RazerDeviceInfoStruct() {
        }

        public RazerDeviceInfoStruct(int deviceType, int connected) {
            this.connected = connected;
            this.deviceType = deviceType;
        }

        public RazerDeviceInfoStruct(Pointer peer) {
            super(peer);
        }

        public static class ByReference extends RazerDeviceInfoStruct implements Structure.ByReference {
        }

        public static class ByValue extends RazerDeviceInfoStruct implements Structure.ByValue {
        }
    }

}
