package SortingAlgorithams;

public class Sorting<T extends Comparable<T>> {
    public void bubbleSort(T[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j].compareTo(array[j + 1])>0) {

                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public  void selectionSort(T[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j].compareTo(array[minIndex])<0) {
                    minIndex = j;
                }
            }

            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
    public  void insertionSort(T[] array) {

        for (int i = 1; i < array.length; i++) {

            T key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) > 0) {

                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
    public  void mergeSort(T[] array, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }
    private  void merge(T[] array, int left, int middle, int right) {

        Object[] temp = new Object[right - left + 1];

        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {

            if (array[i].compareTo(array[j]) <=0) {
                temp[k] = array[i];
                i++;
            } else{
                temp[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            temp[k] = array[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = array[j];
            j++;
            k++;
        }

        for (int x = 0; x < temp.length; x++) {
            array[left + x] = (T) temp[x];
        }
    }
    public  void quickSort(T[] array, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private  int partition(T[] array, int low, int high) {

        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (array[j].compareTo(pivot) <0) {

                i++;

                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }











    
}
