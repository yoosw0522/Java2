package ai0825;

import java.util.Scanner;

public class LABFigureScore {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int[] scoreArr = new int[5];
        int sum = 0;
        double avg;

        System.out.println("김연아 선수가 멋진 경기를 마쳤습니다");
        System.out.println("심사위원분들은 최대 10점까지 주실 수 있습니다.");
        for (int i =0; i < scoreArr.length ; i++) {
            System.out.print("심사위원" + (i+1) + ":");
            scoreArr[i] = s1.nextInt();
            sum += scoreArr[i];
        }

        avg = (double) sum / scoreArr.length;

        System.out.println("[심사위원 입력점수]");
        for (int i =0; i < scoreArr.length ; i++){
            System.out.printf("심사위원 %d: %d점  ",i+1, scoreArr[i]);
        }
        System.out.println();
        System.out.println("합계점수: " + sum);
        System.out.printf("합계점수: %.2f", avg);
        s1.close();
    }
}
