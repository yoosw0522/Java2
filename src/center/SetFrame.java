package center;

import javax.swing.*;
import java.awt.*;

public class SetFrame {

    public static void setFrame(JFrame frame, String title, int w, int h){
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Point point = CenterFrame2.getLocation(w, h);
        frame.setBounds(point.x, point.y, w, h);
        frame.setVisible(true);
    }

}