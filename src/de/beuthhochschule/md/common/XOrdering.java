package de.beuthhochschule.md.common;

import com.google.common.collect.Ordering;

final class XOrdering extends Ordering<Point> {

    private static final Ordering<Point> INSTANCE = new XOrdering();
    
    private XOrdering() {
        
    }
    
    @Override
    public int compare(Point left, Point right) {
        return Float.compare(left.x(), right.x());
    }
    
    public static Ordering<Point> getInstance() {
        return INSTANCE;
    }
    
}
