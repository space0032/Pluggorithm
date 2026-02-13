package io.pluggorithm.algorithms;

import io.pluggorithm.core.BaseAlgorithm;
import java.util.*;
import java.util.function.Function;

public class TransformAlgorithm<I, O> implements BaseAlgorithm<List<I>, List<O>> {
    private Function<I, O> transformer = x -> (O) x;
    
    @Override
    public void configure(Map<String, Object> parameters) {
        if (parameters.containsKey("transformer")) {
            transformer = (Function<I, O>) parameters.get("transformer");
        }
    }
    
    @Override
    public List<O> execute(List<I> input) {
        List<O> result = new ArrayList<>();
        for (I item : input) {
            result.add(transformer.apply(item));
        }
        return result;
    }
    
    @Override
    public String getDescription() {
        return "Transforms elements from one type to another using a function";
    }
}
