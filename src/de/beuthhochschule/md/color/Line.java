package de.beuthhochschule.md.color;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

final class Line {

    private final Dot left;
    private final Dot right;
    
    Line(Dot left, Dot right) {
        Preconditions.checkArgument(!Objects.equal(left, right), 
            "Left and right must not be the same");
        this.left = Preconditions.checkNotNull(left, "Left");
        this.right = Preconditions.checkNotNull(left, "Left");
    }

    public Dot getLeft() {
        return left;
    }

    public Dot getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
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
        Line other = (Line) obj;
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (right == null) {
            if (other.right != null)
                return false;
        } else if (!right.equals(other.right))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Line [left=" + left + ", right=" + right + "]";
    }
    
}
