package ai0922;

import java.io.*;

public class LAB_FileCopyAndPaste {
    public static void main(String[] args) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader("myData1.txt"));
            FileWriter fw = new FileWriter("newFile.txt");

            String line = "";

//            while (true) {
//                line = br.readLine();
//                if (line == null) {
//                    break;
//                }
//                sb.append(line).append("\n");
//            }
//
//            fw.write(sb.toString());

            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                fw.write(line + "\n");
            }

            br.close();
            fw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}