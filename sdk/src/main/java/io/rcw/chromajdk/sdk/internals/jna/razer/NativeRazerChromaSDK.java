package io.rcw.chromajdk.sdk.internals.jna.razer;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Guid;
import io.rcw.chromajdk.sdk.internals.razer.RazerDeviceInfo;

public interface NativeRazerChromaSDK extends Library {
    int Init();

    int UnInit();

    int CreateKeyboardEffect(int type, Pointer effect, Pointer effectId);

    int CreateMouseEffect(int type, Pointer effect, Pointer effectId);

    int SetEffect(Guid.GUID effectId);

    int QueryDevice(Guid.GUID deviceId, RazerDeviceInfo.RazerDeviceInfoStruct.ByReference deviceInfo);
}
