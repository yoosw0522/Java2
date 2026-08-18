package ai0818;

import java.util.Arrays;

public class ArrayTest03 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};

        arr1 = Arrays.copyOf(arr1, arr1.length + 2);

        System.out.println("추가된 배열의 길이: " + arr1.length);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}