package io.pluggorithm.core;

import java.util.Map;

/**
 * Base interface for all pluggable algorithms.
 * @param <I> Input type
 * @param <O> Output type
 */
public interface BaseAlgorithm<I, O> {
    /**
     * Configure the algorithm with parameters
     * @param parameters Configuration parameters
     */
    void configure(Map<String, Object> parameters);
    
    /**
     * Execute the algorithm
     * @param input Input data
     * @return Output result
     */
    O execute(I input);
    
    /**
     * Get algorithm metadata
     * @return Algorithm information
     */
    default String getName() {
        return this.getClass().getSimpleName();
    }
    
    /**
     * Get algorithm description
     * @return Description of what the algorithm does
     */
    default String getDescription() {
        return "No description provided";
    }
}
