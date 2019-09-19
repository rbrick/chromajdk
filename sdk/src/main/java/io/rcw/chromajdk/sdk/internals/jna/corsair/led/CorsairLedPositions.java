package io.rcw.chromajdk.sdk.internals.jna.corsair.led;

import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.internals.corsair.led.CorsairLedPosition;

@Structure.FieldOrder({"numberOfLed", "pLedPositions"})
public final class CorsairLedPositions extends Structure {
    public int numberOfLed;
    public CorsairLedPosition.CorsairLedPositionStructure[] pLedPositions;
}
