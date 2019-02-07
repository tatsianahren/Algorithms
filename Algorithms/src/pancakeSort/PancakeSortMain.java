package pancakeSort;

/*
    Flip function: to make reverse order for the first k elements in given array
    PancakeSort can use only flip function to make changes in the array
 */

import java.util.Arrays;

public class PancakeSortMain {

    public static void flip(int[] arr, int k){
        if(arr == null || arr.length < 2 || k < 2 || arr.length < k){
            return;
        }

        for (int i = 0; i < k/2; i++){
            int temp = arr[i];
            arr[i] = arr[k - 1 -i];
            arr[k - 1 - i] = temp;
        }
    }

    public static void pancakeSort(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--){
            int maxElIndex = 0;
            for(int j = 0; j <= i; j++) {
                if (arr[j] > arr[maxElIndex]) {
                    maxElIndex = j;
                }
            }

            flip(arr, maxElIndex + 1);
            flip(arr, i + 1);
        }

    }

    public static void main(String args[]){
        int[] arr = {1, 2, 5, 3, 6, 4, 7};
        System.out.println(Arrays.toString(arr));

        pancakeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
