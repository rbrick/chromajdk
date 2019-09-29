package io.rcw.chromajdk.sdk;

import io.rcw.chromajdk.sdk.effects.custom.ChromaFlashEffect;
import io.rcw.chromajdk.sdk.internals.InternalDeviceManager;

import java.awt.Color;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        final ChromaFlashEffect effect = new ChromaFlashEffect(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA), 250, TimeUnit.MILLISECONDS);

        final DeviceManager deviceManager = new InternalDeviceManager(ChromaConfiguration.defaultConfiguration());

        deviceManager.initialize();

        if (deviceManager.hasDevice(Brand.RAZER)) {
            System.out.println("Has razer devices");
        }

        if (deviceManager.hasDevice(Brand.CORSAIR)) {
            System.out.println("Has corsair devices");
        }

        deviceManager.devicesByType(DeviceType.KEYBOARD).ifPresent(list -> list.forEach(device -> device.setEffect(effect)));

        while (true) {
        }
    }
}
