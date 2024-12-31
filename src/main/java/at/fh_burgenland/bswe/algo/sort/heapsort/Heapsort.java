package at.fh_burgenland.bswe.algo.sort.heapsort;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class Heapsort {

    @Getter
    private static int comparisons;
    @Getter
    private static int swaps;

    public static List<Integer> heapSort(List<Integer> list) {

        comparisons = 0;
        swaps = 0;

        int n = list.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(list, 0, i);
            heapify(list, i, 0);
        }
        return list;
    }

    private static void heapify(List<Integer> list, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            comparisons++;
            if (list.get(left) > list.get(largest)) {
                largest = left;
            }
        }

        if (right < n) {
            comparisons++;
            if (list.get(right) > list.get(largest)) {
                largest = right;
            }
        }

        if (largest != i) {
            swap(list, i, largest);

            heapify(list, n, largest);
        }
    }
    private static void swap(List<Integer> list, int i, int j) {
        swaps++;
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
