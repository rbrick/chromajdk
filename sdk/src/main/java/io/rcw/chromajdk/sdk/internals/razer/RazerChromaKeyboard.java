package io.rcw.chromajdk.sdk.internals.razer;

import io.rcw.chromajdk.sdk.ChromaConfiguration;
import io.rcw.chromajdk.sdk.internals.jna.razer.structs.NativeStaticEffect;
import io.rcw.chromajdk.sdk.internals.jna.razer.structs.NativeWaveEffect;
import io.rcw.chromajdk.sdk.internals.razer.effects.RazerWaveEffect;

import java.awt.Color;

public final class RazerChromaKeyboard extends RazerChromaDevice {

    public RazerChromaKeyboard(ChromaConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void setColor(Color color) {
        this.setStaticColor(color);
    }

    @Override
    public void setWave(RazerWaveEffect.WaveDirection direction) {
        RazerChromaSDK.getInstance(getConfiguration()).createKeyboardEffect(ChromaKeyboardEffectType.WAVE, new NativeWaveEffect(direction));
    }

    @Override
    public void setStaticColor(Color color) {
        RazerChromaSDK.getInstance(getConfiguration()).createKeyboardEffect(ChromaKeyboardEffectType.STATIC, new NativeStaticEffect(color));
    }

    @Override
    public void clearEffect() {
        RazerChromaSDK.getInstance(getConfiguration()).createKeyboardEffect(ChromaKeyboardEffectType.NONE, null);
    }
}
