package ai1028;

import javax.swing.*;
import java.awt.*;

public class GraphicPanel extends JPanel {
    public GraphicPanel() {
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.drawLine(50, 30, 250, 30);
        g.setFont(new Font("중고딕", Font.BOLD, 30));
        g.drawString("Hi, everyone", 50, 30);
        g.drawLine(0, 0, 40, 40);
        g.setColor(Color.BLUE);
        g.fillRect(40, 40, 100, 100);
        g.setColor(Color.ORANGE);
        g.fillRect(250, 40, 200, 150);
        g.drawRect(250, 250, 200, 200);
        g.setColor(Color.MAGENTA);
        g.drawOval(250, 40, 200, 150);
        g.fillOval(250, 250, 200, 200);
        g.setColor(Color.GRAY);
        int[] xPoints = {350, 250, 450};
        int[] yPoints = {250, 450, 450};
        g.drawPolygon(xPoints, yPoints, xPoints.length);

        yPoints = new int[]{450, 250, 250};
        g.drawPolygon(xPoints, yPoints, xPoints.length);
    }
}