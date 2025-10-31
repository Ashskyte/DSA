package cachedesignpatterns.notpreferred;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulates a database repository
 */
public class UserRepository {
    
    // Simulating database storage
    private Map<String, User> database = new HashMap<>();
    
    public UserRepository() {
        // Pre-populate with some data
        database.put("1", new User("1", "John Doe", "john@example.com", 30));
        database.put("2", new User("2", "Jane Smith", "jane@example.com", 25));
        database.put("3", new User("3", "Bob Johnson", "bob@example.com", 35));
    }
    
    public User findById(String id) {
        System.out.println("Database query executed for user: " + id);
        // Simulate database delay
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return database.get(id);
    }
    
    public void save(User user) {
        System.out.println("Saving user to database: " + user.getId());
        database.put(user.getId(), user);
    }
    
    public void delete(String id) {
        System.out.println("Deleting user from database: " + id);
        database.remove(id);
    }
}
