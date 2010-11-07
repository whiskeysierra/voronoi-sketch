package de.beuthhochschule.md.common;

import java.util.Arrays;
import java.util.Collection;

import processing.core.PApplet;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Ordering;

public final class Points {

    public static Point of(float x, float y) {
        return of(x, y, 0);
    }
    
    public static Point of(float x, float y, float z) {
        return new DefaultPoint(x, y, z);
    }
    
    public static Point mouseOf(PApplet applet) {
        return new MousePoint(applet);
    }
    
    public static Predicate<Point> inRangeOf(Point from, float distance) {
        return new InRangePredicate(from, distance);
    }
    
    public static Ordering<Point> order(Point point) {
        return new DistanceOrdering(point);
    }
    
    public static float[][] collect(Point... points) {
        Preconditions.checkNotNull(points, "Points");
        return collect(Arrays.asList(points));
    }
    
    public static float[][] collect(Collection<? extends Point> points) {
        Preconditions.checkNotNull(points, "Points");
        final float[][] coordinates = new float[points.size()][3];
        
        int index = 0;
        for (Point point : points) {
            coordinates[index][0] = point.x();
            coordinates[index][1] = point.y();
            coordinates[index][2] = point.z();
            index++;
        }
        
        return coordinates;
    }
    
}
