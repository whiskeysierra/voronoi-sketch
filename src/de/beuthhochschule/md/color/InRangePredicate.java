package de.beuthhochschule.md.color;

import processing.core.PApplet;

import com.google.common.base.Predicate;

final class InRangePredicate implements Predicate<Dot> {

    private final PApplet applet;

    InRangePredicate(PApplet applet) {
        this.applet = applet;
    }
    
    @Override
    public boolean apply(Dot dot) {
        return dot.distanceToMouse(applet) <= Dot.INTERACTIVITY_DISTANCE;
    }
    
}
