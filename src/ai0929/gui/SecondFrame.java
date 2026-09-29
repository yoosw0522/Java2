package ai0929.gui;

import javax.swing.*;
import java.awt.*;

public class SecondFrame extends JFrame {
    public  SecondFrame(){
        setLayout(new FlowLayout());
        setTitle("두번째 만든 윈도우창");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbl1 = new JLabel("오늘은 화요일입니다.");
        add(lbl1);
        JLabel lbl2 = new JLabel("한국폴리텍대학 인공지능소프트웨어과");
        Font font = new Font("맑은 고딕",Font.BOLD,25);
        lbl2.setFont(font);
        lbl2.setForeground(Color.magenta);
        add(lbl2);

        JLabel lbl3 = new JLabel("1학년 재학중");
        font = new Font("궁서",Font.BOLD+Font.ITALIC,20);
        lbl3.setFont(font);
        lbl3.setForeground(Color.green);
        lbl3.setOpaque(true);
        lbl3.setBackground(Color.BLACK);
        add(lbl3);



        setSize(500,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SecondFrame();
    }
}