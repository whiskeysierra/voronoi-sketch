package de.beuthhochschule.md.common;

import processing.core.PApplet;

import com.google.common.base.Preconditions;

final class ZeroVector implements Vector {

    private static final Vector INSTANCE = new ZeroVector();
    
    private ZeroVector() {
        
    }
    
    private final float rightAngle = PApplet.acos(0);
    private final int hash = Vectors.hashCode(this);

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
    public Vector invert() {
        return this;
    }

    @Override
    public float magnitude() {
        return 0;
    }

    @Override
    public Vector normalize() {
        // TODO exception?
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
        return rightAngle;
    }
    
    @Override
    public boolean equals(Object that) {
        return Vectors.equals(this, that);
    }
    
    @Override
    public int hashCode() {
        return hash;
    }
    
    @Override
    public String toString() {
        return "(0.0, 0.0, 0.0)";
    }
    
    public static Vector getInstance() {
        return INSTANCE;
    }

}
