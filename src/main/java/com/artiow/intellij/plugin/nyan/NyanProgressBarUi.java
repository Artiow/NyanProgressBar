package com.artiow.intellij.plugin.nyan;

import com.artiow.intellij.plugin.nyan.basic.SliderProgressBarUI;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

import static java.lang.Math.round;

public class NyanProgressBarUi extends SliderProgressBarUI {

    @SuppressWarnings("unused")
    public static ComponentUI createUI(JComponent c) {
        c.setBorder(JBUI.Borders.empty().asUIResource());
        return new NyanProgressBarUi();
    }


    @Override
    protected void paintIndeterminate(Graphics2D g, JComponent c) {
        paintSlider(g, new SliderBodySettings(0, 0), new SliderHeadSettings(null, 0));
    }

    @Override
    protected void paintDeterminate(Graphics2D g, JComponent c) {
        int width = progressBar.getWidth();
        int height = progressBar.getHeight();
        float position = (float) progressBar.getPercentComplete();
        Icon icon = NyanIcon.INSTANCE.scaleToHeight(height);
        SliderBodySettings sliderBodySettings = new SliderBodySettings(0, round((width - icon.getIconWidth()) * (1f - position) + (icon.getIconWidth() / 2f)));
        SliderHeadSettings sliderHeadSettings = new SliderHeadSettings(icon, position);
        paintSlider(g, sliderBodySettings, sliderHeadSettings);
    }


    protected void paintSlider(Graphics2D g, SliderBodySettings sliderBody, SliderHeadSettings sliderHead) {
        paintSlider(g, new SliderSettings(0, 0, progressBar.getWidth(), progressBar.getHeight(), 1, 1, 8f), sliderBody, sliderHead);
    }


    @Override
    protected Paint getSliderBodyPaint(Graphics2D g, int x, int y, int w, int h, float radius) {
        return NyanRainbow.newGradient(0, y, 0, y + h);
    }
}
