package io.rcw.chromajdk.sdk.utils;

import java.awt.Color;

public final class ColorUtils {

    public static int getBGR(Color color) {
        return (color.getBlue() & 0xFF) << 16 | (color.getGreen() & 0xFF) << 8 | (color.getRed() & 0xFF);

    }

    public static Color fromBGR(int color) {
        return new Color(
                color & 0xFF,
                (color >> 8) & 0xFF,
                (color >> 16) & 0xFF
        );

    }
}
