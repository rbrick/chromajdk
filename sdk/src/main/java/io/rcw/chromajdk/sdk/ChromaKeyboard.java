package io.rcw.chromajdk.sdk;

import java.awt.Color;

public interface ChromaKeyboard extends ChromaDevice {
    void setColor(int[] keys, Color color);

    void setEffect(ChromaEffect effect);
}
