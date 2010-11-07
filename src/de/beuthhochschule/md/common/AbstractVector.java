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
    public float magnitude() {
        return PApplet.sqrt(dot(this));
    }
    
    @Override
    public Vector normalize() {
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
        return PApplet.acos(normalize().dot(v.normalize()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractVector)) {
            return false;
        }
        AbstractVector o = (AbstractVector) obj;
        if (Double.doubleToLongBits(x()) != Double.doubleToLongBits(o.x())) {
            return false;
        }
        if (Double.doubleToLongBits(y()) != Double.doubleToLongBits(o.y())) {
            return false;
        }
        if (Double.doubleToLongBits(z()) != Double.doubleToLongBits(o.z())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + x() + ", " + y() + ", " + z() + ")";
    }
    
}
