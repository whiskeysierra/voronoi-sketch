package de.beuthhochschule.md.color;

import processing.core.PApplet;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Floats;

final class MouseDistanceOrdering extends Ordering<Dot> {

    private final PApplet applet;

    MouseDistanceOrdering(PApplet applet) {
        this.applet = Preconditions.checkNotNull(applet, "Applet");
    }
    
    @Override
    public int compare(Dot left, Dot right) {
        return Floats.compare(
            left.distanceToMouse(applet), 
            right.distanceToMouse(applet)
        );
    }
    
}
