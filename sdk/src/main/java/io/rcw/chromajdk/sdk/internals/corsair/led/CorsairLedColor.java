package io.rcw.chromajdk.sdk.internals.corsair.led;

import io.rcw.chromajdk.sdk.internals.corsair.CorsairKey;

import java.awt.Color;

public final class CorsairLedColor {
    private CorsairKey ledId;
    private Color color;

    public CorsairLedColor(CorsairKey ledId, Color color) {
        this.ledId = ledId;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public CorsairKey getLedId() {
        return ledId;
    }
}
