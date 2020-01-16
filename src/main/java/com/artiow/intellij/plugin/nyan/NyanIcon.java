package com.artiow.intellij.plugin.nyan;

import com.artiow.intellij.plugin.nyan.util.AdaptiveIcon;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.ScalableIcon;

public final class NyanIcon {

    public static final AdaptiveIcon CAT = load("/cat.png");
    public static final AdaptiveIcon RCAT = load("/rcat.png");

    private static AdaptiveIcon load(String path) {
        return AdaptiveIcon.from((ScalableIcon) IconLoader.getIcon(path));
    }

    private NyanIcon() { }
}
