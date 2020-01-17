package com.artiow.intellij.plugin.nyan;

import java.awt.*;

import static java.awt.Color.*;

/**
 * @author Artem Namednev
 */
@SuppressWarnings("UseJBColor")
public final class NyanRainbow {

    public static final Color[] RAINBOW_COLORS = new Color[]{RED, ORANGE, YELLOW, GREEN, CYAN, BLUE};
    public static final float[] RAINBOW_FRACTIONS = new float[]{0f, 1f / 4f, 21f / 48f, 27f / 48f, 3f / 4f, 1f};

    private NyanRainbow() { }

    public static LinearGradientPaint newGradient(float startX, float startY, float endX, float endY) {
        return new LinearGradientPaint(startX, startY, endX, endY, RAINBOW_FRACTIONS, RAINBOW_COLORS);
    }
}
