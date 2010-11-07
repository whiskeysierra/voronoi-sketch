package de.beuthhochschule.md.polygon;

import java.util.List;

import processing.core.PApplet;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import de.beuthhochschule.md.common.Drawable;
import de.beuthhochschule.md.common.Point;
import de.beuthhochschule.md.common.Points;

final class Polygon extends ForwardingList<Dot> implements Drawable {
    
    private final List<Dot> dots = Lists.newArrayList();
    
    @Override
    protected List<Dot> delegate() {
        return dots;
    }
    
    @Override
    public void draw(PApplet p) {
        for (Dot dot : dots) {
            dot.update(p);
        }
        
        if (dots.size() > 1) {
            for (Dot dot : dots) {
                final Dot predecessor = findPredecessor(dot);
                final Dot successor = findSuccesor(dot);                

                p.vertex(dot.x(), dot.y());
                
                final int color = dot.color();
                
                p.fill(color);
                p.beginShape(PApplet.TRIANGLE_STRIP);
                
                // TODO triangle strip with lerp color
                // dot to "center": color to while
                // successor to predecessor: 
                p.vertex(successor.x(), successor.y());
                p.vertex(dot.x(), dot.y());
                p.vertex(predecessor.x(), predecessor.y());
                p.endShape();
            }
        }
        
        for (Dot dot : dots) {
            dot.draw(p);
        }
    }
    
    public Dot findPredecessor(Dot dot) {
        final int index = dots.indexOf(dot);
        return dots.get(index == 0 ? dots.size() - 1 : index - 1);
    }
    
    public Dot findSuccesor(Dot dot) {
        final int index = dots.indexOf(dot);
        return dots.get(index == dots.size() - 1 ? 0 : index + 1);
    }
    
    @Override
    public boolean add(Dot dot) {
        if (isEmpty() || size() == 1) {
            return super.add(dot);
        } else {
            final Ordering<Point> ordering = Points.order(dot);
            
            final Dot closest = ordering.min(dots);
            final Dot predecessor = findPredecessor(closest);
            final Dot successor = findSuccesor(closest);

            final int index;
            
            if (ordering.compare(predecessor, successor) < 0) {
                index = dots.indexOf(closest);
            } else {
                index = dots.indexOf(successor);
            }
            
            dots.add(index, dot);
            
            return true;
        }
    }
    
}
