package com.leretvil.cache.manager;

import com.leretvil.cache.containers.AbstractCache;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Map;
import java.util.Set;

public class PropertyCacheManager extends AbstractCacheManager<String, String> {

    private final static Logger LOG = LoggerFactory.getLogger(PropertyCacheManager.class);

    public PropertyCacheManager(AbstractCache<String, String> cache) {
        super(cache);
    }

    @Override
    public Map<String, String> getMapFromExternalSystem(Set<String> keys) {

    }


}
