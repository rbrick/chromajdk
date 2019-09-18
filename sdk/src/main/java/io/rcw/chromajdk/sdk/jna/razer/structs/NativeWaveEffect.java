package io.rcw.chromajdk.sdk.jna.razer.structs;

import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.jna.razer.NativeEffect;
import io.rcw.chromajdk.sdk.razer.effects.WaveEffect;

public final class NativeWaveEffect implements WaveEffect, NativeEffect {

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

    @Structure.FieldOrder({"dir"})
    public static class NativeWaveEffectStruct extends Structure implements Structure.ByReference {
        public int dir;

        public NativeWaveEffectStruct(int dir) {
            this.dir = dir;
        }
    }

}
