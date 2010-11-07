package de.beuthhochschule.md.common;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Doubles;

final class YOrdering extends Ordering<Point> {

    @Override
    public int compare(Point left, Point right) {
        return Doubles.compare(left.y(), right.y());
    }
    
}
