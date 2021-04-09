package com.leretvil.cache.containers;

import com.leretvil.cache.CacheSize;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractCache<K,V> {
    private final String name;
    private final ConcurrentHashMap<K, V> cacheData;

    public AbstractCache(String name, CacheSize cacheSize) {
        if (cacheSize == null){
            throw new RuntimeException("cache size is mandatory");
        }
        this.name = name;
        this.cacheData = new ConcurrentHashMap<K, V>(cacheSize.getSize());
    }

    public boolean clear() {
        this.cacheData.clear();
        return true;
    }

    public boolean contains(K key) {
        return key != null && this.cacheData.containsKey(key);
    }

    // isEmpty

    public Collection<V> getValues() {
        return this.cacheData.values();
    }

    public boolean put(final K key, final  V value) {
        boolean res = key != null && value != null;
        if (res) {
            this.cacheData.put(key, value);
        }
        return res;
    }

    // public boolean putAll()
    // remove
    // replace
}
