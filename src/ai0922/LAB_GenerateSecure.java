package ai0922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LAB_GenerateSecure {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("MyData01.txt"));
            FileWriter fw = new FileWriter("secure.txt");
            StringBuilder sb = new StringBuilder();

            String line = "";

            while (true) {
                line = br.readLine();
                if (line == null) {
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

            br.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}