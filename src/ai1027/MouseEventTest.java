package ai1027;

import center.SetFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventTest extends JFrame {
    JLabel lbl = new JLabel("입력 전...");

    public MouseEventTest() {
        JPanel panel = new JPanel();
        JButton btn = new JButton("마우스이벤트 연습");

        panel.add(btn);
        add(panel);
        add("South", lbl);

        btn.addMouseListener(btnMouseListener);

        SetFrame.setFrame(this, "MouseEvent Programming", 300, 300);
    }

    MouseListener btnMouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("마우스가 버튼을 클릭함.");
            lbl.setText("마우스가 버튼을 클릭함.");
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
        new MouseEventTest();
    }
}