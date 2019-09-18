package io.rcw.chromajdk.sdk.jna.razer;

import com.sun.jna.*;
import io.rcw.chromajdk.sdk.razer.ChromaKeyboardEffectType;

public interface NativeChromaSDK extends Library {
    NativeLong Init();

    NativeLong UnInit();

    NativeLong CreateKeyboardEffect(ChromaKeyboardEffectType effectType, Pointer effect, Pointer effectId);
}
