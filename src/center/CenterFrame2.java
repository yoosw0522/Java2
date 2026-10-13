package center;

import java.awt.*;

public class CenterFrame2 {

    public static Point getLocation(int w, int h){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSizeDim = toolkit.getScreenSize();

        int sw = screenSizeDim.width;
        int sh = screenSizeDim.height;

        int x = (sw-w)/2;
        int y = (sh-h)/2;

        Point point = new Point(x, y);

        return point;
    }
}