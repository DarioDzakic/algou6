package at.fh_burgenland.bswe.algo.sort.mergesort;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Mergesort {


    @Getter
    private static int comparisons;
    @Getter
    private static int merges;
    public static List<Integer> mergeSort(List<Integer> list) {
        comparisons = 0;
        merges = 0;
        return mergeSortRecursive(list);
    }

    private static List<Integer> mergeSortRecursive(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));
        left = mergeSortRecursive(left);
        right = mergeSortRecursive(right);
        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            comparisons++;
            if (left.get(i) < right.get(j)) {
                merged.add(left.get(i));
                merges++;
                i++;
            } else {
                merged.add(right.get(j));
                merges++;
                j++;
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            merges++;
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            merges++;
            j++;
        }
        return merged;
    }

}
