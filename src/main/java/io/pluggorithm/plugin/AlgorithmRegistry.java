package io.pluggorithm.plugin;

import io.pluggorithm.core.BaseAlgorithm;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Registry for managing available algorithms
 */
public class AlgorithmRegistry {
    private static final Map<String, BaseAlgorithm<?, ?>> registry = new ConcurrentHashMap<>();
    
    public static void register(String name, BaseAlgorithm<?, ?> algorithm) {
        registry.put(name, algorithm);
    }
    
    public static Optional<BaseAlgorithm<?, ?>> get(String name) {
        return Optional.ofNullable(registry.get(name));
    }
    
    public static Map<String, BaseAlgorithm<?, ?>> getAll() {
        return new ConcurrentHashMap<>(registry);
    }
}
