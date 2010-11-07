package de.beuthhochschule.md.common;

import java.util.Set;

public interface Polygon extends Set<Point> {

    float area();
    
    Point centroid();
    
}
