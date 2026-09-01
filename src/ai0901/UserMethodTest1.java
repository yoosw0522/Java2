package ai0901;

import java.util.Random;

public class UserMethodTest1 {
    public static void testDice(String userName) {
        System.out.println(userName + "님, 주사위를 던지세요.");
        Random random = new Random();
        int diceNum = random.nextInt(6) + 1;
        System.out.println("주사위 번호: " + diceNum);
    }

    public static void main(String[] args) {
        String[] userNameArr = {"사과", "키위", "복숭아", "딸기", "무화과"};

        for (int i = 0; i < userNameArr.length; i++) {
            testDice(userNameArr[i]);
        }
    }
}
