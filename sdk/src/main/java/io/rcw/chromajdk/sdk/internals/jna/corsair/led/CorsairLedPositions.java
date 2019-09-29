package io.rcw.chromajdk.sdk.internals.jna.corsair.led;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.internals.corsair.led.CorsairLedPosition;

import java.util.Arrays;
import java.util.List;

@Structure.FieldOrder({"numberOfLed", "pLedPosition"})
public class CorsairLedPositions extends Structure {
    /**
     * integer value.Number of elements in following array
     */
    public int numberOfLed;
    /**
     * array of led positions<br>
     * C type : CorsairLedPosition*
     */
    public CorsairLedPosition.CorsairLedPositionStructure pLedPosition;

    public CorsairLedPositions() {
        super();
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("numberOfLed", "pLedPosition");
    }

    /**
     * @param numberOfLed  integer value.Number of elements in following array<br>
     * @param pLedPosition array of led positions<br>
     *                     C type : CorsairLedPosition*
     */
    public CorsairLedPositions(int numberOfLed, CorsairLedPosition.CorsairLedPositionStructure pLedPosition) {
        super();
        this.numberOfLed = numberOfLed;
        this.pLedPosition = pLedPosition;
    }

    public CorsairLedPositions(Pointer peer) {
        super(peer);
    }

    public static class ByReference extends CorsairLedPositions implements Structure.ByReference {

    };

    public static class ByValue extends CorsairLedPositions implements Structure.ByValue {

    };
}
