package de.beuthhochschule.md.common;

import com.google.common.collect.Ordering;

final class YOrdering extends Ordering<Point> {
    
    private static final Ordering<Point> INSTANCE = new YOrdering();
    
    private YOrdering() {
        
    }

    @Override
    public int compare(Point left, Point right) {
        return Float.compare(left.y(), right.y());
    }

    public static Ordering<Point> getInstance() {
        return INSTANCE;
    }
    
}
