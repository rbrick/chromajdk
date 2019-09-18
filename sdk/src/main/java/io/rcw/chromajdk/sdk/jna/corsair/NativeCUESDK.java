package io.rcw.chromajdk.sdk.jna.corsair;

import com.sun.jna.Library;

/**
 * Corsair SDK
 */
public interface NativeCUESDK extends Library {
    void CorsairPerformProtocolHandshake();

    void CorsairSetLedsColors(int size, int[] data);

    void CorsairSetLedsColorsAsync();
}
