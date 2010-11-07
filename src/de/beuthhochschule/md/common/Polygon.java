package de.beuthhochschule.md.common;

import java.util.Set;

public interface Polygon extends Set<Point> {
    
    Polygon clockwise();
    
    Polygon counterclockwise();

    float area();
    
    Point centroid();
    
    @Override
    boolean equals(Object that);
    
    @Override
    int hashCode();
    
}
