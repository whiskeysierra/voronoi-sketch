package de.beuthhochschule.md.common;

import java.util.Iterator;

public abstract class AbstractPolygon implements Polygon {

    @Override
    public float area() {
        if (isEmpty()) {
            return 0;
        } else {
            // http://en.wikipedia.org/wiki/Polygon#Area_and_centroid
            
            float area = 0;
            
            final Iterator<Point> iterator = iterator();
            Point last = iterator.next();
            while (iterator.hasNext()) {
                final Point next = iterator.next();
                area += last.x() * next.y() - next.x() * last.x();
                last = next;
            }
            
            return area / 2;
        }
    }
    
    @Override
    public Point centroid() {
        if (isEmpty()) {
            return Points.origin();
        } else {
            // TODO Auto-generated method stub
            return null;
        }
    }
    
}
