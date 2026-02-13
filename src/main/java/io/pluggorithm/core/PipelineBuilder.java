package io.pluggorithm.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Fluent builder for creating algorithm pipelines
 */
public class PipelineBuilder {
    private final AlgorithmPipeline pipeline;
    private boolean loggingEnabled = false;
    
    private PipelineBuilder() {
        this.pipeline = new AlgorithmPipeline();
    }
    
    public static PipelineBuilder create() {
        return new PipelineBuilder();
    }
    
    public PipelineBuilder addAlgorithm(BaseAlgorithm<?, ?> algorithm) {
        pipeline.addAlgorithm(algorithm);
        return this;
    }
    
    public PipelineBuilder addAlgorithm(BaseAlgorithm<?, ?> algorithm, Map<String, Object> config) {
        algorithm.configure(config);
        pipeline.addAlgorithm(algorithm);
        return this;
    }
    
    public PipelineBuilder enableLogging() {
        this.loggingEnabled = true;
        return this;
    }
    
    public AlgorithmPipeline build() {
        pipeline.setLogging(loggingEnabled);
        return pipeline;
    }
}
