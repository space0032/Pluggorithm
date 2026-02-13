import io.pluggorithm.core.*;
import io.pluggorithm.algorithms.*;
import java.util.*;

public class BasicPipelineExample {
    public static void main(String[] args) throws Exception {
        // Create a pipeline
        AlgorithmPipeline pipeline = PipelineBuilder.create()
            .addAlgorithm(new SortingAlgorithm())
            .enableLogging()
            .build();
        
        // Execute
        List<Integer> input = Arrays.asList(5, 2, 8, 1, 9);
        List<Integer> result = pipeline.execute(input);
        
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
    }
}
