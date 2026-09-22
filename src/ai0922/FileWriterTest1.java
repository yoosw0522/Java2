package ai0922;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest1 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("MyData1.txt");
            String line = "";

            line = "오늘은 추석 연휴가 시작되는 전전날입니다.";
            fw.write(line + "\n");

            line = "내일은 추석 연휴가 시작되는 전날입니다.";
            fw.write(line + "\n");

            line = "모레는 추석 연휴가 시작되는 날입니다!";
            fw.write(line + "\n");

            fw.close();
            System.out.println("myData2.txt에 내용이 저장되었습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}