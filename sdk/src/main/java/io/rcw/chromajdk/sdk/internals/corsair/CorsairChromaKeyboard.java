package io.rcw.chromajdk.sdk.internals.corsair;

import io.rcw.chromajdk.sdk.ChromaConfiguration;
import io.rcw.chromajdk.sdk.DeviceType;

import java.awt.Color;

public final class CorsairChromaKeyboard extends CorsairChromaDevice {
    public CorsairChromaKeyboard(ChromaConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void setColor(Color color) {
        CorsairChromaSDK.getInstance(getConfiguration()).setColorByDeviceType(DeviceType.KEYBOARD, color);
    }

    @Override
    public void clearEffect() {
        this.setColor(Color.BLACK);
    }
}
