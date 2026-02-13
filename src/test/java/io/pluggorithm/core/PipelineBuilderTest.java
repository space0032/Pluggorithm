package io.pluggorithm.core;

import io.pluggorithm.algorithms.SortingAlgorithm;
import io.pluggorithm.util.AlgorithmException;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class PipelineBuilderTest {
    
    @Test
    void testBuilderPattern() throws AlgorithmException {
        AlgorithmPipeline pipeline = PipelineBuilder.create()
            .addAlgorithm(new SortingAlgorithm())
            .enableLogging()
            .build();
        
        List<Integer> input = Arrays.asList(5, 2, 8, 1);
        List<Integer> result = pipeline.execute(input);
        
        assertEquals(Arrays.asList(1, 2, 5, 8), result);
    }
}
