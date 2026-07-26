public class InsertionSort {


    public void sort(double price[]){

        for(int i = 1; i < price.length; i++){

            double key = price[i];

            int j = i - 1;


            while(j >= 0 && price[j] > key){

                price[j + 1] = price[j];

                j--;
            }


            price[j + 1] = key;
        }
    }
}