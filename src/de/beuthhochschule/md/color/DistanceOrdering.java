package de.beuthhochschule.md.color;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Floats;

import static processing.core.PApplet.dist;

final class DistanceOrdering extends Ordering<Dot> {

    private final Dot dot;

    DistanceOrdering(Dot dot) {
        this.dot = dot;
    }
    
    @Override
    public int compare(Dot left, Dot right) {
        return Floats.compare(
            dist(dot.getX(), dot.getY(), left.getX(), left.getY()),
            dist(dot.getX(), dot.getY(), right.getX(), right.getY())
        );
    }
    
}
