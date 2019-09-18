package io.rcw.chromajdk.sdk.jna.razer;

import com.sun.jna.*;
import io.rcw.chromajdk.sdk.razer.ChromaKeyboardEffectType;

public interface NativeChromaSDK extends Library {
    void Init();

    void UnInit();

    void CreateKeyboardEffect(ChromaKeyboardEffectType effectType, Pointer effect, Pointer effectId);
}
