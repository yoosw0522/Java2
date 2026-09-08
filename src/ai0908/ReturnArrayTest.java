package ai0908;

public class ReturnArrayTest {

    public static int[] resultCalc(int n1, int n2) {
        int[] resultArr = new int[4];
        resultArr[0] = n1 + n2;
        resultArr[1] = n1 - n2;
        resultArr[2] = n1 * n2;
        resultArr[3] = n1 / n2;

        return resultArr;
    }

    public static void main(String[] args) {
        int n1 = 200;
        int n2 = 500;

        int[] resultArr = resultCalc(n1, n2);
        char[] opertors = {'+', '-', '*', '/'};

        for (int i = 0; i < opertors.length; i++) {
            System.out.printf("%d %c %d = %d\n", n1, opertors[i], n2, resultArr[i]);
        }
    }
}