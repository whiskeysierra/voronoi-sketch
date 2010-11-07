package de.beuthhochschule.md.common;

import com.google.common.collect.Ordering;

final class YOrdering extends Ordering<Point> {

    @Override
    public int compare(Point left, Point right) {
        return Float.compare(left.y(), right.y());
    }
    
}
