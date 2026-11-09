package ai1028;

import center.SetFrame;

import javax.swing.*;

public class GraphicTest extends JFrame {
    public GraphicTest() {
        GraphicPanel graphicPanel = new GraphicPanel();

        add(graphicPanel);

        int w = 500, h = 500;
        SetFrame.setFrame(this, "그리기 연습", w, h);
    }

    public static void main(String[] args) {
        new GraphicTest();
    }
}