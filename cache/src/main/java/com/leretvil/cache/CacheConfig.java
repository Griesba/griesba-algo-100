package com.leretvil.cache;

import com.leretvil.cache.manager.AbstractCacheManager;
import com.leretvil.cache.manager.PropertyCacheManager;

import static com.leretvil.cache.CacheSize.SMALL;

public enum CacheConfig {
    PROPERTY("Properties", PropertyCacheManager.class, SMALL, new CacheTimerConfiguration("cache.properties", 1800L, true));

    private final String name;
    private final Class<? extends AbstractCacheManager<?,?>> managerClass;
    private final CacheSize cacheSize;
    private final CacheTimerConfiguration cacheTimerConfiguration;

    CacheConfig(String name, Class<? extends AbstractCacheManager<?, ?>> managerClass, CacheSize cacheSize, CacheTimerConfiguration cacheTimerConfiguration) {
        this.name = name;
        this.managerClass = managerClass;
        this.cacheSize = cacheSize;
        this.cacheTimerConfiguration = cacheTimerConfiguration;
    }

    public String getName() {
        return name;
    }

    public Class<? extends AbstractCacheManager<?, ?>> getManagerClass() {
        return managerClass;
    }

    public CacheSize getCacheSize() {
        return cacheSize;
    }

    public CacheTimerConfiguration getCacheTimerConfiguration() {
        return cacheTimerConfiguration;
    }
}
