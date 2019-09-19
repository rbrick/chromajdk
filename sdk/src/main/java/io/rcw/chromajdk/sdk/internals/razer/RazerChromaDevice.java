package io.rcw.chromajdk.sdk.internals.razer;

import io.rcw.chromajdk.sdk.Brand;
import io.rcw.chromajdk.sdk.ChromaDevice;
import io.rcw.chromajdk.sdk.ChromaEffect;
import io.rcw.chromajdk.sdk.internals.razer.effects.RazerWaveEffect;

import java.awt.Color;

public abstract class RazerChromaDevice implements ChromaDevice {
    @Override
    public Brand getBrand() {
        return Brand.RAZER;
    }

    public abstract void setWave(RazerWaveEffect.WaveDirection direction);

    public abstract void setStaticColor(Color color);

    @Override
    public void setEffect(ChromaEffect effect) {
        effect.apply(this);
    }
}
