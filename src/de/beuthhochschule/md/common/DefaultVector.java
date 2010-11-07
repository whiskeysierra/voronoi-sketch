package de.beuthhochschule.md.common;

final class DefaultVector extends AbstractVector {
    
    private final float x;
    private final float y;
    private final float z;

    DefaultVector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public float x() {
        return x;
    }

    @Override
    public float y() {
        return y;
    }

    @Override
    public float z() {
        return z;
    }

}
