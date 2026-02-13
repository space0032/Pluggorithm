package io.pluggorithm.plugin;

import io.pluggorithm.core.BaseAlgorithm;
import java.util.ServiceLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Dynamically loads algorithm plugins using Java ServiceLoader
 */
public class AlgorithmPluginLoader {
    
    public static List<BaseAlgorithm<?, ?>> loadPlugins() {
        List<BaseAlgorithm<?, ?>> plugins = new ArrayList<>();
        ServiceLoader<BaseAlgorithm> loader = ServiceLoader.load(BaseAlgorithm.class);
        
        for (BaseAlgorithm<?, ?> algorithm : loader) {
            plugins.add(algorithm);
        }
        
        return plugins;
    }
}
