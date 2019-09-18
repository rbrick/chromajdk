package io.rcw.chromajdk.sdk;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Guid;
import io.rcw.chromajdk.sdk.jna.razer.NativeChromaSDK;
import io.rcw.chromajdk.sdk.jna.razer.structs.NativeStaticEffect;
import io.rcw.chromajdk.sdk.jna.razer.structs.NativeWaveEffect;
import io.rcw.chromajdk.sdk.razer.ChromaKeyboardEffectType;
import io.rcw.chromajdk.sdk.razer.effects.WaveEffect;
import io.rcw.chromajdk.sdk.utils.ColorUtils;

import java.awt.Color;

public class Test {

    public static void main(String[] args) {
        System.load("C:\\Program Files\\Razer Chroma SDK\\bin\\RzChromaSDK64.dll");

        NativeChromaSDK INSTANCE = Native.load("RzChromaSDK64", NativeChromaSDK.class);
        System.out.println(INSTANCE.Init());


        Guid.GUID effectId = Guid.GUID.fromString("{00000000-0000-0000-0000-000000000000}");

        effectId.write();

        System.out.println(ColorUtils.fromBGR(ColorUtils.getBGR(Color.PINK)));


        Structure waveEffectRL = new NativeWaveEffect(WaveEffect.WaveDirection.RIGHT_TO_LEFT).toStructure();

        waveEffectRL.write();

        Structure waveEffectLR = new NativeWaveEffect(WaveEffect.WaveDirection.LEFT_TO_RIGHT).toStructure();

        waveEffectLR.write();


        // 4 = Static Effect
        // 5 = spectrum cycling
        // 6 = Wave Effect
        Structure staticEffect = new NativeStaticEffect(Color.RED).toStructure();

        staticEffect.write();





        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                INSTANCE.UnInit()));

        long currentTime = System.currentTimeMillis();
        int currentIdx = 0;
        Structure[] options = {waveEffectRL, waveEffectLR};

        while (true) {

            if (System.currentTimeMillis() - currentTime >= 5000) {
                currentTime = System.currentTimeMillis();

                INSTANCE.CreateKeyboardEffect(ChromaKeyboardEffectType.WAVE.ordinal(), options[ currentIdx++ % options.length  ].getPointer(), Pointer.NULL);
            }
        }

    }
}
