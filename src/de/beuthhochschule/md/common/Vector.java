package de.beuthhochschule.md.common;

public interface Vector {

    float x();
    
    float y();
    
    float z();
    
    Vector add(Vector v);
    
    Vector sub(Vector v);
    
    Vector scale(float factor);
    
    Vector invert();
    
    float magnitude();
    
    Vector normalize();
    
    float dot(Vector v);
    
    Vector cross(Vector v);
    
    float angle(Vector v);
    
}
