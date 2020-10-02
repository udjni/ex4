package sample;

import javax.swing.*;

public class SwingConsole {
    /* this class created for get rid of redundant code */
    public static void run(final JFrame frame, final int width, final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setTitle(frame.getClass().getSimpleName());
                frame.setSize(width, height);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}