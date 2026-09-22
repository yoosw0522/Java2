package ai0922;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LAB_AddLineNumber {
    public static void main(String[] args) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader("MyData01.txt"));
            Integer count = 1;

            String line = "";

            while (true) {
                sb.append(count.toString() + " : ");
                line = br.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line).append("\n");
                count++;
            }

            System.out.println(sb);

            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}