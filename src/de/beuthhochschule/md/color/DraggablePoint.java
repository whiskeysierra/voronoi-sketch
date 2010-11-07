package de.beuthhochschule.md.color;

import static processing.core.PApplet.radians;
import static processing.core.PApplet.sin;
import processing.core.PApplet;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

import de.beuthhochschule.md.common.AbstractPoint;
import de.beuthhochschule.md.common.Drawable;
import de.beuthhochschule.md.common.Point;

final class DraggablePoint extends AbstractPoint implements Drawable {
    
    static final float DEFAULT_RADIUS = 5;
    static final float MAX_RADIUS = 10;
    static final float DRAGGABLE_DISTANCE = 25;
    
    private final Predicate<Point> inRange;
    
    private float x;
    private float y;
    
    private float radius = DEFAULT_RADIUS;
    private float angle = 0;
    
    DraggablePoint(float x, float y, Predicate<Point> inRange) {
        this.x = x;
        this.y = y;
        this.inRange = Preconditions.checkNotNull(inRange, "InRange");
    }

    @Override
    public void draw(PApplet p) {
        p.fill(255);
        p.ellipse(x(), y(), radius, radius);
        if (inRange.apply(this)) {
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
    
    public void x(float x) {
        this.x = x;
    }

    @Override
    public float y() {
        return y;
    }
    
    public void y(float y) {
        this.y = y;
    }

    @Override
    public float z() {
        return 0;
    }
    
    @Override
    public boolean equals(Object that) {
        return this == that;
    }
    
    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

}
