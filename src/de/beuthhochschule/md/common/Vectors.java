package de.beuthhochschule.md.common;


public final class Vectors {
    
    private Vectors() {
        
    }
    
    static int hashCode(Vector vector) {
        if (vector == null) {
            return 0;
        } else {
            final int prime = 31;
            int result = 1;
            long temp;
            temp = Float.floatToIntBits(vector.x());
            result = prime * result + (int) (temp ^ (temp >>> 32));
            temp = Float.floatToIntBits(vector.y());
            result = prime * result + (int) (temp ^ (temp >>> 32));
            temp = Float.floatToIntBits(vector.z());
            result = prime * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
    
    static boolean equals(Vector vector, Object that) {
        if (vector == that) {
            return true;
        } else if (vector == null || that == null) {
            return false;
        } else if (that instanceof Vector) {
            final Vector other = Vector.class.cast(that);
            return equals(vector, other);
        } else {
            return false;
        }
    }
    
    private static boolean equals(Vector l, Vector r) {
        return 
            Float.floatToIntBits(l.x()) == Float.floatToIntBits(r.x()) &&
            Float.floatToIntBits(l.y()) == Float.floatToIntBits(r.y()) &&
            Float.floatToIntBits(l.z()) == Float.floatToIntBits(r.z());
    }
    
    public static Vector of(float x, float y) {
        return of(x, y, 0);
    }
    
    public static Vector of(float x, float y, float z) {
        return new DefaultVector(x, y, z);
    }

    public static Vector zeroVector() {
        return ZeroVector.getInstance();
    }
    
}
