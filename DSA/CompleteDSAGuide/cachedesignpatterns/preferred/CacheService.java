package cachedesignpatterns.preferred;

import java.time.Duration;
import java.util.Optional;

/**
 * GOOD APPROACH: Abstraction Layer
 * This interface hides the cache implementation details
 */
public interface CacheService<K,V> {
    
    /**
     * Get value from cache
     * @param key the cache key
     * @return Optional containing the value if present
     */
    Optional<V> get(K key);
    
    /**
     * Put value in cache without expiration
     * @param key the cache key
     * @param value the value to cache
     */
    void put(K key, V value);
    
    /**
     * Put value in cache with TTL (Time To Live)
     * @param key the cache key
     * @param value the value to cache
     * @param ttl time to live duration
     */
    void put(K key, V value, Duration ttl);
    
    /**
     * Remove value from cache
     * @param key the cache key
     */
    void remove(K key);
    
    /**
     * Check if key exists in cache
     * @param key the cache key
     * @return true if key exists
     */
    boolean containsKey(K key);
    
    /**
     * Clear all cache entries
     */
    void clear();
    
    /**
     * Get cache size
     * @return number of entries in cache
     */
    long size();
}

/**
 * BENEFITS OF THIS APPROACH:
 * 1. Loose coupling - implementation can be changed easily
 * 2. Easy to test - can create mock implementations
 * 3. Consistent API - all cache implementations follow same interface
 * 4. Easy migration - switch from HashMap to Redis by changing config only
 * 5. Business logic doesn't know about cache implementation
 */
