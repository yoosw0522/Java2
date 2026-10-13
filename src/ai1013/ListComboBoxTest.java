package ai1013;

import center.CenterFrame;

import javax.swing.*;
import java.awt.*;

public class ListComboBoxTest extends JFrame {

    public ListComboBoxTest() {
        setTitle("문자열 입력 컴포넌트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        String[] items = {"강아지", "고양이", "토끼", "미어캣", "고릴라"};

        JList list = new JList(items);
        JComboBox comboBox = new JComboBox(items);

        add(comboBox);
        add(list);

        int w=250, h=250;
        int[] locations = CenterFrame.getLocation(w, h);
        setBounds(locations[0], locations[1], w, h);//setLocation(x,y) + setSize(w, h)
        setVisible(true);
    }

    public static void main(String[] args) {
        new ListComboBoxTest();
    }
}