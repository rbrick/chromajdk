package io.rcw.chromajdk.sdk.jna.razer.structs;

import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.jna.razer.NativeEffect;
import io.rcw.chromajdk.sdk.razer.effects.StaticEffect;
import io.rcw.chromajdk.sdk.utils.ColorUtils;

import java.awt.Color;


public final class NativeStaticEffect implements StaticEffect, NativeEffect {

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

    @Structure.FieldOrder({"color"})
    public static class NativeStaticEffectStruct extends Structure implements Structure.ByReference {
        public int color;

        public NativeStaticEffectStruct(int color) {
            this.color = color;
        }
    }
}
