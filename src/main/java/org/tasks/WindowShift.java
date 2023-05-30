package org.tasks;

import java.awt.*;

public class WindowShift {
    public static void shiftToRight() {
        // Get the default toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Get the screen dimensions
        Dimension screenSize = toolkit.getScreenSize();

        // Calculate the new width and height for the right half
        int width = screenSize.width / 2;
        int height = screenSize.height;

        // Set the new window position and size
        Rectangle bounds = new Rectangle(width, 0, width, height);
//        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getFullScreenWindow());
//        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getFullScreenWindow().setBounds(bounds);
    }
}
