package io.pluggorithm.algorithms;

import io.pluggorithm.core.BaseAlgorithm;
import java.util.*;
import java.util.function.Predicate;

public class FilterAlgorithm<T> implements BaseAlgorithm<List<T>, List<T>> {
    private Predicate<T> predicate = x -> true;
    
    @Override
    public void configure(Map<String, Object> parameters) {
        if (parameters.containsKey("predicate")) {
            @SuppressWarnings("unchecked")
            Predicate<T> temp = (Predicate<T>) parameters.get("predicate");
            predicate = temp;
        }
    }
    
    @Override
    public List<T> execute(List<T> input) {
        List<T> result = new ArrayList<>();
        for (T item : input) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
    
    @Override
    public String getDescription() {
        return "Filters elements from a list based on a predicate";
    }
}
