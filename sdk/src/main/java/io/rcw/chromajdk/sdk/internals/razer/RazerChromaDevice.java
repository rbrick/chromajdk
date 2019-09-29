package io.rcw.chromajdk.sdk.internals.razer;

import io.rcw.chromajdk.sdk.AbstractChromaDevice;
import io.rcw.chromajdk.sdk.Brand;
import io.rcw.chromajdk.sdk.ChromaConfiguration;
import io.rcw.chromajdk.sdk.internals.razer.effects.RazerWaveEffect;

import java.awt.Color;

public abstract class RazerChromaDevice extends AbstractChromaDevice {

    public RazerChromaDevice(ChromaConfiguration configuration) {
        super(configuration);
    }

    @Override
    public Brand getBrand() {
        return Brand.RAZER;
    }

    public abstract void setWave(RazerWaveEffect.WaveDirection direction);

    public abstract void setStaticColor(Color color);
}
