package com.artiow.intellij.plugin.nyan.util;

import com.intellij.openapi.util.ScalableIcon;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Artem Namednev
 */
final class AdaptiveIconImpl implements AdaptiveIcon {

    public final ScalableIcon content;


    AdaptiveIconImpl(ScalableIcon content) {
        this.content = content;
    }


    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        content.paintIcon(c, g, x, y);
    }

    @Override
    public int getIconWidth() {
        return content.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return content.getIconHeight();
    }


    @Override
    public float getScale() {
        return content.getScale();
    }

    @Override
    @NotNull
    public Icon scale(float scaleFactor) {
        return content.scale(scaleFactor);
    }


    @Override
    public Icon scaleToWidth(int width) {
        return scale((float) width / getIconWidth());
    }

    @Override
    public Icon scaleToHeight(int height) {
        return scale((float) height / getIconHeight());
    }
}
