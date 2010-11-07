package de.beuthhochschule.md.polygon;

import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Iterables.all;
import static com.google.common.collect.Iterables.any;

import java.awt.event.MouseEvent;

import processing.core.PApplet;

import com.google.common.base.Predicate;
import com.google.common.collect.Ordering;

import de.beuthhochschule.md.common.Point;
import de.beuthhochschule.md.common.Points;

public final class PolygonApplet extends PApplet {

    private static final long serialVersionUID = 6519493573972998181L;
    
    private final Polygon polygon = new Polygon();
    
    private final Point mouse = Points.mouseOf(this);
    private final Ordering<Point> ordering = Points.order(mouse);
    private final Predicate<Dot> inRange = new InRangePredicate(this);
    private final Predicate<Dot> notInRange = not(inRange);
    
    private Dot dragee;
    
    @Override
    public void setup() {
        size(640, 480);
        frameRate(60);
        smooth();
//        noStroke();
    }
    
    @Override
    public void draw() {
        background(255);

        polygon.draw(this);
        
        if (dragee == null && any(polygon, inRange)) {
            cursor(HAND);
        }
    }
    
    @Override
    public void mouseClicked() {
        if (polygon.isEmpty() || all(polygon, notInRange)) {
            polygon.add(new Dot(polygon, mouseX, mouseY));
            System.out.printf("Created dot at (%d, %d)\n", mouseX, mouseY);
        }
    }

    @Override
    public void mousePressed() {
        if (polygon.isEmpty()) {
            return;
        } else {
            final Dot closest = ordering.min(polygon);
            if (inRange.apply(closest)) {
                System.out.println("Start dragging");
                this.dragee = closest;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragee != null) {
            cursor(MOVE);
            dragee.setX(e.getX());
            dragee.setY(e.getY());
        }
        super.mouseDragged(e);
    }
    
    @Override
    public void mouseReleased() {
        cursor(ARROW);
        if (dragee != null) {
            System.out.printf("Stopped dragging %s\n", dragee);
            dragee = null;
        }
    }
    
    @Override
    public void keyPressed() {
        switch (key) {
            case DELETE: {
                if (polygon.isEmpty()) {
                    break;
                } else {
                    final Dot closest = ordering.min(polygon);
                    System.out.printf("Removing %s\n", closest);
                    polygon.remove(closest);
                    break;
                }
            }
        }
    }
    
}
