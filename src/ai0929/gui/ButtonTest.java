package ai0929.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest extends JFrame {
    public ButtonTest(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSizeDim = toolkit.getScreenSize();
        int sw = screenSizeDim.width;
        int sh = screenSizeDim.height;
        int w = 500;
        int h = 200;
        int x = (sw-w)/2;
        int y = (sh-h)/2;

        setLayout(new FlowLayout());
        setTitle("Button 컴포넌트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton btn = new JButton("메시지 대화상자 보이기");
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"대화상자를 선택하셨네요.");
            }
        });

        setSize(500,200);
        setLocation(x,y);
        setVisible(true);

    }
    public static void main(String[] args) {

        new ButtonTest();
    }
}