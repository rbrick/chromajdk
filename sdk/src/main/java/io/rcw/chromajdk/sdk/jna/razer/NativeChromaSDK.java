package io.rcw.chromajdk.sdk.jna.razer;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Guid;

public interface NativeChromaSDK extends Library {
   int Init();

   int UnInit();

   int CreateKeyboardEffect(int type, Pointer effect, Pointer effectId);

   int SetEffect(Guid.GUID effectId);
}
