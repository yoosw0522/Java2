package ai0929;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsTest1 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("myData1.txt")
            );

            while (true) {
                String line = br.readLine();

                if (line == null) {
                    break;
                }

                System.out.println(line);
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수가 없습니다.");

        } catch (IOException e) {
            System.out.println("한 줄 읽어올 때 문제가 발생했습니다.");
        }
    }
}