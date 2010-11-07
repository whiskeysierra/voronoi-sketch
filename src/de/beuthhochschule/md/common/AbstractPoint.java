package de.beuthhochschule.md.common;

import processing.core.PApplet;

import com.google.common.base.Preconditions;

public abstract class AbstractPoint implements Point {

    @Override
    public Point move(Vector vector) {
        Preconditions.checkNotNull(vector, "Vector");
        return Points.of(x() + vector.x(), y() + vector.y(), z() + vector.z());
    }
    
    @Override
    public Vector toVector() {
        return Vectors.of(x(), y(), z());
    }
    
    @Override
    public float distance(Point point) {
        Preconditions.checkNotNull(point, "Point");
        return PApplet.dist(x(), y(), z(), point.x(), point.y(), point.z());
    }
    
    @Override
    public Vector to(Point point) {
        Preconditions.checkNotNull(point, "Point");
        return Vectors.of(point.x() - x(), point.y() - y(), point.z() - z());
    }
    
    @Override
    public float[] coordinates() {
        return new float[] {x(), y(), z()};
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(x());
        result = prime * result + Float.floatToIntBits(y());
        result = prime * result + Float.floatToIntBits(z());
        return result;
    }
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (!(that instanceof Point)) {
            return false;
        }
        final Point other = (Point) that;
        if (Float.floatToIntBits(x()) != Float.floatToIntBits(other.x())) {
            return false;
        }
        if (Float.floatToIntBits(y()) != Float.floatToIntBits(other.y())) {
            return false;
        }
        if (Float.floatToIntBits(z()) != Float.floatToIntBits(other.z())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(x=" + x() + ", y=" + y() + ", z=" + z() + ")";
    }
    
}
