package ai0915;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest3 {
    // 파일 내용 전체를 거꾸로 출력
    public static void main(String[] args) {
        try {
            StringBuilder sb = new StringBuilder();
            // BufferedReader br = new BufferedReader(new FileReader("D:/FileIOTest/MyData1.txt"));
            BufferedReader br = new BufferedReader(new FileReader("MyData1.txt"));

            String line = "";

            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line).append("\n");
            }

            // FileInputStream 닫기
            br.close();

            sb.reverse();

            System.out.println(sb);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}