package de.beuthhochschule.md.common;

import processing.core.PApplet;

import com.google.common.base.Preconditions;

enum Origin implements Point {

    INSTANCE;

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
        Preconditions.checkNotNull(point, "Point");
        return point.toVector();
    }

    @Override
    public float[] coordinates() {
        // can't cache mutable array
        return new float[] {0, 0};
    }
    
    
    
}
