package ai0901;

//동적 배열은 각 행마다 열의 길이를 다르게 할 수 있는 배열
public class DynamicArray1 {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        int[] colLength = {7, 5, 4};
        int count = 0;

        for (int i = 0; i < arr.length; i++) { // 행의 개수만큼 반복
            arr[i] = new int[colLength[i]];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ++count * 10;
            }
        }

        System.out.println("[동적배열에 저장된 초기값 출력]");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
