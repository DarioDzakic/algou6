package at.fh_burgenland.bswe.algo.menu;

import at.fh_burgenland.bswe.algo.sort.heapsort.Heapsort;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Log4j2
public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void openMenu(){
        long startTime, endTime;
        int algorithm;
        int inputType;
        boolean exit = true;
        List<Integer> list = new ArrayList();

        System.out.println("Hello and welcome to the Merge and Heap sort Menu \n" +
                "Choose with the numbers the menu item you want");
        while(exit){
            System.out.println("Choose now the algorithm you want to use:");
            System.out.println("1. Mergesort");
            System.out.println("2. Heapsort");
            algorithm = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Choose now how you want insert the data");
            System.out.println("1. per command line");
            System.out.println("2. per txt file; format: one number per line");
            System.out.println("3. per txt file; format: delimited by ';' ");

            inputType=scanner.nextInt();
            scanner.nextLine();
            switch (inputType){
                case 1:
                    list = inputData();
                    break;
                case 2:
                    list = importData("\n");
                    break;
                case 3:
                    list = importData(";");
                    break;
            }
            switch (algorithm){
                case 1:
                    //merge;
                    break;
                case 2:
                    log.warn("BinaryRecursive");
                    startTime = System.nanoTime();
                    Heapsort.heapSort(list);
                    endTime = System.nanoTime();
                    log.warn("Execution time: {} ms", (endTime - startTime) / 1_000_000.0);
                    break;
            }
            printResult(list);
            System.out.println("\n If you want to leave press 1, if you want to resume" +
                    "just enter any other number");

            if(scanner.nextInt()==1){
                exit= false;
            }
            scanner.nextLine();
        }
    }

    private void printResult(List<Integer> list) {
        System.out.println("Here is the result of the given Data");
        System.out.print(list.toString());
    }

    public List<Integer> inputData(){
        System.out.println("Please type in your numbers now (1, 5, 4, 2): ");
        String input = scanner.nextLine();
        return Arrays
            .stream(input.split(", "))
            .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> importData(String delimiter){
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("type in the absolut path to your file");
        String path=scanner.nextLine();
        try {
            Scanner scanner = new Scanner(new File(path));
            scanner.useDelimiter(delimiter);
            while (scanner.hasNext()) {
                String data = scanner.next().trim();
                if (!data.isEmpty()) {
                    list.add(Integer.valueOf(data));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
