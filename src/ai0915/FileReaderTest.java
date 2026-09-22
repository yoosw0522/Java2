package ai0915;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        try {
            // File을 읽어오기 위한 입력스트림(InputStream) 생성
            BufferedReader br = new BufferedReader(new FileReader("D:/FileIOTest/MyData1.txt"));
            String line = "";

            // File에서 한 줄 읽어오기
            line = br.readLine();
            System.out.println(line);

            line = br.readLine();
            System.out.println(line);

            line = br.readLine();
            System.out.println(line);

            // FileInputStream 닫기
            br.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}