package com.leretvil.cache;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public interface Cache<K, V> {

    Map<K,V> getAll(Set<K> keys);

    V get(K key);

    Iterator<Entry<K,V>> iterator();

    Collection<V> values();

    class Entry<K,V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
