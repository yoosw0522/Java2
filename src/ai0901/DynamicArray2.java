package ai0901;

// 동적 배열은 각 행마다 열의 길이를 다르게 할 수 있는 배열
public class DynamicArray2 {
    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30, 40},{50, 20},{10, 30, 50}};

        System.out.println("[동적배열에 저장된 초기값 출력]");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }
    }
}