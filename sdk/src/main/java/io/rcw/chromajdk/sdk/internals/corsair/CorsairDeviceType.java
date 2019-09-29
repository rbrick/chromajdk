package io.rcw.chromajdk.sdk.internals.corsair;

import io.rcw.chromajdk.sdk.ChromaConfiguration;

public enum CorsairDeviceType {
    UNKNOWN,
    MOUSE,
    KEYBOARD {
        @Override
        public CorsairChromaDevice newDevice(ChromaConfiguration configuration) {
            return new CorsairChromaKeyboard(configuration);
        }
    },
    HEADSET,
    MOUSE_MAT,
    HEADSET_STAND,
    COMMANDER_PRO,
    LIGHTING_NODE_PRO,
    MEMORY_MODULE,
    COOLER;

    public CorsairChromaDevice newDevice(ChromaConfiguration configuration) {
        return null;
    }
}
