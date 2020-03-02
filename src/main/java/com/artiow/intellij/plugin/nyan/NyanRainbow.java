package com.artiow.intellij.plugin.nyan;

import java.awt.*;

/**
 * @author Artem Namednev
 */
@SuppressWarnings("UseJBColor")
public interface NyanRainbow {

    Color RED = new Color(255, 0, 0);
    Color ORANGE = new Color(255, 153, 0);
    Color YELLOW = new Color(255, 255, 0);
    Color GREEN = new Color(51, 255, 0);
    Color BLUE = new Color(0, 153, 255);
    Color VIOLET = new Color(102, 51, 255);

    Color[] COLORS = new Color[]{RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET};
    float[] FRACTIONS = new float[]{0f, 1f / 4f, 21f / 48f, 27f / 48f, 3f / 4f, 1f};

    static LinearGradientPaint newGradient(float startX, float startY, float endX, float endY) {
        return new LinearGradientPaint(startX, startY, endX, endY, FRACTIONS, COLORS);
    }
}
