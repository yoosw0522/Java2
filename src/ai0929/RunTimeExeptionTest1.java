package ai0929;

public class RunTimeExeptionTest1 {
    public static void main(String[] args) {
        String[] names = {"홍길동","성춘향","이몽룡"};
        try{
            System.out.println(names[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 인덱스 번호가 범위를 벗어났습니다.");
        }finally {
            System.out.println("프로그램 종료");
        }

    }
}