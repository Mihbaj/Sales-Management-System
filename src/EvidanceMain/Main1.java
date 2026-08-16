package EvidanceMain;
import java.util.Random;

import SortingAlgorithams.*;

public class Main1 {
    public static  void  main(String[] args){
        

        Sorting<Integer> sorting = new Sorting<>();

        int[] inputSizes = {100, 500, 1000, 5000, 10000};

        Random random = new Random();

        System.out.println("Sorting Algorithm Execution Time");
        System.out.println("================================");

        for (int size : inputSizes) {

           
            Integer[] originalArray = new Integer[size];

            for (int i = 0; i < size; i++) {
                originalArray[i] = random.nextInt(100000);
            }

            Integer[] bubbleArray = originalArray.clone();
            Integer[] selectionArray = originalArray.clone();
            Integer[] insertionArray = originalArray.clone();
            Integer[] mergeArray = originalArray.clone();
            Integer[] quickArray = originalArray.clone();


           
            // Bubble Sort
            

            long startTime = System.nanoTime();

            sorting.bubbleSort(bubbleArray);

            long endTime = System.nanoTime();

            long bubbleTime = endTime - startTime;


          
            // Selection Sort
          
            startTime = System.nanoTime();

            sorting.selectionSort(selectionArray);

            endTime = System.nanoTime();

            long selectionTime = endTime - startTime;


            // Insertion Sort
           

            startTime = System.nanoTime();

            sorting.insertionSort(insertionArray);

            endTime = System.nanoTime();

            long insertionTime = endTime - startTime;


            
            // Merge Sort
         
            startTime = System.nanoTime();

            sorting.mergeSort(
                    mergeArray,
                    0,
                    mergeArray.length - 1
            );

            endTime = System.nanoTime();

            long mergeTime = endTime - startTime;


            // Quick Sort
        
            startTime = System.nanoTime();

            sorting.quickSort(
                    quickArray,
                    0,
                    quickArray.length - 1
            );

            endTime = System.nanoTime();

            long quickTime = endTime - startTime;


           
            // Display Results
            

            System.out.println("\nInput Size: " + size);

            System.out.println(
                    "Bubble Sort:    " + bubbleTime + " ns"
            );

            System.out.println(
                    "Selection Sort: " + selectionTime + " ns"
            );

            System.out.println(
                    "Insertion Sort: " + insertionTime + " ns"
            );

            System.out.println(
                    "Merge Sort:     " + mergeTime + " ns"
            );

            System.out.println(
                    "Quick Sort:     " + quickTime + " ns"
            );
        }
    }
}
        
        



        








        
       
        

      



        

       
