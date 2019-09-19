package io.rcw.chromajdk.sdk.internals.razer.effects;

public interface WaveEffect {

    enum WaveDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        FRONT_TO_BACK,
        BACK_TO_FRONT
    }


    WaveDirection direction();

}
