package de.beuthhochschule.md.common;

import com.google.common.base.Preconditions;

import processing.core.PApplet;

final class MousePoint extends AbstractPoint {

    private final PApplet applet;
    
    MousePoint(PApplet applet) {
        this.applet = Preconditions.checkNotNull(applet, "Applet");
    }

    @Override
    public float x() {
        return applet.mouseX;
    }

    @Override
    public float y() {
        return applet.mouseY;
    }

    @Override
    public float z() {
        return 0;
    }
    
}
