package io.rcw.chromajdk.sdk.internals.corsair.led;

import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairKey;

public final class CorsairLedPosition {

    @Structure.FieldOrder({"ledId", "top", "left", "height", "width"})
    public static final class CorsairLedPositionStructure extends Structure implements Structure.ByReference {
        public int ledId;
        public double top, left, height, width;

        public CorsairLedPositionStructure(int ledId, double top, double left, double height, double width) {
            this.ledId = ledId;
            this.top = top;
            this.left = left;
            this.height = height;
            this.width = width;
        }
    }


    private CorsairKey ledId;
    private double top, left, height, width;

    public CorsairLedPosition(CorsairKey ledId, double top, double left, double height, double width) {
        this.ledId = ledId;
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
    }

    public CorsairKey getLedId() {
        return ledId;
    }

    public double getTop() {
        return top;
    }

    public double getLeft() {
        return left;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Structure toStructure() {
        return new CorsairLedPositionStructure(ledId.getId(), top, left, height, width);
    }
}