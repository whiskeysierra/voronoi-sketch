package de.beuthhochschule.md.color;

import static processing.core.PApplet.dist;
import static processing.core.PApplet.radians;
import static processing.core.PApplet.sin;
import processing.core.PApplet;

final class Dot implements Drawable {
    
    static final float INTERACTIVITY_DISTANCE = 25;
    
    private static final float DEFAULT_RADIUS = 5;
    private static final float MAX_RADIUS = 10;

    private int x;
    private int y;
    
    private float radius = DEFAULT_RADIUS;
    private float angle = 0;
    
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(PApplet p) {
        p.fill(0);
        p.ellipse(x, y, radius, radius);
        if (dist(p.mouseX, p.mouseY, x, y) <= INTERACTIVITY_DISTANCE) {
            radius = sin(radians(angle)) * MAX_RADIUS;
            angle += 5;
        } else {
            radius = DEFAULT_RADIUS;
            angle = 0;
        }
    }
    
    public float distanceToMouse(PApplet p) {
        return dist(p.mouseX, p.mouseY, x, y);
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dot other = (Dot) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dot [x=" + x + ", y=" + y + "]";
    }
    
}
