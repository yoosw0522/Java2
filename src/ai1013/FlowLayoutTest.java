package ai1013;

import center.CenterFrame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlowLayoutTest extends JFrame {

    Color[] colors = {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.BLUE
    };

    ArrayList<JButton> list = new ArrayList<JButton>(5);

    boolean flag = true;

    public FlowLayoutTest() {
        setTitle("FlowLayout 연습");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));

        for (int i = 0; i < 5; i++) {
            JButton btn = new JButton("버튼" + (i + 1));
            list.add(btn);
            add(btn);
            btn.addActionListener(btnListener);
        }

        int w = 250, h = 250;
        Point point = CenterFrame2.getLocation(w, h);
        setBounds(point.x, point.y, w, h);
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton selectedBtn = (JButton) e.getSource();

            if (flag) {
                selectedBtn.setBackground(colors[list.indexOf(selectedBtn)]);
                flag = false;
            } else {
                selectedBtn.setBackground(Color.LIGHT_GRAY);
                flag = true;
            }
        }
    };

    public static void main(String[] args) {
        new FlowLayoutTest();
    }
}