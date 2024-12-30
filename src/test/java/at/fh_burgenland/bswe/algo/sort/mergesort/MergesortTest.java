package at.fh_burgenland.bswe.algo.sort.mergesort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergesortTest {

    @Test
    void testMergeSortWithPositiveNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(9, 4, 3, 8, 10));
        List<Integer> expected = new ArrayList<>(Arrays.asList(3, 4, 8, 9, 10));

        List<Integer> result = Mergesort.mergeSort(input);

        assertEquals(expected, result);
    }

    @Test
    void testMergeSortWithMultiplePositiveNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(9, 4, 3, 8, 10, 2, 5, 33, 7, 24));
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 7, 8, 9, 10, 24, 33));

        List<Integer> result = Mergesort.mergeSort(input);

        assertEquals(expected, result);
    }

    @Test
    void testMergeSortWithLargerPositiveNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(9, 4, 3, 8, 10, 2, 5, 100, 201, 211, 91, 41, 12));
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 8, 9, 10, 12, 41, 91, 100, 201, 211));

        List<Integer> result = Mergesort.mergeSort(input);

        assertEquals(expected, result);
    }

    @Test
    void testMergeSortWithNegativeNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-1, -10, -3, -5, -2));
        List<Integer> expected = new ArrayList<>(Arrays.asList(-10, -5, -3, -2, -1));

        List<Integer> result = Mergesort.mergeSort(input);

        assertEquals(expected, result);
    }

    @Test
    void testMergeSortWithMixedNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, -1, 5, -10, 3));
        List<Integer> expected = new ArrayList<>(Arrays.asList(-10, -1, 0, 3, 5));

        List<Integer> result = Mergesort.mergeSort(input);

        assertEquals(expected, result);
    }

    @Test
    void testMergeSortWithDuplicateNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(4, 1, 3, 4, 2, 2));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4));

        List<Integer> result = Mergesort.mergeSort(input);

        assertEquals(expected, result);
    }

    @Test
    void testMergeSortWithSingleElement() {
        List<Integer> input = new ArrayList<>(List.of(42));
        List<Integer> expected = new ArrayList<>(List.of(42));

        List<Integer> result = Mergesort.mergeSort(input);

        assertEquals(expected, result);
    }

    @Test
    void testMergeSortWithEmptyList() {
        List<Integer> input = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        List<Integer> result = Mergesort.mergeSort(input);

        assertEquals(expected, result);
    }

    @Test
    void testMergeSortWithAlreadySortedList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> result = Mergesort.mergeSort(input);

        assertEquals(expected, result);
    }

}
