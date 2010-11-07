package de.beuthhochschule.md.common;

import processing.core.PApplet;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Floats;

public abstract class AbstractVector implements Vector {
    
    @Override
    public Vector add(Vector v) {
        Preconditions.checkNotNull(v, "Vector");
        return Vectors.of(x() + v.x(), y() + v.y(), z() + v.z());
    }
    
    @Override
    public Vector sub(Vector v) {
        Preconditions.checkNotNull(v, "Vector");
        return Vectors.of(x() - v.x(), y() - v.y(), z() - v.z());
    }
    
    @Override
    public Vector scale(float f) {
        if (Floats.compare(0.0f, f) == 0) {
            return Vectors.zeroVector();
        } else {
            return Vectors.of(x() * f, y() * f, z() * f);
        }
    }
    
    @Override
    public Vector invert() {
        return scale(-1f);
    }
    
    @Override
    public float magnitude() {
        // http://en.wikipedia.org/wiki/Dot_product#Geometric_interpretation
        return PApplet.sqrt(dot(this));
    }
    
    @Override
    public Vector normalize() {
        // http://en.wikipedia.org/wiki/Euclidean_vector#Length
        return scale(1 / magnitude());
    }
    
    @Override
    public float dot(Vector v) {
        Preconditions.checkNotNull(v, "Vector");
        return x() * v.x() + y() * v.y() + z() * v.z();
    }
    
    @Override
    public Vector cross(Vector v) {
        Preconditions.checkNotNull(v, "Vector");
        return Vectors.of(
            y() * v.z() - z() * v.y(),
            z() * v.x() - x() * v.z(),
            x() * v.y() - y() * v.x()
        );
    }
    
    @Override
    public float angle(Vector v) {
        Preconditions.checkNotNull(v, "Vector");
        // http://en.wikipedia.org/wiki/Dot_product#Geometric_interpretation
        return PApplet.acos(normalize().dot(v.normalize()));
    }

    @Override
    public int hashCode() {
        return Vectors.hashCode(this);
    }

    @Override
    public boolean equals(Object that) {
        return Vectors.equals(this, that);
    }

    @Override
    public String toString() {
        return "(" + x() + ", " + y() + ", " + z() + ")";
    }
    
}
