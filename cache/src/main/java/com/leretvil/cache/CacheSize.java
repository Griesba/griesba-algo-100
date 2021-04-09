package com.leretvil.cache;

public enum  CacheSize {
    TINY(1), SMALL(101), AVERAGE(10009);

    private int size;

    CacheSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
