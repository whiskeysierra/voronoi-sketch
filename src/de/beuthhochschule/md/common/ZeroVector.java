package de.beuthhochschule.md.common;

import processing.core.PApplet;

import com.google.common.base.Preconditions;

enum ZeroVector implements Vector {
    
    INSTANCE;
    
    private final float angle = PApplet.acos(0);

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
    public Vector add(Vector v) {
        return Preconditions.checkNotNull(v, "Vector");
    }

    @Override
    public Vector sub(Vector v) {
        return Preconditions.checkNotNull(v, "Vector").scale(-1);
    }

    @Override
    public Vector scale(float factor) {
        return this;
    }

    @Override
    public float magnitude() {
        return 0;
    }

    @Override
    public Vector normalize() {
        return this;
    }

    @Override
    public float dot(Vector v) {
        return 0;
    }

    @Override
    public Vector cross(Vector v) {
        Preconditions.checkNotNull(v, "Vector");
        return this;
    }

    @Override
    public float angle(Vector v) {
        Preconditions.checkNotNull(v, "Vector");
        return angle;
    }
    
    @Override
    public String toString() {
        return "Vectors.zeroVector()";
    }

}
