package com.artiow.intellij.plugin.nyan.basic;

import com.intellij.ui.JBColor;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import static java.lang.Math.ceil;
import static java.lang.Math.max;
import static javax.swing.SwingConstants.HORIZONTAL;

/**
 * @author Artem Namednev
 */
public abstract class SliderProgressBarUI extends BasicProgressBarUI {

    @Override
    protected void paintIndeterminate(Graphics g, JComponent c) {
        if (isNotSupported(g, c)) {
            super.paintIndeterminate(g, c);
        } else {
            paintIndeterminate((Graphics2D) g, c);
        }
    }

    protected abstract void paintIndeterminate(Graphics2D g, JComponent c);


    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        if (isNotSupported(g, c)) {
            super.paintDeterminate(g, c);
        } else {
            paintDeterminate((Graphics2D) g, c);
        }
    }

    protected abstract void paintDeterminate(Graphics2D g, JComponent c);


    protected boolean isNotSupported(Graphics g, JComponent c) {
        return !(g instanceof Graphics2D) || progressBar.getOrientation() != HORIZONTAL;
    }


    protected void paintSlider(Graphics2D g, SliderSettings slider, SliderBodySettings sliderBody, SliderHeadSettings sliderHead) {
        int sliderBodyPadding = slider.border + slider.padding;
        int sliderBodyX = slider.x + sliderBodyPadding + sliderBody.leftOffset;
        int sliderBodyY = slider.x + sliderBodyPadding;
        int sliderBodyW = slider.w - 2 * sliderBodyPadding - sliderBody.rightOffset;
        int sliderBodyH = slider.h - 2 * sliderBodyPadding;
        float sliderBodyRadius = max(slider.radius - sliderBodyPadding, 0);
        paintSliderBackground(g, slider.x, slider.y, slider.w, slider.h, slider.border, slider.radius);
        paintSliderBody(g, sliderBodyX, sliderBodyY, sliderBodyW, sliderBodyH, sliderBodyRadius);
        paintSliderHead(g, sliderHead.icon, slider.x, slider.y, slider.w, slider.h, sliderHead.position);
    }


    private void paintSliderBackground(Graphics2D g, int x, int y, int w, int h, int border, float radius) {
        g.setColor(progressBar.getBackground());
        g.fill(new RoundRectangle2D.Float(x, y, w, h, 0, 0));
        g.setColor(progressBar.getForeground());
        g.fill(new RoundRectangle2D.Float(x, y, w, h, radius, radius));
        g.setColor(progressBar.getBackground());
        g.fill(new RoundRectangle2D.Float(x + border, y + border, w - 2 * border, h - 2 * border, max(radius - border, 0), max(radius - border, 0)));
    }

    private void paintSliderBody(Graphics2D g, int x, int y, int w, int h, float radius) {
        g.setPaint(getSliderBodyPaint(g, x, y, w, h, radius));
        g.fill(new RoundRectangle2D.Float(x, y, w, h, radius, radius));
    }

    private void paintSliderHead(Graphics2D g, Icon icon, int x, int y, int w, int h, float position) {
        int positionShift = (int) ceil((w - icon.getIconWidth()) * position);
        icon.paintIcon(progressBar, g, x + positionShift, y);
    }


    protected Paint getSliderBodyPaint(Graphics2D g, int x, int y, int w, int h, float radius) {
        return JBColor.GREEN;
    }


    @RequiredArgsConstructor
    public static class SliderSettings {

        private final int x;
        private final int y;
        private final int w;
        private final int h;
        private final int border;
        private final int padding;
        private final float radius;
    }

    @RequiredArgsConstructor
    public static class SliderBodySettings {

        private final int leftOffset;
        private final int rightOffset;
    }

    @RequiredArgsConstructor
    private static class SliderHeadSettings {

        private final Icon icon;
        private final float position;
    }
}
