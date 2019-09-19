package io.rcw.chromajdk.sdk.internals.jna.corsair;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.internals.corsair.device.CorsairDeviceInfo;
import io.rcw.chromajdk.sdk.internals.corsair.led.CorsairLedColor;
import io.rcw.chromajdk.sdk.internals.jna.corsair.led.CorsairLedPositions;
import io.rcw.chromajdk.sdk.internals.jna.corsair.protocol.CorsairProtocolDetails;

/**
 * Corsair SDK
 */
public interface NativeCUESDK extends Library {
    /**
     * contains list of available SDK access modes<br>
     * <i>native declaration : line 64</i><br>
     * enum values
     */
    public static interface CorsairAccessMode {
        /**
         * <i>native declaration : line 66</i>
         */
        public static final int CAM_ExclusiveLightingControl = 0;
    }

    ;

    /**
     * contains shared list of all errors which could happen during calling of Corsair* functions<br>
     * <i>native declaration : line 69</i><br>
     * enum values
     */
    public static interface CorsairError {
        /**
         * if previously called function completed successfully<br>
         * <i>native declaration : line 71</i>
         */
        public static final int CE_Success = 0;
        /**
         * CUE is not running or was shut down or third-party control is disabled in CUE settings(runtime error)<br>
         * <i>native declaration : line 72</i>
         */
        public static final int CE_ServerNotFound = 1;
        /**
         * if some other client has or took over exclusive control (runtime error)<br>
         * <i>native declaration : line 73</i>
         */
        public static final int CE_NoControl = 2;
        /**
         * if developer did not perform protocol handshake(developer error)<br>
         * <i>native declaration : line 74</i>
         */
        public static final int CE_ProtocolHandshakeMissing = 3;
        /**
         * if developer is calling the function that is not supported by the server(either because protocol has broken by server or client or because the function is new and server is too old. Check CorsairProtocolDetails for details) (developer error)<br>
         * <i>native declaration : line 75</i>
         */
        public static final int CE_IncompatibleProtocol = 4;
        /**
         * if developer supplied invalid arguments to the function(for specifics look at function descriptions). (developer error)<br>
         * <i>native declaration : line 76</i>
         */
        public static final int CE_InvalidArguments = 5;
    }

    ;

    /**
     * <i>native declaration : line 125</i>
     */
    public interface CorsairSetLedsColorsAsync_CallbackType_callback extends Callback {
        void apply(Pointer voidPtr1, byte bool1, int CorsairError1);
    }

    ;

    /**
     * Original signature : <code>bool CorsairSetLedsColors(int, CorsairLedColor*)</code><br>
     * <i>native declaration : line 123</i>
     */
    byte CorsairSetLedsColors(int size, Structure[] ledsColors);

    /**
     * Original signature : <code>bool CorsairSetLedsColorsAsync(int, CorsairLedColor*, CorsairSetLedsColorsAsync_CallbackType_callback*, void*)</code><br>
     * <i>native declaration : line 125</i>
     */
    byte CorsairSetLedsColorsAsync(int size, Structure[] ledsColors, NativeCUESDK.CorsairSetLedsColorsAsync_CallbackType_callback CallbackType, Pointer context);

    /**
     * Original signature : <code>int CorsairGetDeviceCount()</code><br>
     * <i>native declaration : line 128</i>
     */
    int CorsairGetDeviceCount();

    /**
     * Original signature : <code>CorsairDeviceInfo* CorsairGetDeviceInfo(int)</code><br>
     * <i>native declaration : line 131</i>
     */
    CorsairDeviceInfo CorsairGetDeviceInfo(int deviceIndex);

    /**
     * Original signature : <code>CorsairLedPositions* CorsairGetLedPositions()</code><br>
     * <i>native declaration : line 134</i>
     */
    CorsairLedPositions CorsairGetLedPositions();

    /**
     * Original signature : <code>CorsairLedId CorsairGetLedIdForKeyName(char)</code><br>
     * <i>native declaration : line 137</i>
     */
    int CorsairGetLedIdForKeyName(byte keyName);

    /**
     * Original signature : <code>bool CorsairRequestControl(CorsairAccessMode)</code><br>
     * <i>native declaration : line 140</i>
     */
    byte CorsairRequestControl(int accessMode);

    /**
     * Original signature : <code>CorsairProtocolDetails CorsairPerformProtocolHandshake()</code><br>
     * <i>native declaration : line 143</i>
     */
    CorsairProtocolDetails CorsairPerformProtocolHandshake();

    /**
     * Original signature : <code>CorsairError CorsairGetLastError()</code><br>
     * <i>native declaration : line 146</i>
     */
    int CorsairGetLastError();

    /**
     * Original signature : <code>bool CorsairReleaseControl(CorsairAccessMode)</code><br>
     * <i>native declaration : line 149</i>
     */
    byte CorsairReleaseControl(int accessMode);
}
