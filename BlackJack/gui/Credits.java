package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.ITALIC;
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
public class Credits extends JFrame {
   
    public Credits() {
        super();
        setLayout(new BorderLayout());
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
        
        Font a = new Font("Serif", BOLD|ITALIC, 100);
        JLabel nextLabel = new JLabel("            THE TEAM:            ");
        nextLabel.setFont(a);
        nextLabel.setForeground(new Color(0, 204 ,102));
        topPanel.add(nextLabel);
        
        JLabel nextLabelA = new JLabel("Lauren Cabrera, Brandon Tran");
        nextLabelA.setFont(a);
        topPanel.add(nextLabelA);
        
        JLabel nextLabelB = new JLabel("Thomas Moore, William Martinez");
        nextLabelB.setFont(a);
        topPanel.add(nextLabelB);
        
        JLabel nextLabelC = new JLabel("Benjamin Churchill, Frank Palmasani");
        nextLabelC.setFont(a);
        topPanel.add(nextLabelC);
        
        JLabel nextLabelD = new JLabel("Lee Mills, Jennifer Boudreaux");
        nextLabelD.setFont(a);
        topPanel.add(nextLabelD);
        
        validate(); 
    }
}
