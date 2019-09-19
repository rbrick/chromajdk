package io.rcw.chromajdk.sdk.internals.jna.razer.structs;

import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.Brand;
import io.rcw.chromajdk.sdk.ChromaDevice;
import io.rcw.chromajdk.sdk.internals.jna.razer.NativeEffect;
import io.rcw.chromajdk.sdk.internals.razer.RazerChromaDevice;
import io.rcw.chromajdk.sdk.internals.razer.effects.RazerWaveEffect;

public final class NativeWaveEffect implements RazerWaveEffect, NativeEffect {

    private WaveDirection waveDirection;

    public NativeWaveEffect(WaveDirection direction) {
        this.waveDirection = direction;
    }

    @Override
    public Structure toStructure() {
        return new NativeWaveEffectStruct(this.waveDirection.ordinal() + 1);
    }

    @Override
    public WaveDirection direction() {
        return waveDirection;
    }

    @Override
    public void apply(ChromaDevice device) {
        if (device.getBrand() == Brand.RAZER) {
            ((RazerChromaDevice) device).setWave(waveDirection);
        }
    }

    @Structure.FieldOrder({"dir"})
    public static class NativeWaveEffectStruct extends Structure implements Structure.ByReference {
        public int dir;

        public NativeWaveEffectStruct(int dir) {
            this.dir = dir;
        }
    }

}
