
package ai1027;

import center.SetFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LAB_RandomDice extends JFrame {
    public LAB_RandomDice(){
        Random random = new Random();
        int rows = random.nextInt(10) + 1;
        int cols = random.nextInt(10) + 1;
        setLayout(new GridLayout(rows, cols, 2, 2));

        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.ORANGE};
        for (int i = 0; i < rows * cols; i++) {
            int randNum = random.nextInt(6) + 1;
            JButton btn = new JButton(randNum + "");
            btn.setBackground(colors[randNum-1]);
            add(btn);
        }

        SetFrame.setFrame(this, "주사위숫자채우기", 500, 500);
    }

    public static void main(String[] args) {
        new LAB_RandomDice();
    }
}
