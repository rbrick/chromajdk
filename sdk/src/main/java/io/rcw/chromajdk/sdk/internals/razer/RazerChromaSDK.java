package io.rcw.chromajdk.sdk.internals.razer;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Guid;
import io.rcw.chromajdk.sdk.AbstractChromaSDK;
import io.rcw.chromajdk.sdk.ChromaConfiguration;
import io.rcw.chromajdk.sdk.ChromaDevice;
import io.rcw.chromajdk.sdk.DeviceType;
import io.rcw.chromajdk.sdk.internals.jna.razer.NativeEffect;
import io.rcw.chromajdk.sdk.internals.jna.razer.NativeRazerChromaSDK;
import io.rcw.chromajdk.sdk.internals.razer.effects.RazerEffect;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class RazerChromaSDK extends AbstractChromaSDK {

    private static RazerChromaSDK instance;

    public static RazerChromaSDK getInstance(ChromaConfiguration defaultConfiguration) {
        if (instance == null) {
            (instance = new RazerChromaSDK()).initialize(defaultConfiguration);
        }
        return instance;
    }

    private NativeRazerChromaSDK nativeInstance = Native.load("RzChromaSDK64", NativeRazerChromaSDK.class);
    private Map<DeviceType, ChromaDevice> chromaDevices = new HashMap<>();

    private int deviceCount = 0;

    public NativeRazerChromaSDK nativeChromaSDK() {
        return nativeInstance;
    }


    public void createKeyboardEffect(ChromaKeyboardEffectType type, RazerEffect effect) {
        if (effect == null) {
            nativeInstance.CreateKeyboardEffect(type.ordinal(), Pointer.NULL, Pointer.NULL);
        } else if (effect instanceof NativeEffect) {
            Structure struct = ((NativeEffect) effect).toStructure();
            {
                struct.write();
            }
            nativeInstance.CreateKeyboardEffect(type.ordinal(), struct.getPointer(), Pointer.NULL);
        }
    }

    @Override
    public void initialize(ChromaConfiguration configuration) {
        super.initialize(configuration);

        this.nativeChromaSDK().Init();

        this.refreshDevices(configuration);
    }


    @Override
    public void uninitialize() {
        super.uninitialize();

        this.nativeInstance.UnInit();
    }

    private void refreshDevices(ChromaConfiguration configuration) {
        this.chromaDevices.clear();
        this.deviceCount = 0;

        for (RazerDevices device : RazerDevices.values()) {
            for (Guid.GUID deviceId : device.getDeviceIds()) {
                RazerDeviceInfo.RazerDeviceInfoStruct.ByReference r = new RazerDeviceInfo.RazerDeviceInfoStruct.ByReference();

                nativeInstance.QueryDevice(deviceId, r);
                r.read();

                deviceCount += r.connected;

                ChromaDeviceType type = ChromaDeviceType.values()[r.deviceType];
                ChromaDevice newDevice;
                if ((newDevice = type.newDevice(configuration)) != null) {
                    try {
                        DeviceType mappedType = DeviceType.valueOf(type.name());
                        chromaDevices.putIfAbsent(mappedType, newDevice);
                    } catch (Exception ignored) {
                    }
                }
            }
        }
    }

    @Override
    public int deviceCount() {
        return this.deviceCount;
    }

    @Override
    public Collection<ChromaDevice> connectedDevices() {
        return this.chromaDevices.values();
    }

    @Override
    public ChromaDevice getDevice(DeviceType type) {
        return chromaDevices.get(type);
    }
}
