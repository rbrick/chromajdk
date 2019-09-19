package io.rcw.chromajdk.sdk.internals.razer.effects;

import io.rcw.chromajdk.sdk.ChromaEffect;

public interface RazerWaveEffect extends RazerEffect {

    enum WaveDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        FRONT_TO_BACK,
        BACK_TO_FRONT
    }


    WaveDirection direction();

}
