package cachedesignpatterns.notpreferred;

/**
 * Demo of the NOT PREFERRED approach
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== NOT PREFERRED APPROACH: Tight Coupling ===\n");
        
        UserService userService = new UserService();
        
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
        
        System.out.println("\n=== PROBLEMS WITH THIS APPROACH ===");
        System.out.println("❌ HashMap is used directly everywhere");
        System.out.println("❌ To switch to Redis, need to change code in multiple places");
        System.out.println("❌ No TTL support");
        System.out.println("❌ Not thread-safe");
        System.out.println("❌ Hard to test and mock");
        System.out.println("❌ Business logic knows about cache implementation");
    }
}
