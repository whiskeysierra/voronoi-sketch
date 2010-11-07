package de.beuthhochschule.md.polygon;

import processing.core.PApplet;

import com.google.common.base.Predicate;

import de.beuthhochschule.md.common.Point;
import de.beuthhochschule.md.common.Points;

final class InRangePredicate implements Predicate<Dot> {

    private final Point mouse;

    InRangePredicate(PApplet applet) {
        this.mouse = Points.mouseOf(applet);;
    }
    
    @Override
    public boolean apply(Dot dot) {
        return dot.distance(mouse) <= Dot.INTERACTIVITY_DISTANCE;
    }
    
}
