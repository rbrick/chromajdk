package io.rcw.chromajdk.sdk.internals.razer;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.internals.jna.razer.NativeChromaSDK;
import io.rcw.chromajdk.sdk.internals.jna.razer.NativeEffect;
import io.rcw.chromajdk.sdk.internals.razer.effects.RazerEffect;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public final class RazerChromaSDK {

    private static final Supplier<RazerChromaSDK> INSTANCE = new Supplier<RazerChromaSDK>() {
        private RazerChromaSDK sdkInstance;

        @Override
        public RazerChromaSDK get() {
            if (sdkInstance == null)
                (sdkInstance = new RazerChromaSDK()).nativeChromaSDK().Init();
            return sdkInstance;
        }
    };

    private NativeChromaSDK nativeInstance = Native.load("RzChromaSDK64", NativeChromaSDK.class);


    public NativeChromaSDK nativeChromaSDK() {
        return nativeInstance;
    }

    public static RazerChromaSDK getInstance() {
        return INSTANCE.get();
    }


    public void createKeyboardEffect(ChromaKeyboardEffectType type, RazerEffect effect) {
        if (effect instanceof NativeEffect) {
            Structure struct = ((NativeEffect) effect).toStructure();
            {
                struct.write();
            }
            nativeInstance.CreateKeyboardEffect(type.ordinal(), struct.getPointer(), Pointer.NULL);
        }
    }
}
