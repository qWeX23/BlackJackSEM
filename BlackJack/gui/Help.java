package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Lee K. Mills
 */
public class Help extends JFrame {
   
    public Help() {
        super();
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.blue);
        add(bottomPanel, BorderLayout.PAGE_END);
        
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.white);
        topPanel.setLayout(new FlowLayout());
        add(topPanel);
        
        JLabel bottomLabel = new JLabel(new ImageIcon("happy.png"));
        bottomPanel.add(bottomLabel);
        
        JLabel nextLabel = new JLabel(new ImageIcon("Help.jpg"));
        topPanel.add(nextLabel);
        
        validate(); 
    }
}
