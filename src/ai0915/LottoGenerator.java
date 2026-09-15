package ai0915;

import java.util.Arrays;
import java.util.Random;

public class LottoGenerator {

    static int lottoNumber(){
        Random random = new Random();
        int number = random.nextInt(45) + 1;
        return number;
    }

    public static void main(String[] args) {
        int[] lottoArr = {};
        int number = 0;

        System.out.println("========== Lotto 추첨을 시작하겠습니다. ==========");

        my_loop:
        while (true){
            number = lottoNumber();

            for (int num : lottoArr){
                if (number == num){
                    continue my_loop;
                }
            }

            lottoArr = Arrays.copyOf(lottoArr, lottoArr.length + 1);
            lottoArr[lottoArr.length - 1] = number;

            if (lottoArr.length == 6)
                break;
        }

        System.out.println("========= 이번 주 1등 로또 번호 =========");
        Arrays.sort(lottoArr);
        System.out.println(Arrays.toString(lottoArr));
    }
}