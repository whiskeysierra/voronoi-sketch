package de.beuthhochschule.md.common;

public interface Point {

    float x();
    
    float y();
    
    float z();
    
    Point move(Vector vector);
    
    Vector toVector();
    
    float distance(Point point);
    
    Vector to(Point point);
    
    float[] coordinates();
    
    @Override
    boolean equals(Object that);
    
    @Override
    int hashCode();
    
}
