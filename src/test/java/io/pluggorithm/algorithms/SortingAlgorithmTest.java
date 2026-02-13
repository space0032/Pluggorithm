package io.pluggorithm.algorithms;

import io.pluggorithm.util.AlgorithmException;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmTest {
    
    @Test
    void testAscendingSorting() {
        SortingAlgorithm algorithm = new SortingAlgorithm();
        Map<String, Object> config = new HashMap<>();
        config.put("ascending", true);
        algorithm.configure(config);
        
        List<Integer> input = Arrays.asList(5, 2, 8, 1, 9);
        List<Integer> result = algorithm.execute(input);
        
        assertEquals(Arrays.asList(1, 2, 5, 8, 9), result);
    }
    
    @Test
    void testDescendingSorting() {
        SortingAlgorithm algorithm = new SortingAlgorithm();
        Map<String, Object> config = new HashMap<>();
        config.put("ascending", false);
        algorithm.configure(config);
        
        List<Integer> input = Arrays.asList(5, 2, 8, 1, 9);
        List<Integer> result = algorithm.execute(input);
        
        assertEquals(Arrays.asList(9, 8, 5, 2, 1), result);
    }
}
