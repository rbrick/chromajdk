package io.rcw.chromajdk.sdk;

import com.sun.jna.Native;
import io.rcw.chromajdk.sdk.jna.razer.NativeChromaSDK;

public class Test {

    public static void main(String[] args) {
        System.load("C:\\Program Files\\Razer Chroma SDK\\bin\\RzChromaSDK64.dll");

        NativeChromaSDK INSTANCE = Native.load("RzChromaSDK64", NativeChromaSDK.class);
        INSTANCE.Init();


    }
}
