package com.leretvil.cache;

public interface CacheManager {
    <K,V> Cache<K,V> getCache(String cacheName);
}
