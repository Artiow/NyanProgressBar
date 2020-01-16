package com.artiow.intellij.plugin.nyan.util;

import com.intellij.openapi.util.ScalableIcon;

import javax.swing.*;

/**
 * @author Artem Namednev
 */
public interface AdaptiveIcon extends ScalableIcon {

    static AdaptiveIcon from(ScalableIcon icon) {
        return new AdaptiveIconImpl(icon);
    }


    Icon scaleToWidth(int width);

    Icon scaleToHeight(int height);
}
