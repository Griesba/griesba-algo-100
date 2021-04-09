package com.leretvil.cache.manager;

import com.leretvil.cache.Cache;
import com.leretvil.cache.containers.AbstractCache;

public abstract class AbstractCacheManager<K,V> implements Cache<K,V> {

    private AbstractCache<K, V> cache;

    public AbstractCacheManager(AbstractCache<K, V> cache) {
        this.cache = cache;
    }

    //clear cache
    //get cache name, size
}
