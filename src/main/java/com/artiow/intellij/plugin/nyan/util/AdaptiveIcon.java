package com.artiow.intellij.plugin.nyan.util;

import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.ScalableIcon;

import javax.swing.*;

/**
 * @author Artem Namednev
 */
public interface AdaptiveIcon extends ScalableIcon {

    static AdaptiveIcon getIcon(String path) {
        return new AdaptiveIconImpl((ScalableIcon) IconLoader.getIcon(path));
    }


    Icon scaleToWidth(int width);

    Icon scaleToHeight(int height);
}
