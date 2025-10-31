package cachedesignpatterns.preferred;

import cachedesignpatterns.preferred.CacheConfig.CacheType;

/**
 * Demo of the PREFERRED approach with abstraction
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== PREFERRED APPROACH: Using Abstraction ===\n");
        
        // Demo 1: Using HashMap implementation
        demoWithHashMap();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Demo 2: Using Redis implementation (simulated)
        demoWithRedis();
        
        System.out.println("\n=== KEY TAKEAWAY ===");
        System.out.println("✅ UserService code is EXACTLY THE SAME for both HashMap and Redis!");
        System.out.println("✅ To migrate, we only changed the CacheConfig - no business logic changes!");
        System.out.println("✅ This is the power of abstraction!");
    }
    
    private static void demoWithHashMap() {
        System.out.println("--- Demo 1: Using HashMap Cache ---\n");
        
        // Create cache service - using HashMap
        CacheService<String, User> cache = CacheConfig.createCacheService(CacheType.HASHMAP);
        UserService userService = new UserService(cache);
        
        runDemo(userService);
    }
    
    private static void demoWithRedis() {
        System.out.println("--- Demo 2: Using Redis Cache ---\n");
        
        // Create cache service - using Redis (simulated)
        // TO MIGRATE: ONLY THIS LINE CHANGES!
        CacheService<String, User> cache = CacheConfig.createCacheService(CacheType.REDIS);
        UserService userService = new UserService(cache);
        
        // UserService code is EXACTLY THE SAME!
        runDemo(userService);
    }
    
    private static void runDemo(UserService userService) {
        // First call - cache miss
        System.out.println("1. Getting user 1 (first time):");
        User user1 = userService.getUser("1");
        System.out.println("Result: " + user1 + "\n");
        
        // Second call - cache hit
        System.out.println("2. Getting user 1 (second time - from cache):");
        User user1Again = userService.getUser("1");
        System.out.println("Result: " + user1Again + "\n");
        
        // Update user
        System.out.println("3. Updating user 1:");
        user1.setAge(31);
        userService.updateUser(user1);
        System.out.println("Updated!\n");
        
        // Get updated user from cache
        System.out.println("4. Getting user 1 after update:");
        User updatedUser = userService.getUser("1");
        System.out.println("Result: " + updatedUser + "\n");
        
        System.out.println("Cache size: " + userService.getCacheSize());
    }
}

/**
 * OUTPUT DEMONSTRATES:
 * 
 * 1. Both HashMap and Redis work with the SAME UserService code
 * 2. Migration is just a configuration change
 * 3. Business logic is completely decoupled from cache implementation
 * 4. Easy to add new cache implementations (Caffeine, Hazelcast, etc.)
 * 5. Easy to test - can inject mock CacheService
 * 
 * This is the SOLID principle in action:
 * - Dependency Inversion Principle: Depend on abstractions, not concretions
 * - Open/Closed Principle: Open for extension (new cache types), closed for modification
 */
