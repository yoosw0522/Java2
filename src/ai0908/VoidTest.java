package ai0908;

public class VoidTest {
    public static void printLine(String c, int count){
        for (int i = 0; i < count; i++) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] imogis = {"❤️","🍕", "💕", "😘", "🤷‍♂️", "👌", "🚀"};

        for (int i = 0; i < imogis.length; i++) {
            printLine(imogis[i], (i+1)*10);
        }
    }
}
