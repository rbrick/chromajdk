package io.rcw.chromajdk.sdk.internals.jna.corsair.protocol;

import com.sun.jna.Structure;

@Structure.FieldOrder({"sdkVersion", "serverVersion", "sdkProtocolVersion", "serverProtocolVersion", "breakingChanges"})
public final class CorsairProtocolDetails extends Structure implements Structure.ByReference {
    public String sdkVersion;
    public String serverVersion;
    public int sdkProtocolVersion;
    public int serverProtocolVersion;
    public boolean breakingChanges;
}
