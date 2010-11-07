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
            
            final Iterator<Point> iterator = counterclockwise().iterator();
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
            // http://en.wikipedia.org/wiki/Polygon#Area_and_centroid
            
            float area = 0;
            float x = 0;
            float y = 0;

            final Iterator<Point> iterator = counterclockwise().iterator();
            Point last = iterator.next();
            while (iterator.hasNext()) {
                final Point next = iterator.next();
                final float step = last.x() * next.y() - next.x() * last.x();
                
                area += step;
                x += (last.x() + next.x()) * step;
                y += (last.y() + next.y()) * step;
                
                last = next;
            }
            
            area = area / 2;
            
            final float factor = 1f / (6f * area);
            x *= factor;
            y *= factor;
            
            return Points.of(x, y);
        }
    }
    
}
