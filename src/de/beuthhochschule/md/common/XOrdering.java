package de.beuthhochschule.md.common;

import com.google.common.collect.Ordering;

final class XOrdering extends Ordering<Point> {

    @Override
    public int compare(Point left, Point right) {
        return Float.compare(left.x(), right.x());
    }
    
}
