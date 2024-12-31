package at.fh_burgenland.bswe.algo.menu;

import at.fh_burgenland.bswe.algo.sort.heapsort.Heapsort;
import at.fh_burgenland.bswe.algo.sort.mergesort.Mergesort;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void openMenu() {
        boolean exit = true;
        while (exit) {
            System.out.println("\nHello and welcome to the Merge and Heap sort Menu!");
            System.out.println("Choose the algorithm you want to use:");
            System.out.println("1. Mergesort");
            System.out.println("2. Heapsort");
            System.out.println("3. Exit");

            int algorithm = scanner.nextInt();
            scanner.nextLine();

            if (algorithm == 3) {
                exit = false;
                System.out.println("Goodbye!");
                break;
            }

            System.out.println("Choose how you want to insert the data");
            System.out.println("1. per command line");
            System.out.println("2. per txt file; format: one number per line");
            System.out.println("3. per txt file; format: delimited by ';' ");

            int inputType = scanner.nextInt();
            scanner.nextLine();

            List<Integer> list = new ArrayList<>();
            switch (inputType) {
                case 1 -> list = inputData();
                case 2 -> list = importData("\n");
                case 3 -> list = importData(";");
            }

            switch (algorithm) {
                case 1 -> {
                    log.info("\n==> Mergesort <==");
                    long startTime = System.nanoTime();
                    List<Integer> sorted = Mergesort.mergeSort(list);
                    long endTime = System.nanoTime();
                    double durationMs = (endTime - startTime) / 1_000_000.0;

                    System.out.println("Sorted result: " + sorted);
                    log.info("Mergesort completed in {} ms", durationMs);
                    log.info("Mergesort: total iterations (Sortierdurchläufe) = {}", Mergesort.getIterations());
                }
                case 2 -> {
                    log.info("\n==> Heapsort <==");
                    long startTime = System.nanoTime();
                    Heapsort.heapSort(list);
                    long endTime = System.nanoTime();
                    double durationMs = (endTime - startTime) / 1_000_000.0;

                    System.out.println("Sorted result: " + list);
                    log.info("Heapsort completed in {} ms", durationMs);
                    log.info("Heapsort: total iterations  = {}", Heapsort.getIterations());
                }
            }
        }
    }


    private List<Integer> inputData() {
        System.out.println("Please type in your numbers now (for example: 1, 5, 4, 2): ");
        String input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    private List<Integer> importData(String delimiter) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Type in the absolute path to your file:");
        String path = scanner.nextLine();
        try {
            Scanner scannerFile = new Scanner(new File(path));
            scannerFile.useDelimiter(delimiter);
            while (scannerFile.hasNext()) {
                String data = scannerFile.next().trim();
                if (!data.isEmpty()) {
                    list.add(Integer.parseInt(data));
                }
            }
            scannerFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
