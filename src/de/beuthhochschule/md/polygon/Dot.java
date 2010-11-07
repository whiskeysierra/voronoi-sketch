package de.beuthhochschule.md.polygon;

import static java.lang.Math.toDegrees;
import static processing.core.PApplet.dist;
import static processing.core.PApplet.radians;
import static processing.core.PApplet.sin;
import processing.core.PApplet;

import com.google.common.base.Preconditions;

import de.beuthhochschule.md.common.AbstractPoint;
import de.beuthhochschule.md.common.Drawable;
import de.beuthhochschule.md.common.Updateable;
import de.beuthhochschule.md.common.Vector;

final class Dot extends AbstractPoint implements Drawable, Updateable {
    
    static final float INTERACTIVITY_DISTANCE = 25;
    
    private static final float DEFAULT_RADIUS = 5;
    private static final float MAX_RADIUS = 10;
    
    private final Polygon polygon;

    private float x;
    private float y;
    
    private int color;
    
    private float radius = DEFAULT_RADIUS;
    private float angle = 0;
    
    Dot(Polygon polygon, int x, int y) {
        this.polygon = Preconditions.checkNotNull(polygon, "Polygon");
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(PApplet p) {
        final Vector predecessor = to(polygon.findPredecessor(this));
        final Vector successor = to(polygon.findSuccesor(this));
        
        final double angle = toDegrees(successor.angle(predecessor));
        
        if (angle < 30) {
            // yellow
            this.color = p.color(255, 255, 0);
        } else if (angle < 60) {
            // orange
            this.color = p.color(255, 165, 0);
        } else if (angle < 90) {
            // red
            this.color = p.color(255, 0, 0);
        } else if (angle < 120) {
            // purple
            this.color = p.color(255, 0, 255);            
        } else if (angle < 150) {
            // blue
            this.color = p.color(0, 0, 255);
        } else {
            // black
            this.color = p.color(0, 0, 0);
        }
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

    @Override
    public float x() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float y() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    @Override
    public float z() {
        return 0;
    }
    
    public int color() {
        return color;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(x);
        result = prime * result + Float.floatToIntBits(y);
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
        if (!(obj instanceof Dot)) {
            return false;
        }
        Dot other = (Dot) obj;
        if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dot [x=" + x + ", y=" + y + "]";
    }
    
}
