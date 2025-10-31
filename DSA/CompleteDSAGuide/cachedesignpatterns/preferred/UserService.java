package cachedesignpatterns.preferred;

import java.time.Duration;

/**
 * GOOD APPROACH: Using Abstraction
 * UserService doesn't know if it's using HashMap, Redis, or Caffeine!
 * It only knows about the CacheService interface.
 */
public class UserService {
    
    // Using interface instead of concrete implementation!
    private final CacheService<String, User> cache;
    private final UserRepository userRepository;
    
    // Constructor injection - allows easy switching of implementations
    public UserService(CacheService<String, User> cache) {
        this.cache = cache;
        this.userRepository = new UserRepository();
    }
    
    public User getUser(String id) {
        // Try to get from cache first
        return cache.get(id)
            .orElseGet(() -> {
                // Cache miss - load from database
                User user = userRepository.findById(id);
                if (user != null) {
                    // Store in cache with 1 hour TTL
                    cache.put(id, user, Duration.ofHours(1));
                }
                return user;
            });
    }
    
    public void updateUser(User user) {
        userRepository.save(user);
        // Update cache with new data
        cache.put(user.getId(), user, Duration.ofHours(1));
    }
    
    public void deleteUser(String id) {
        userRepository.delete(id);
        // Remove from cache
        cache.remove(id);
    }
    
    public void clearCache() {
        cache.clear();
    }
    
    public long getCacheSize() {
        return cache.size();
    }
}

/**
 * BENEFITS OF THIS APPROACH:
 * ✅ Loose coupling - cache implementation can be changed easily
 * ✅ Easy to test - can inject mock CacheService
 * ✅ Migration is easy - just change which CacheService implementation you inject
 * ✅ Business logic doesn't know about cache implementation details
 * ✅ Supports TTL and other advanced features through interface
 * ✅ Thread-safe (if implementation is thread-safe)
 * ✅ Follows SOLID principles (Dependency Inversion)
 */
