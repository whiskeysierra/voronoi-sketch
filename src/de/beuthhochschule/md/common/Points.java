package de.beuthhochschule.md.common;

import java.util.Arrays;
import java.util.Collection;

import processing.core.PApplet;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Ordering;

public final class Points {
    
    private static final Ordering<Point> XORDER = XOrdering.getInstance();
    private static final Ordering<Point> YORDER = YOrdering.getInstance();

    private Points() {
        
    }
    
    static int hashCode(Point point) {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(point.x());
        result = prime * result + Float.floatToIntBits(point.y());
        result = prime * result + Float.floatToIntBits(point.z());
        return result;
    }
    
    static boolean equals(Point point, Object that) {
        if (point == that) {
            return true;
        } else if (point == null || that == null) {
            return false;
        } else if (that instanceof Point) {
            final Point other = Point.class.cast(that);
            return equals(point, other);
        } else {
            return false;
        }
    }
    
    private static boolean equals(Point l, Point r) {
        return 
            Float.floatToIntBits(l.x()) == Float.floatToIntBits(r.x()) &&
            Float.floatToIntBits(l.y()) == Float.floatToIntBits(r.y()) &&
            Float.floatToIntBits(l.z()) == Float.floatToIntBits(r.z());
    }
    
    public static Point of(float x, float y) {
        return of(x, y, 0);
    }
    
    public static Point of(float x, float y, float z) {
        return new DefaultPoint(x, y, z);
    }
    
    public static Point origin() {
        return Origin.getInstance();
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
    
    public static Ordering<Point> orderByX() {
        return XORDER;
    }
    
    public static Ordering<Point> orderByY() {
        return YORDER;
    }
    
    public static float[][] collect(Point... points) {
        Preconditions.checkNotNull(points, "Points");
        return collect(Arrays.asList(points));
    }
    
    public static float[][] collect(Collection<? extends Point> points) {
        Preconditions.checkNotNull(points, "Points");
        final float[][] coordinates = new float[points.size()][];
        
        int index = 0;
        for (Point point : points) {
            coordinates[index++] = point.coordinates();
        }
        
        return coordinates;
    }
    
}
