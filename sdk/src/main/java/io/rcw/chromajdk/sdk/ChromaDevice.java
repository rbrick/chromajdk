package io.rcw.chromajdk.sdk;

import java.awt.Color;

public interface ChromaDevice {
    void setColor(Color color);

    void setEffect(ChromaEffect effect);

    Brand getBrand();

    ChromaEffect getCurrentEffect();

    void clearEffect();
}
