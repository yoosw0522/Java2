package ai1028;

import center.SetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventImage extends JFrame {
    JLabel label = new JLabel();
    String[] btnsText = {"에스파", "아이브", "리센느"};
    ImageIcon[] imageIcons = new ImageIcon[btnsText.length];

    public MouseEventImage() {
        JPanel panel = new JPanel();
        JButton[] btns = new JButton[btnsText.length];

        for (int i = 0; i < btnsText.length; i++) {
            imageIcons[i] = new ImageIcon("imgs/img" + i + ".jpg");
        }

        for (int i = 0; i < btnsText.length; i++) {
            btns[i] = new JButton(btnsText[i]);
            btns[i].addMouseListener(btnListener);
            panel.add(btns[i]);
        }

        add("North", panel);
        add("Center", label);
        label.setBackground(Color.WHITE);

        int w = 800, h = 450;
        SetFrame.setFrame(this, "버튼에 따른 이미지 변경", w, h);
    }

    MouseListener btnListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton eBtn = (JButton) e.getSource();
            ImageIcon imageIcon = null;

            switch (eBtn.getText()) {
                case "에스파":
                    imageIcon = imageIcons[0];
                    break;
                case "아이브":
                    imageIcon = imageIcons[1];
                    break;
                case "리센느":
                    imageIcon = imageIcons[2];
                    break;
            }

            label.setIcon(imageIcon);
        }
    };

    public static void main(String[] args) {
        new MouseEventImage();
    }
}