package de.beuthhochschule.md.color;

import java.util.List;

import processing.core.PApplet;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.Lists;

final class Polygon extends ForwardingList<Dot> implements Drawable {
    
    private final List<Dot> dots = Lists.newArrayList();
    
    @Override
    protected List<Dot> delegate() {
        return dots;
    }
    
    @Override
    public void draw(PApplet p) {
        final int size = dots.size();
        if (size == 0 || size == 1) {
            // nothing to do
            return;
        } else {
            p.fill(255, 255, 0);
            p.beginShape();
            for (int i = 0; i < dots.size() - 1; i++) {
                final Dot dot = dots.get(i);
                final Dot next = dots.get(i + 1);
                p.vertex(dot.getX(), dot.getY());
                p.line(dot.getX(), dot.getY(), next.getX(), next.getY());
            }
            
            final Dot first = dots.get(0);
            final Dot last = dots.get(dots.size() - 1);
            p.line(first.getX(), first.getY(), last.getX(), last.getY());
            p.vertex(last.getX(), last.getY());
            p.endShape(PApplet.CLOSE);
        }
        
        for (Dot dot : dots) {
            dot.draw(p);
        }
    }
    
    private Dot findPredecessor(Dot dot) {
        final int index = dots.indexOf(dot);
        return dots.get(index == 0 ? dots.size() - 1 : index - 1);
    }
    
    private Dot findSuccesor(Dot dot) {
        final int index = dots.indexOf(dot);
        return dots.get(index == dots.size() - 1 ? 0 : index + 1);
    }
    
    @Override
    public boolean add(Dot dot) {
        if (isEmpty() || size() == 1) {
            return super.add(dot);
        } else {
            final DistanceOrdering ordering = new DistanceOrdering(dot);
            
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
