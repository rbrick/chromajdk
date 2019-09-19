package io.rcw.chromajdk.sdk.internals.jna.corsair;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import io.rcw.chromajdk.sdk.internals.jna.corsair.protocol.CorsairProtocolDetails;

/**
 * Corsair SDK
 */
public interface NativeCUESDK extends Library {
    // checks file and protocol version of CUE to understand which of SDK functions can be used with this version of CUE
    CorsairProtocolDetails CorsairPerformProtocolHandshake();

    // set specified leds to some colors.The color is retained until changed by successive calls.This function does not take logical layout into account
    boolean CorsairSetLedsColors(int size, Pointer data);

    boolean CorsairSetLedsColorsAsync(int size, Pointer data);

    // returns number of connected Corsair devices that support lighting control.
    int CorsairGetDeviceCount();

    // returns information about device at provided index
    Pointer CorsairGetDeviceInfo(int deviceIndex);

    // provides list of keyboard LEDs with their physical positions.
    Pointer CorsairGetLedPositions();

    // retrieves led id for key name taking logical layout into account.
    int CorsairGetLedIdForKeyName(char keyName);
}
