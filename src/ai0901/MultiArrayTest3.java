package ai0901;

public class MultiArrayTest3 {
    public static void main(String[] args) {;
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println("<arr[0][0] ~ arr[2][3] 요소에 저장된 값을 출력>");

        for (int i = 0; i < arr.length; i++) { // 행의 길이 만큼 반복
            for (int j = 0; j < arr[i].length; j++) {//열의 길이 만큼 반복
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
