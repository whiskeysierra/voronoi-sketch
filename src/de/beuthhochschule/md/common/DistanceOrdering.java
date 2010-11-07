package de.beuthhochschule.md.common;

import static processing.core.PApplet.dist;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Floats;

final class DistanceOrdering extends Ordering<Point> {

    private final Point point;

    DistanceOrdering(Point point) {
        this.point = Preconditions.checkNotNull(point, "Point");
    }
    
    @Override
    public int compare(Point left, Point right) {
        return Floats.compare(
            dist(point.x(), point.y(), left.x(), left.y()),
            dist(point.x(), point.y(), right.x(), right.y())
        );
    }
    
}
