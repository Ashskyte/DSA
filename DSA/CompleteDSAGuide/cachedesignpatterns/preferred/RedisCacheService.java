package cachedesignpatterns.preferred;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Redis implementation of CacheService
 * This is a SIMULATED Redis implementation for demonstration
 * In real application, you would use Spring Data Redis / Jedis / Lettuce
 */
public class RedisCacheService<K, V> implements CacheService<K, V> {
    
    // Simulating Redis storage
    private final Map<K, V> redisSimulator = new HashMap<>();
    private final Map<K, Long> expirationTimes = new HashMap<>();
    
    @Override
    public Optional<V> get(K key) {
        // Check if key has expired
        if (isExpired(key)) {
            System.out.println("[Redis Cache] Key expired: " + key);
            redisSimulator.remove(key);
            expirationTimes.remove(key);
            return Optional.empty();
        }
        
        V value = redisSimulator.get(key);
        if (value != null) {
            System.out.println("[Redis Cache] Hit for key: " + key);
        } else {
            System.out.println("[Redis Cache] Miss for key: " + key);
        }
        return Optional.ofNullable(value);
    }
    
    @Override
    public void put(K key, V value) {
        System.out.println("[Redis Cache] Storing key: " + key);
        redisSimulator.put(key, value);
    }
    
    @Override
    public void put(K key, V value, Duration ttl) {
        System.out.println("[Redis Cache] Storing key: " + key + " with TTL: " + ttl.getSeconds() + "s");
        redisSimulator.put(key, value);
        long expirationTime = System.currentTimeMillis() + ttl.toMillis();
        expirationTimes.put(key, expirationTime);
    }
    
    @Override
    public void remove(K key) {
        System.out.println("[Redis Cache] Removing key: " + key);
        redisSimulator.remove(key);
        expirationTimes.remove(key);
    }
    
    @Override
    public boolean containsKey(K key) {
        if (isExpired(key)) {
            redisSimulator.remove(key);
            expirationTimes.remove(key);
            return false;
        }
        return redisSimulator.containsKey(key);
    }
    
    @Override
    public void clear() {
        System.out.println("[Redis Cache] Clearing all entries");
        redisSimulator.clear();
        expirationTimes.clear();
    }
    
    @Override
    public long size() {
        // Clean up expired keys first
        cleanupExpiredKeys();
        return redisSimulator.size();
    }
    
    private boolean isExpired(K key) {
        Long expirationTime = expirationTimes.get(key);
        if (expirationTime == null) {
            return false;
        }
        return System.currentTimeMillis() > expirationTime;
    }
    
    private void cleanupExpiredKeys() {
        expirationTimes.entrySet().removeIf(entry -> {
            if (System.currentTimeMillis() > entry.getValue()) {
                redisSimulator.remove(entry.getKey());
                return true;
            }
            return false;
        });
    }
}

/**
 * NOTE: In a real Spring Boot application, you would use:
 * 
 * @Autowired
 * private RedisTemplate<K, V> redisTemplate;
 * 
 * And implement methods like:
 * redisTemplate.opsForValue().get(key)
 * redisTemplate.opsForValue().set(key, value, ttl)
 */
