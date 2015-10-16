package gui;

import javax.swing.*;

/**
 * Created by bjc90_000 on 10/15/2015.
 */
public class MenuWindow {
    private JPanel panel1;
    private JButton playBlackJackButton;
    private JButton LERNButton;
    private JButton creditsButton;
    private JButton HALPButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MenuWindow");
        frame.setSize(500,400);
        frame.setContentPane(new MenuWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }

    public MenuWindow() {
        JFrame frame = new JFrame("MenuWindow");
        frame.setSize(500,400);
        frame.setContentPane(new MenuWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);



    }
}
