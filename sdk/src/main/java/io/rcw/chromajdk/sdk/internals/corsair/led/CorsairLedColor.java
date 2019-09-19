package io.rcw.chromajdk.sdk.internals.corsair.led;

import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairKey;

import java.awt.Color;

public final class CorsairLedColor {
    private CorsairKey ledId;
    private Color color;


    public CorsairLedColor() {
    }

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


    public CorsairLedColorStructure toStructure() {
        return new CorsairLedColorStructure(ledId, color);
    }

    public static class CorsairLedColorStructure extends Structure implements Structure.ByReference {
        public int ledId, r, g, b;

        public CorsairLedColorStructure() {
        }

        public CorsairLedColorStructure(CorsairKey ledId, Color color) {
            this.ledId = ledId.getId();
            this.r = color.getRed();
            this.g = color.getGreen();
            this.b = color.getBlue();
        }
    }
}
