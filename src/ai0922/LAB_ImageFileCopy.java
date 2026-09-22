package ai0922;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 이미지 파일과 같은 이진 파일은 1byte씩 읽어서 1byte씩 출력해야한다.
public class LAB_ImageFileCopy {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("clock.png");
            FileOutputStream fos = new FileOutputStream("clockcopy.png");

            int data;

            while ((data = fis.read()) != -1) {
                fos.write((byte)data);
            }

            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}