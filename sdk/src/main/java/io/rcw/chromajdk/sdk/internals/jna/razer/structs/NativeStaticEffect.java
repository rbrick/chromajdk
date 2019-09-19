package io.rcw.chromajdk.sdk.internals.jna.razer.structs;

import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.Brand;
import io.rcw.chromajdk.sdk.ChromaDevice;
import io.rcw.chromajdk.sdk.internals.jna.razer.NativeEffect;
import io.rcw.chromajdk.sdk.internals.razer.RazerChromaDevice;
import io.rcw.chromajdk.sdk.internals.razer.effects.RazerStaticEffect;
import io.rcw.chromajdk.sdk.utils.ColorUtils;

import java.awt.Color;


public final class NativeStaticEffect implements RazerStaticEffect, NativeEffect {

    private Color color;

    public NativeStaticEffect(Color color) {
        this.color = color;
    }

    @Override
    public Structure toStructure() {
        return new NativeStaticEffectStruct(ColorUtils.getBGR(color));
    }

    @Override
    public Color color() {
        return color;
    }

    @Override
    public void apply(ChromaDevice device) {
        if (device.getBrand() == Brand.RAZER) {
            ((RazerChromaDevice) device).setStaticColor(color);
        }
    }

    @Structure.FieldOrder({"color"})
    public static class NativeStaticEffectStruct extends Structure implements Structure.ByReference {
        public int color;

        public NativeStaticEffectStruct(int color) {
            this.color = color;
        }
    }
}
