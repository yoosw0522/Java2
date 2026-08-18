package ai0818;

public class ArrayTest02 {
    public static void main(String[] args) {
        int[] arr1 = {100, 200, 300, 400, 500};
        int sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
            if (i < arr1.length-1){
                System.out.print(arr1[i] + " + ");
            } else {
                System.out.print(arr1[i] + " = " + sum);
            }
        }
    }
}
