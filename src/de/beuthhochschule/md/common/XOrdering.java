package de.beuthhochschule.md.common;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Doubles;

final class XOrdering extends Ordering<Point> {

    @Override
    public int compare(Point left, Point right) {
        return Doubles.compare(left.x(), right.x());
    }
    
}
