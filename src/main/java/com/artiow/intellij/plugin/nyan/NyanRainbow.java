package com.artiow.intellij.plugin.nyan;

import java.awt.*;

import static java.awt.Color.*;

/**
 * @author Artem Namednev
 */
@SuppressWarnings("UseJBColor")
public final class NyanRainbow {

    public static final Color[] RAINBOW_COLORS = new Color[]{RED, ORANGE, YELLOW, GREEN, CYAN, BLUE};
    public static final float[] RAINBOW_FRACTIONS = new float[]{1f / 6, 2f / 6, 3f / 6, 4f / 6, 5f / 6, 1f};

    private NyanRainbow() { }

    public static LinearGradientPaint getGradient(float startX, float startY, float endX, float endY) {
        return new LinearGradientPaint(startX, startY, endX, endY, RAINBOW_FRACTIONS, RAINBOW_COLORS);
    }
}
