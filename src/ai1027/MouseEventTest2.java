package ai1027;

import center.SetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventTest2 extends JFrame {
    JLabel lbl = new JLabel("입력 전...");

    public MouseEventTest2() {
        JPanel panel = new JPanel();
        JButton btnRed = new JButton("Red");
        JButton btnGreen = new JButton("Green");
        JButton btnBlue = new JButton("Blue");
        lbl.setOpaque(true);

        panel.add(btnRed);
        panel.add(btnGreen);
        panel.add(btnBlue);

        add(panel);
        add("South", lbl);

        btnRed.addMouseListener(btnMouseListener);
        btnGreen.addMouseListener(btnMouseListener);
        btnBlue.addMouseListener(btnMouseListener);

        SetFrame.setFrame(this, "MouseEvent Programming", 300, 300);
    }

    MouseListener btnMouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("마우스가 버튼을 클릭함.");
            lbl.setText("마우스가 버튼을 클릭함.");

            Color color = null;

            JButton ebtn = (JButton) e.getSource();

            if (ebtn.getText().equals("Red")) {
                color = Color.RED;
            } else if (ebtn.getText().equals("Green")) {
                color = Color.GREEN;
            } else {
                color = Color.BLUE;
            }

            lbl.setBackground(color);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("마우스가 버튼을 누름.");
            lbl.setText("마우스가 버튼을 누름.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("마우스가 버튼을 눌렀다 해제함.");
            lbl.setText("마우스가 버튼을 눌렀다 해제함.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("마우스가 버튼에 들어옴.");
            lbl.setText("마우스가 버튼에 들어옴.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("마우스가 버튼을 벗어남.");
            lbl.setText("마우스가 버튼을 벗어남.");
        }
    };

    public static void main(String[] args) {
        new MouseEventTest2();
    }
}