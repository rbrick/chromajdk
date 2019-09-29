package io.rcw.chromajdk.sdk.internals.corsair;

import com.sun.jna.Native;
import io.rcw.chromajdk.sdk.AbstractChromaSDK;
import io.rcw.chromajdk.sdk.ChromaConfiguration;
import io.rcw.chromajdk.sdk.ChromaDevice;
import io.rcw.chromajdk.sdk.DeviceType;
import io.rcw.chromajdk.sdk.internals.corsair.device.CorsairDeviceInfo;
import io.rcw.chromajdk.sdk.internals.corsair.led.CorsairLedColor;
import io.rcw.chromajdk.sdk.internals.corsair.led.CorsairLedPosition;
import io.rcw.chromajdk.sdk.internals.jna.corsair.NativeCUESDK;
import io.rcw.chromajdk.sdk.internals.jna.corsair.led.CorsairLedPositions;

import java.awt.Color;
import java.util.*;

public final class CorsairChromaSDK extends AbstractChromaSDK {
    private static CorsairChromaSDK instance;

    public static CorsairChromaSDK getInstance(ChromaConfiguration defaultConfiguration) {
        if (instance == null) {
            (instance = new CorsairChromaSDK()).initialize(defaultConfiguration);
        }
        return instance;
    }

    private final NativeCUESDK nativeCUESDK = Native.load("CUESDK.x64_2017", NativeCUESDK.class);

    private Map<DeviceType, ChromaDevice> chromaDevices = new HashMap<>();

    public void setColorByDeviceType(DeviceType type, Color color) {
        for (int i = 0; i < this.deviceCount(); i++) {
            if (nativeCUESDK.CorsairGetDeviceInfo(i).getDeviceType() == CorsairDeviceType.valueOf(type.name())) {
                CorsairLedPositions positions = nativeCUESDK.CorsairGetLedPositionsByDeviceIndex(i);
                if (positions.numberOfLed > 0) {
                    CorsairLedPosition.CorsairLedPositionStructure[] nativePos = (CorsairLedPosition.CorsairLedPositionStructure[]) positions.pLedPosition.toArray(new CorsairLedPosition.CorsairLedPositionStructure[positions.numberOfLed]);

                    List<CorsairLedColor> corsairLedColors = new ArrayList<>();

                    for (CorsairLedPosition.CorsairLedPositionStructure position : nativePos) {
                        corsairLedColors.add(
                                new CorsairLedColor(Objects.requireNonNull(CorsairKey.fromId(position.ledId)), color)
                        );
                    }

                    this.setColors(corsairLedColors);
                }
            }
        }
    }

    public void setColors(List<CorsairLedColor> colors) {
        nativeCUESDK.CorsairSetLedsColors(colors.size(), this.writeArray(colors));
    }

    private CorsairLedColor.CorsairLedColorStructure writeArray(List<CorsairLedColor> corsairLedColors) {
        CorsairLedColor.CorsairLedColorStructure[] array = (CorsairLedColor.CorsairLedColorStructure[]) new CorsairLedColor.CorsairLedColorStructure().toArray(corsairLedColors.size());

        for (int i = 0; i < corsairLedColors.size(); i++) {
            array[i].ledId = corsairLedColors.get(i).getLedId().getId();
            array[i].r = corsairLedColors.get(i).getColor().getRed();
            array[i].g = corsairLedColors.get(i).getColor().getGreen();
            array[i].b = corsairLedColors.get(i).getColor().getBlue();

            array[i].write();
        }

        return array[0];
    }

    @Override
    public void initialize(ChromaConfiguration configuration) {
        super.initialize(configuration);

        nativeCUESDK.CorsairPerformProtocolHandshake();
        for (int i = 0; i < nativeCUESDK.CorsairGetDeviceCount(); i++) {
            CorsairLedPositions positions = nativeCUESDK.CorsairGetLedPositionsByDeviceIndex(i);
            if (positions.numberOfLed > 0) {
                CorsairDeviceInfo deviceInfo = nativeCUESDK.CorsairGetDeviceInfo(i);

                CorsairDeviceType deviceType = deviceInfo.getDeviceType();

                ChromaDevice newDevice;
                if ((newDevice = deviceType.newDevice(configuration)) != null) {
                    try {
                        DeviceType mappedType = DeviceType.valueOf(deviceType.name());
                        chromaDevices.putIfAbsent(mappedType, newDevice);
                    } catch (Exception ignored) {
                    }
                }

            }
        }

    }

    @Override
    public void uninitialize() {
        super.uninitialize();
    }

    @Override
    public int deviceCount() {
        return nativeCUESDK.CorsairGetDeviceCount();
    }

    @Override
    public Collection<ChromaDevice> connectedDevices() {
        return chromaDevices.values();
    }

    @Override
    public ChromaDevice getDevice(DeviceType type) {
        return chromaDevices.get(type);
    }
}
