package at.fh_burgenland.bswe.algo.sort.heapsort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapsortTest {
    @Test
    void testHeapSortWithPositiveNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(9, 4, 3, 8, 10));
        List<Integer> expected = new ArrayList<>(Arrays.asList(3, 4, 8, 9, 10));

        Heapsort.heapSort(input);

        assertEquals(expected, input);
    }

    @Test
    void testHeapSortWithPositiveNumbers2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(9, 4, 3, 8, 10, 2, 5, 33, 7, 24));
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 7, 8, 9, 10, 24, 33));

        Heapsort.heapSort(input);

        assertEquals(expected, input);
    }

    @Test
    void testHeapSortWithPositiveNumbers3() {
        List<Integer> input = new ArrayList<>(Arrays.asList(9, 4, 3, 8, 10, 2, 5, 100, 201, 211, 91, 41, 12));
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 8, 9, 10, 12, 41, 91, 100, 201, 211));

        Heapsort.heapSort(input);

        assertEquals(expected, input);
    }

    @Test
    void testHeapSortWithNegativeNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-1, -10, -3, -5, -2));
        List<Integer> expected = new ArrayList<>(Arrays.asList(-10, -5, -3, -2, -1));

        Heapsort.heapSort(input);

        assertEquals(expected, input);
    }

    @Test
    void testHeapSortWithMixedNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, -1, 5, -10, 3));
        List<Integer> expected = new ArrayList<>(Arrays.asList(-10, -1, 0, 3, 5));

        Heapsort.heapSort(input);

        assertEquals(expected, input);
    }

    @Test
    void testHeapSortWithDuplicateNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(4, 1, 3, 4, 2, 2));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4));

        Heapsort.heapSort(input);

        assertEquals(expected, input);
    }

    @Test
    void testHeapSortWithSingleElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(42));
        List<Integer> expected = new ArrayList<>(Arrays.asList(42));

        Heapsort.heapSort(input);

        assertEquals(expected, input);
    }

    @Test
    void testHeapSortWithEmptyArray() {
        List<Integer> input = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        Heapsort.heapSort(input);

        assertEquals(expected, input);
    }

    @Test
    void testHeapSortWithAlreadySortedArray() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Heapsort.heapSort(input);

        assertEquals(expected, input);
    }
}
