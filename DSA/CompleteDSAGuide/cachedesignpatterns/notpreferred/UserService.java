package cachedesignpatterns.notpreferred;

import java.util.HashMap;
import java.util.Map;

/**
 * BAD APPROACH: Tight Coupling with HashMap
 * Problem: If you want to switch to Redis/Caffeine, you need to change code everywhere!
 */
public class UserService {
    
    // Directly using HashMap - tightly coupled!
    private Map<String, User> userCache = new HashMap<>();
    private UserRepository userRepository = new UserRepository();
    
    public User getUser(String id) {
        // HashMap logic scattered throughout code
        if (userCache.containsKey(id)) {
            System.out.println("Cache hit for user: " + id);
            return userCache.get(id);
        }
        
        System.out.println("Cache miss for user: " + id);
        User user = userRepository.findById(id);
        userCache.put(id, user);
        return user;
    }
    
    public void updateUser(User user) {
        userRepository.save(user);
        // HashMap everywhere!
        userCache.put(user.getId(), user);
    }
    
    public void deleteUser(String id) {
        userRepository.delete(id);
        // HashMap reference again!
        userCache.remove(id);
    }
    
    public void clearCache() {
        // HashMap specific method
        userCache.clear();
    }
    
    public int getCacheSize() {
        // HashMap specific method
        return userCache.size();
    }
}

/**
 * PROBLEMS WITH THIS APPROACH:
 * 1. Tight coupling - HashMap is used directly everywhere
 * 2. Hard to test - can't easily mock the cache
 * 3. No TTL support - HashMap doesn't support expiration
 * 4. Not thread-safe - HashMap is not thread-safe
 * 5. Migration nightmare - need to change code in 50+ places to switch to Redis
 * 6. No abstraction - business logic knows about cache implementation details
 */
