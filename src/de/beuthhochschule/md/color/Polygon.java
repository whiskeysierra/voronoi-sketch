package de.beuthhochschule.md.color;

import java.util.Iterator;
import java.util.Set;

import com.google.common.base.Preconditions;

import processing.core.PApplet;

final class Polygon implements Drawable {
    
    private final Set<Dot> dots;
    
    Polygon(Set<Dot> dots) {
        this.dots = Preconditions.checkNotNull(dots, "Dots");
    }

    @Override
    public void draw(PApplet p) {
        final int size = dots.size();
        if (size == 0 || size == 1) {
            // nothing to do
            return;
        } else if (size == 2) {
            final Iterator<Dot> iterator = dots.iterator();
            final Dot first = iterator.next();
            final Dot second = iterator.next();
            
            p.line(first.getX(), first.getY(), second.getX(), second.getY());
        } else if (size == 3) {
            final Iterator<Dot> iterator = dots.iterator();
            final Dot first = iterator.next();
            final Dot second = iterator.next();
            final Dot third = iterator.next();

            p.line(first.getX(), first.getY(), second.getX(), second.getY());
            p.line(second.getX(), second.getY(), third.getX(), third.getY());
            p.line(third.getX(), third.getY(), first.getX(), first.getY());
        } else {
            // TODO
        }
    }

}
