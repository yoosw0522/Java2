package ai0922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LAB_DecodeTest {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("secure.txt"));
            FileWriter fw = new FileWriter("decode.txt");
            StringBuilder sb = new StringBuilder();

            String line = "";

            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line + "\n");
            }

            String decode = "";

            for (String text : sb.toString().split("\n")) {
                decode = "";
                for (int i = 0; i < text.length(); i++) {
                    int num = (int)text.charAt(i);
                    num -= 4;
                    decode += (char)num;
                }
                fw.write(decode + "\n");
            }

            br.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}