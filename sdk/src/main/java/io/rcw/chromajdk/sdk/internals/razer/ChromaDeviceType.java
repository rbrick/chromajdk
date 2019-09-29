package io.rcw.chromajdk.sdk.internals.razer;

import io.rcw.chromajdk.sdk.ChromaConfiguration;
import io.rcw.chromajdk.sdk.ChromaDevice;

public enum ChromaDeviceType {

    UNKNOWN(0),
    KEYBOARD(1) {  //!< Keyboard device.
        @Override
        public ChromaDevice newDevice(ChromaConfiguration configuration) {
            return new RazerChromaKeyboard(configuration);
        }
    },
    MOUSE(2), //!< Mouse device.
    HEADSET(3), //!< Headset device.
    MOUSEPAD(4), //!< Mousepad device.
    KEYPAD(5), //!< Keypad device.
    SYSTEM(6), //! < System device.
    SPEAKERS(7), //!< Speakers.
    INVALID(8);  //!< Invalid device.


    private int type;

    ChromaDeviceType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }


    public ChromaDevice newDevice(ChromaConfiguration configuration) {
        return null;
    }

}
