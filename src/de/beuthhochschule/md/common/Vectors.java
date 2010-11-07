package de.beuthhochschule.md.common;

public final class Vectors {
    
    private Vectors() {
        
    }
    
    public static Vector of(float x, float y) {
        return of(x, y, 0);
    }
    
    public static Vector of(float x, float y, float z) {
        return new DefaultVector(x, y, z);
    }

    public static Vector zeroVector() {
        return ZeroVector.INSTANCE;
    }
    
}
