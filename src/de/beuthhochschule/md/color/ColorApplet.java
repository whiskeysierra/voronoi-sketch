package de.beuthhochschule.md.color;

import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Iterables.all;
import static com.google.common.collect.Iterables.any;

import java.awt.event.MouseEvent;
import java.util.Set;

import megamu.mesh.MPolygon;
import megamu.mesh.Voronoi;
import processing.core.PApplet;

import com.google.common.base.Predicate;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

import de.beuthhochschule.md.common.Point;
import de.beuthhochschule.md.common.Points;

public final class ColorApplet extends PApplet {

    private static final long serialVersionUID = 8801481205723603148L;
    
    private final int yellow = color(255, 215, 0);
    private final int orange = color(255, 69, 0);
    private final int red = color(178, 34, 34);
    private final int purple = color(138, 43, 226);
    private final int blue = color(30, 144, 255);
    
    private final Set<DraggablePoint> points = 
        Sets.newHashSetWithExpectedSize(100);
    
    private final Point mouse = Points.mouseOf(this);
    
    private final Ordering<Point> ordering = Points.order(mouse);
    
    private final Predicate<Point> inRange = Points.inRangeOf(
        mouse, DraggablePoint.DRAGGABLE_DISTANCE);
    
    private final Predicate<Point> notInRange = not(inRange);
    
    private DraggablePoint dragee;
    
    @Override
    public void setup() {
        size(640, 480);
        frameRate(60);
        smooth();
    }
    
    @Override
    public void draw() {
        background(255);
        
        final float[][] coordinates = Points.collect(points);
        final Voronoi voronoi = new Voronoi(coordinates);
        
        for (MPolygon polygon : voronoi.getRegions()) {
            fill(colorOf(polygon));
            polygon.draw(this);
        }
        
        for (DraggablePoint point : points) {
            point.draw(this);
        }
        
        if (dragee == null && any(points, inRange)) {
            cursor(HAND);
        }
    }
    
    private int colorOf(MPolygon polygon) {
        final float lerpFactor = lerpFactor(polygon);
        switch (polygon.count()) {
            case 3: {
                return lerpColor(yellow, orange, lerpFactor);
            }
            case 4: {
                return lerpColor(orange, red, lerpFactor);
            }
            case 5: {
                return lerpColor(red, purple, lerpFactor);
            }
            default: {
                return lerpColor(purple, blue, lerpFactor);
            }
        }
    }
    
    private float lerpFactor(MPolygon polygon) {
        final float minY = minY(polygon);
        return map(minY, 0, height, 0, 1);
    }
    
    private float minY(MPolygon polygon) {
        float minY = Float.MAX_VALUE;
        
        for (float[] c : polygon.getCoords()) {
            minY = min(minY, c[1]);
        }
        
        return minY;
    }

    private void addPoint(float x, float y) {
        final DraggablePoint point = new DraggablePoint(x, y, inRange);
        points.add(point);
        System.out.printf("Created point %s\n", point);
    }
    
    @Override
    public void mouseClicked() {
        if (points.isEmpty() || all(points, notInRange)) {
            addPoint(mouseX, mouseY);
        }
    }
    
    @Override
    public void mousePressed() {
        if (points.isEmpty()) {
            return;
        } else {
            final DraggablePoint closest = ordering.min(points);
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
            dragee.x(e.getX());
            dragee.y(e.getY());
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
            case 'n': {
                addPoint(random(width), random(height));
                break;
            }
            case DELETE: {
                if (points.isEmpty()) {
                    break;
                } else {
                    final Point closest = ordering.min(points);
                    System.out.printf("Removing %s\n", closest);
                    points.remove(closest);
                    break;
                }
            }
        }
    }
    
}
