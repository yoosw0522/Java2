package ai0929.gui;

import java.awt.*;

public class CenterFrame {
    public static Dimension getLocation(int w, int h){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSizeDim = toolkit.getScreenSize();
        int sw = screenSizeDim.width;
        int sh = screenSizeDim.height;
        int x = (sw-w)/2;
        int y = (sh-h)/2;
        int[] location = {x,y};
        //  Dimension location

        Dimension locationDim = new Dimension(x,y);

        return locationDim;
    }
}