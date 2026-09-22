package ai0922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LAB_EncodeTest {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("secure.txt");
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(System.in);

            String line = "";

            while (true) {
                line = scanner.nextLine();
                if (line.equals("exit")) {
                    break;
                }
                sb.append(line + "\n");
            }

            String secure = "";

            for (String text : sb.toString().split("\n")) {
                secure = "";
                for (int i = 0; i < text.length(); i++) {
                    int num = (int)text.charAt(i);
                    num += 4;
                    secure += (char)num;
                }
                fw.write(secure + "\n");
            }

            scanner.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}