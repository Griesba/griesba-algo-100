package com.leretvil.cache;


import com.google.common.base.Preconditions;

public class Caching {
    private static CachingProvider cachingProvider;

    public static void initCachingProvider(CachingProvider cachingProvider){
        Preconditions.checkState(cachingProvider != null, "Caching already initialized");
        Caching.cachingProvider = cachingProvider;
    }

    public static CachingProvider getCachingProvider() {
        return Preconditions.checkNotNull(cachingProvider, "Caching has not been initialized");
    }
}
