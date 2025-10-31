# Cache Design Patterns: Preferred vs Not Preferred

This directory demonstrates two approaches to implementing caching in applications.

## Directory Structure

```
cachedesignpatterns/
├── notpreferred/          # ❌ Bad approach - tight coupling
│   ├── User.java
│   ├── UserRepository.java
│   ├── UserService.java   # Directly uses HashMap
│   └── Main.java
│
└── preferred/             # ✅ Good approach - abstraction
    ├── CacheService.java       # Interface (abstraction layer)
    ├── HashMapCacheService.java
    ├── RedisCacheService.java
    ├── User.java
    ├── UserRepository.java
    ├── UserService.java        # Uses CacheService interface
    ├── CacheConfig.java
    └── Main.java
```

## Not Preferred Approach (notpreferred/)

### Problems:
- ❌ Tight coupling with HashMap
- ❌ Hard to migrate to Redis/Caffeine
- ❌ Difficult to test (can't mock cache)
- ❌ No TTL support
- ❌ Business logic knows about cache implementation
- ❌ Need to change code in multiple places to switch cache

### To Run:
```bash
cd /Users/bhashkarbelwal/Downloads/practice/DSA/CompleteDSAGuide
javac cachedesignpatterns/notpreferred/*.java
java cachedesignpatterns.notpreferred.Main
```

## Preferred Approach (preferred/)

### Benefits:
- ✅ Loose coupling through abstraction
- ✅ Easy migration (just change config)
- ✅ Easy to test (can inject mocks)
- ✅ Supports TTL and advanced features
- ✅ Business logic independent of cache type
- ✅ Follows SOLID principles

### To Run:
```bash
cd /Users/bhashkarbelwal/Downloads/practice/DSA/CompleteDSAGuide
javac cachedesignpatterns/preferred/*.java
java cachedesignpatterns.preferred.Main
```

## Key Takeaway

**Migration Comparison:**

| Aspect | Not Preferred | Preferred |
|--------|--------------|-----------|
| Code changes needed | 50+ files | 1 config file |
| Migration time | 2-4 weeks | 1-2 days |
| Risk of bugs | High | Low |
| Testability | Hard | Easy |
| Maintainability | Poor | Excellent |

**To migrate from HashMap to Redis:**
- Not Preferred: Change code everywhere HashMap is used
- Preferred: Change one line in CacheConfig.java

This demonstrates the **Dependency Inversion Principle** - depend on abstractions, not concretions!
