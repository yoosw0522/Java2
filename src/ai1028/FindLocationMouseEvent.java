package ai1028;

import center.SetFrame;

import javax.swing.*;
import java.awt.event.*;

public class FindLocationMouseEvent extends JFrame {
    JTextField textFieldX, textFieldY;
    public FindLocationMouseEvent() {
        JPanel panel = new JPanel();
        textFieldX = new JTextField(5);
        textFieldY = new JTextField(5);

        panel.add(textFieldX);
        panel.add(textFieldY);
        add("South", panel);

        addMouseListener(frameListener);
        addMouseMotionListener(frameMotionListener);

        int w = 500, h = 500;
        SetFrame.setFrame(this, "마우스 커서 위치 추적", w, h);
    }

    MouseListener frameListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            textFieldX.setText(Integer.toString(e.getX()));
            textFieldY.setText(e.getY() + "");
        }
    };

    MouseMotionListener frameMotionListener = new MouseMotionAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
            textFieldX.setText(Integer.toString(e.getX()));
            textFieldY.setText(e.getY() + "");
        }
    };

    public static void main(String[] args) {
        new FindLocationMouseEvent();
    }
}