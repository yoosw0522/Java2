
package ai1027;

import center.CenterFrame2;
import center.SetFrame;

import javax.swing.*;
import java.awt.*;

public class GridTest extends JFrame {

    public GridTest() {
        int rows = 3, cols = 4;

        setLayout(new GridLayout(rows, cols, 10, 10));

        for (int i = 0; i < rows * cols; i++) {
            JButton btn = new JButton("버튼 " + (i + 1));
            add(btn);
        }

        SetFrame.setFrame(this, "GridLayout 연습", 350, 300);
    }

    public static void main(String[] args) {
        new GridTest();
    }
}
