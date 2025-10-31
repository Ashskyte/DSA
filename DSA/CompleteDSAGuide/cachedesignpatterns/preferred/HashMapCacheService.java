package cachedesignpatterns.preferred;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap implementation of CacheService
 * Uses ConcurrentHashMap for thread-safety
 */
public class HashMapCacheService<K, V> implements CacheService<K, V> {
    
    private final Map<K, V> cache = new ConcurrentHashMap<>();
    
    @Override
    public Optional<V> get(K key) {
        V value = cache.get(key);
        if (value != null) {
            System.out.println("[HashMap Cache] Hit for key: " + key);
        } else {
            System.out.println("[HashMap Cache] Miss for key: " + key);
        }
        return Optional.ofNullable(value);
    }
    
    @Override
    public void put(K key, V value) {
        System.out.println("[HashMap Cache] Storing key: " + key);
        cache.put(key, value);
    }
    
    @Override
    public void put(K key, V value, Duration ttl) {
        // Note: HashMap doesn't support TTL natively
        // This is a limitation, but the interface is ready for Redis migration
        System.out.println("[HashMap Cache] Storing key: " + key + " (TTL not supported in HashMap)");
        cache.put(key, value);
    }
    
    @Override
    public void remove(K key) {
        System.out.println("[HashMap Cache] Removing key: " + key);
        cache.remove(key);
    }
    
    @Override
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }
    
    @Override
    public void clear() {
        System.out.println("[HashMap Cache] Clearing all entries");
        cache.clear();
    }
    
    @Override
    public long size() {
        return cache.size();
    }
}
