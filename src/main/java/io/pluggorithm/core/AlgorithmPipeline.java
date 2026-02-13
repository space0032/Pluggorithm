package io.pluggorithm.core;

import io.pluggorithm.util.AlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Pipeline for executing a sequence of algorithms
 */
public class AlgorithmPipeline {
    private final List<BaseAlgorithm<?, ?>> algorithms = new ArrayList<>();
    private boolean enableLogging = false;
    
    public AlgorithmPipeline addAlgorithm(BaseAlgorithm<?, ?> algorithm) {
        algorithms.add(algorithm);
        return this;
    }
    
    public void setLogging(boolean enable) {
        this.enableLogging = enable;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T execute(Object input) throws AlgorithmException {
        Object intermediateResult = input;
        
        for (int i = 0; i < algorithms.size(); i++) {
            BaseAlgorithm algorithm = algorithms.get(i);
            
            if (enableLogging) {
                System.out.println("Executing: " + algorithm.getName());
            }
            
            try {
                intermediateResult = algorithm.execute(intermediateResult);
            } catch (Exception e) {
                throw new AlgorithmException(
                    "Error executing algorithm at stage " + i + ": " + algorithm.getName(), e
                );
            }
        }
        
        return (T) intermediateResult;
    }
    
    public List<BaseAlgorithm<?, ?>> getAlgorithms() {
        return new ArrayList<>(algorithms);
    }
}
