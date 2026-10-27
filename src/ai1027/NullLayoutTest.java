
package ai1027;

import center.SetFrame;

import javax.swing.*;

public class NullLayoutTest extends JFrame {
    public NullLayoutTest(){
        setLayout(null);

        //      컴포넌트의 x, y 좌표
        int[] pointsX = {50, 80, 110};
        int[] pointsY = {50, 80, 110};

        //      컴포넌트의 너비, 높이
        int btnW = 70, btnH = 60;

        for (int i = 0; i < pointsX.length; i++) {
            JButton btn = new JButton("버튼 " + (i+1));
            btn.setBounds(pointsX[i], pointsY[i], btnW, btnH);
            add(btn);
        }

        SetFrame.setFrame(this, "레이아웃없는 컴포넌트배치", 250, 250);
    }

    public static void main(String[] args) {
        new NullLayoutTest();
    }
}
