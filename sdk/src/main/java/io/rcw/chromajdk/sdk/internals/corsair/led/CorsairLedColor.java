package io.rcw.chromajdk.sdk.internals.corsair.led;

import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairKey;

import java.awt.Color;

public final class CorsairLedColor {
    private int ledId;
    private Color color;


    public CorsairLedColor() {
    }

    public CorsairLedColor(CorsairKey ledId, Color color) {
        this.ledId = ledId.getId();
        this.color = color;
    }

    public CorsairLedColor(int id, Color color) {
        this.ledId = id;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public CorsairKey getLedId() {
        return CorsairKey.fromId(ledId);
    }


    public CorsairLedColorStructure toStructure() {
        CorsairLedColorStructure structure = new CorsairLedColorStructure(ledId, color);
        structure.write();
        return structure;
    }

    @Structure.FieldOrder({"ledId", "r", "g", "b"})
    public static class CorsairLedColorStructure extends Structure  {
        public int ledId, r, g, b;

        public CorsairLedColorStructure() {
        }

        public CorsairLedColorStructure(int ledId, Color color) {
            this.ledId = ledId;
            this.r = color.getRed();
            this.g = color.getGreen();
            this.b = color.getBlue();
        }


        public static class ByReference extends CorsairLedColorStructure implements Structure.ByReference {

        }
    }
}
