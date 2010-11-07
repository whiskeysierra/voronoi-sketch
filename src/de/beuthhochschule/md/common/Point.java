package de.beuthhochschule.md.common;

public interface Point {

    float x();
    
    float y();
    
    float z();
    
    Point move(Vector vector);
    
    float distance(Point point);
    
    Vector to(Point point);
    
    float[] coordinates();
    
}
