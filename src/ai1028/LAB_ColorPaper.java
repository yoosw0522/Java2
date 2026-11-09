package ai1028;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LAB_ColorPaper extends JPanel {
    int x1, y1, x2, y2;
    public LAB_ColorPaper() {
        setBackground(Color.YELLOW);
        addMouseListener(panelListener);
    }

    MouseListener panelListener = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }
    };

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.drawLine(x1, y1, x2, y2);
    }
}