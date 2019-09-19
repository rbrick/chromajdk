package io.rcw.chromajdk.sdk;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import io.rcw.chromajdk.sdk.internals.corsair.CorsairKey;
import io.rcw.chromajdk.sdk.internals.corsair.led.CorsairLedColor;
import io.rcw.chromajdk.sdk.internals.corsair.led.CorsairLedPosition;
import io.rcw.chromajdk.sdk.internals.jna.corsair.NativeCUESDK;
import io.rcw.chromajdk.sdk.internals.jna.corsair.led.CorsairLedPositions;
import io.rcw.chromajdk.sdk.internals.jna.razer.structs.NativeWaveEffect;
import io.rcw.chromajdk.sdk.internals.razer.RazerChromaKeyboard;
import io.rcw.chromajdk.sdk.internals.razer.effects.RazerWaveEffect;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        System.load("C:\\Program Files\\Razer Chroma SDK\\bin\\RzChromaSDK64.dll");


        razerTest();

        while (true) {}
    }

    public static void razerTest() {
        ChromaDevice chromaKeyboard = new RazerChromaKeyboard();

        chromaKeyboard.setEffect( new NativeWaveEffect(RazerWaveEffect.WaveDirection.LEFT_TO_RIGHT)  );

    }

    public static void corsairTest() {
        NativeCUESDK nativeCUESDK = Native.load("CUESDK.x64", NativeCUESDK.class);


        nativeCUESDK.CorsairPerformProtocolHandshake();


        if (nativeCUESDK.CorsairGetDeviceCount() > 0) {

            CorsairLedPositions positions = nativeCUESDK.CorsairGetLedPositions();

            List<CorsairLedColor> corsairLedColors = new ArrayList<CorsairLedColor>();

            for (CorsairLedPosition.CorsairLedPositionStructure position : positions.pLedPositions) {
                if (position.ledId == CorsairKey.CLK_A.getId()) {
                    corsairLedColors.add(
                            new CorsairLedColor(CorsairKey.CLK_A, Color.RED)
                    );
                } else if (position.ledId == CorsairKey.CLK_W.getId()) {
                    corsairLedColors.add(
                            new CorsairLedColor(CorsairKey.CLK_W, Color.GREEN)
                    );
                } else if (position.ledId == CorsairKey.CLK_D.getId()) {
                    corsairLedColors.add(
                            new CorsairLedColor(CorsairKey.CLK_D, Color.BLUE)
                    );
                } else if (position.ledId == CorsairKey.CLK_S.getId()) {
                    corsairLedColors.add(
                            new CorsairLedColor(CorsairKey.CLK_D, Color.MAGENTA)
                    );
                } else {
                    corsairLedColors.add(
                            new CorsairLedColor(CorsairKey.fromId(position.ledId), Color.PINK)
                    );
                }

            }


            CorsairLedColor.CorsairLedColorStructure array = new CorsairLedColor.CorsairLedColorStructure();

            nativeCUESDK.CorsairSetLedsColors(array.size(), array.toArray(corsairLedColors.stream().map(CorsairLedColor::toStructure).collect(Collectors.toList()).toArray(new Structure[corsairLedColors.size()])));

            while (true) {
            }
        }
    }
}
