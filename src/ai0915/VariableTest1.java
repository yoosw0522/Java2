package ai0915;

public class VariableTest1 {
    static int a = 100;
    int b = 500;

    static void method1() {
        int a = 300;
        int b = 7000;
        System.out.println("지역 변수 a의 저장된 값: " + a);
        System.out.println("전역 변수 a를 method1()에서 사용하고 싶을 때: " + VariableTest1.a);
        VariableTest1 vt1 = new VariableTest1();
        System.out.println("전역 변수 b를 method1()에서 사용하고 싶을 때: " + vt1.b);
    }

    static void method2() {
        a += 20;
        System.out.println("전역 변수(필드) a의 저장된 값: " + a);
    }

    public static void main(String[] args) {
        method1();
        method2();
    }
}