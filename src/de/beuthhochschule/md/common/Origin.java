package de.beuthhochschule.md.common;

import processing.core.PApplet;

import com.google.common.base.Preconditions;

final class Origin implements Point {

    private static final Point INSTANCE = new Origin();
    
    private final int hash = Points.hashCode(this);
    
    @Override
    public float x() {
        return 0;
    }

    @Override
    public float y() {
        return 0;
    }

    @Override
    public float z() {
        return 0;
    }

    @Override
    public Point move(Vector vector) {
        Preconditions.checkNotNull(vector, "Vector");
        return Points.of(vector.x(), vector.y(), vector.z());
    }
    
    @Override
    public Vector toVector() {
        return Vectors.zeroVector();
    }

    @Override
    public float distance(Point point) {
        Preconditions.checkNotNull(point, "Point");
        return PApplet.dist(0, 0, 0, point.x(), point.y(), point.z());
    }

    @Override
    public Vector to(Point point) {
        return Preconditions.checkNotNull(point, "Point").toVector();
    }

    @Override
    public float[] coordinates() {
        // can't cache mutable array
        return new float[] {0, 0};
    }
    
    @Override
    public boolean equals(Object that) {
        return Points.equals(this, that);
    }
    
    @Override
    public int hashCode() {
        return hash;
    }
    
    @Override
    public String toString() {
        return "(x=0.0, y=0.0, z=0.0)";
    }
    
    public static Point getInstance() {
        return INSTANCE;
    }
    
}
