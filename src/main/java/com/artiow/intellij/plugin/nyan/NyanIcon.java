package com.artiow.intellij.plugin.nyan;

import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.ScalableIcon;

public final class NyanIcon {

    public static final ScalableIcon CAT = load("/cat.png");
    public static final ScalableIcon RCAT = load("/rcat.png");

    private static ScalableIcon load(String path) {
        return (ScalableIcon) IconLoader.getIcon(path);
    }

    private NyanIcon() { }
}
