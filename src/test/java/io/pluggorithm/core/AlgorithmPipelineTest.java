package io.pluggorithm.core;

import io.pluggorithm.algorithms.SortingAlgorithm;
import io.pluggorithm.util.AlgorithmException;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class AlgorithmPipelineTest {
    
    @Test
    void testPipelineExecution() throws AlgorithmException {
        AlgorithmPipeline pipeline = new AlgorithmPipeline();
        pipeline.addAlgorithm(new SortingAlgorithm());
        
        List<Integer> input = Arrays.asList(3, 1, 4, 1, 5);
        List<Integer> result = pipeline.execute(input);
        
        assertEquals(Arrays.asList(1, 1, 3, 4, 5), result);
    }
}
