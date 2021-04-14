package com.leretvil.cache.manager;

import com.leretvil.cache.Cache;
import com.leretvil.cache.containers.AbstractCache;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractCacheManager<K,V> implements Cache<K,V> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCacheManager.class);

    private AbstractCache<K, V> cache;

    //clear cache
    //get cache name, size
    protected AbstractCacheManager(AbstractCache<K,V> cache) {
        if (cache == null) {
            AbstractCacheManager.LOGGER.error("Concrete cache cannot be null");
            throw new IllegalArgumentException("Concrete cache cannot be null");
        }
        this.cache = cache;
    }

    protected boolean clearCache() {
        return this.cache.clear();
    }

    public Map<K, V> getAllCacheAsMap() {
         return this.cache.toMap();
    }

    public final String getCacheName() {
        return this.cache.getName();
    }

    protected int getCacheSize() {
        return this.cache.size();
    }

    public V getFromCache(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Impossible to research a null key");
        }

        V result;

        if (this.cache.contains(key)) {
            return this.cache.get(key);
        } else {
            Set<K> set = new HashSet<>();
            set.add(key);
            Map<K, V> map = getMapFromCache(set);
            result = map.get(key);
        }
        return result;
    }

    private Map<K, V> getMapFromCache(Set<K> keys) {
        if (keys == null) {
            throw new IllegalArgumentException("Impossible to research a null key array");
        }

        HashMap<K, V> result = new HashMap<>(keys.size());
        Set<K> missingKeys = new HashSet<>();
        for (K key: keys) {
            if (key != null) {
                if (this.cache.contains(key)) {
                    result.put(key, this.getFromCache(key));
                } else {
                    missingKeys.add(key);
                }
            } else {
                AbstractCacheManager.LOGGER.warn("null key has been ignored");
            }
        }

        if(missingKeys != null && !missingKeys.isEmpty() ) {
            Map<K, V> fromExternal = getMapFromExternalSystem(missingKeys);
            result.putAll(fromExternal);
            for (K k: fromExternal.keySet()) {
                V v = fromExternal.get(k);
                if (v != null) {
                    this.cache.put(k, v);
                }

            }
        }

        return result;
    }

    protected abstract Map<K,V> getMapFromExternalSystem(Set<K> keys);
}
