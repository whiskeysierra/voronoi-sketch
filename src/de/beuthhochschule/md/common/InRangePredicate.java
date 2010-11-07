package de.beuthhochschule.md.common;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

final class InRangePredicate implements Predicate<Point> {

    private final Point from;
    private final float distance;

    InRangePredicate(Point from, float distance) {
        this.from = Preconditions.checkNotNull(from, "Point");
        this.distance = distance;
    }
    
    @Override
    public boolean apply(Point to) {
        return Float.compare(from.distance(to), distance) <= 0;
    }
    
}
