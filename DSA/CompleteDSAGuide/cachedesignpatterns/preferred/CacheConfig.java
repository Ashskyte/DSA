package cachedesignpatterns.preferred;

/**
 * Configuration class to decide which cache implementation to use
 * This is where you make the switch between HashMap, Redis, Caffeine, etc.
 */
public class CacheConfig {
    
    public enum CacheType {
        HASHMAP,
        REDIS,
        CAFFEINE  // Can add more implementations
    }
    
    /**
     * Factory method to create appropriate cache service
     * TO MIGRATE: Just change the cacheType parameter!
     */
    public static <K, V> CacheService<K, V> createCacheService(CacheType cacheType) {
        switch (cacheType) {
            case REDIS:
                System.out.println("✅ Using Redis Cache Implementation");
                return new RedisCacheService<>();
                
            case HASHMAP:
            default:
                System.out.println("✅ Using HashMap Cache Implementation");
                return new HashMapCacheService<>();
        }
    }
    
    /**
     * In Spring Boot, this would be:
     * 
     * @Configuration
     * public class CacheConfig {
     *     
     *     @Value("${cache.type}")
     *     private String cacheType;
     *     
     *     @Bean
     *     public CacheService<String, User> userCache(RedisTemplate<String, User> redisTemplate) {
     *         if ("redis".equals(cacheType)) {
     *             return new RedisCacheService<>(redisTemplate);
     *         }
     *         return new HashMapCacheService<>();
     *     }
     * }
     */
}
