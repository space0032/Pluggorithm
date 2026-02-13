package io.pluggorithm.algorithms;

import io.pluggorithm.core.BaseAlgorithm;
import java.util.*;

public class SortingAlgorithm implements BaseAlgorithm<List<Integer>, List<Integer>> {
    private boolean ascending = true;
    
    @Override
    public void configure(Map<String, Object> parameters) {
        ascending = (boolean) parameters.getOrDefault("ascending", true);
    }
    
    @Override
    public List<Integer> execute(List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);
        if (ascending) {
            result.sort(Comparator.naturalOrder());
        } else {
            result.sort(Comparator.reverseOrder());
        }
        return result;
    }
    
    @Override
    public String getDescription() {
        return "Sorts a list of integers in ascending or descending order";
    }
}
