package gui;

import Games.*;

import backend.Table;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Created by Frank on 10/27/2015.
 */
public class PlayGUI extends JComponent implements ActionListener {

    // Global Green Color
    private static final Color BOX_GREEN = new Color(37, 168, 42);
    // Global Yellow Border
    private static final Border YELLOW_BORDER = BorderFactory.createLineBorder(Color.YELLOW, 7);

    // Format money
    private DecimalFormat df = new DecimalFormat("#.00");

    // user's bank amount (temporarily hard coded)
    private double userBank = 1000;

    // Pieces for GUI
    private JFrame f;
    private Container content;
    private JPanel centerStage, centerInner, tableBottom;
    private JButton hit, stand, twentyFive, ten, five;
    private JLabel temporaryGameStateLabel;

    Games.GameCoordinator gc;

    // PaintImages array list for initial drawn cards
    ArrayList<PaintImages> paintImages;

    /*
    Constructor sets up GUI and initial coordinate variables
     */
    public PlayGUI(GameCoordinator gc) {
        // array list for initial draw
        paintImages = new ArrayList<>();
        // create GUI
        f = new JFrame();
        f.setSize(WIDTH, HEIGHT);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                WindowController.showMenu = true;
            }
        });
        content = f.getContentPane();
        changeContent();
        // create new Game Coordinator and pass this instance
        // of the GUI and the table (t)
        this.gc = gc;
        gc.execute();
        new UpdateListener().start();
        temporaryGameStateLabel= new JLabel("");centerStage.add(temporaryGameStateLabel, BorderLayout.EAST);
        f.setVisible(true);


    }

    private class UpdateListener extends Thread {

        @Override
        public void run() {
            while (true) try {
                Thread.sleep(1);

                while (f.isVisible()) {
                    Thread.sleep(50);
                    GCUpdate update = gc.update();
                    if (update!=null) {
                        update(update.getPlayerCards());
                        temporaryGameStateLabel.setText(update.getGameState());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    /*
    reset()
        resets all incrementors and lists.
     */
    public void reset() {
        paintImages.clear();
    }

    /*
    update()
        receives paintImgaes from GameCoordinator to print all cards.
     */
    public void update(ArrayList<PaintImages> images) {
        paintImages = images;
        tableBottom.repaint();
    }

    public void applyUIStyle(JPanel panel) {
        panel.setOpaque(true);
        panel.setBackground(BOX_GREEN);
        panel.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    /*
    actionPerformed()
        Handles button presses
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hit) {
            System.out.println("HIT");
            gc.requestHit();
        }

        if (e.getSource() == stand) {
            System.out.println("STAND");
            gc.requestStand();
        }

        if (e.getSource() == twentyFive) {
            System.out.println("$25");
            if (gc.getCanBet()) {
                if (!gc.placeBet(25)) {
                    System.out.println("Bet Not Placed insufficient Funds");
                }
            }
            gc.setCanBet(false);

        }

        if (e.getSource() == ten) {
            System.out.println("$10");
            if (gc.getCanBet()) {
                if (!gc.placeBet(10)) {
                    System.out.println("Bet Not Placed insufficient Funds");
                }
            }
            gc.setCanBet(false);
        }

        if (e.getSource() == five) {
            System.out.println("$5");
            if (gc.getCanBet()) {
                if (!gc.placeBet(5)) {
                    System.out.println("Bet Not Placed insufficient Funds");
                }
            }
            gc.setCanBet(false);
        }
    }

// TESTING HOW MANY TIMES PAINT IS CALLED
int inc;

    /*
    changeContent()
        Performs all the panels that make up the GUI\
        This function also contains the paintComponent as
        an inner class of the JPanel tableBottom
     */
    private void changeContent() {
        // set layout of cotent container
        content.setLayout(new BorderLayout());

        // add center stage to center of content border layout
        centerStage = new JPanel(new BorderLayout());
        centerInner = new JPanel(new BorderLayout());
        centerStage.add(centerInner, BorderLayout.CENTER);

        // add tool bar to center stage
        centerInner.add(getMenuBar_(), BorderLayout.NORTH);

        // add another panel to centerInner
        // contains the paintComponent method
        tableBottom = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Print the initial draw cards
                if (!paintImages.isEmpty()) {
                    for (PaintImages temp : paintImages) {
                        g.drawImage(temp.getImage(), temp.getX(), temp.getY(), this);
                    }
                }
            }
        };
        tableBottom.setLayout(null);
        centerInner.add(tableBottom, BorderLayout.CENTER);

        // add right bar to east of content border layout
        JPanel rightStage = new JPanel(new BorderLayout());
        rightStage.setBorder(YELLOW_BORDER);

        // create JPanels to make up rightStage
        JPanel money = getMoneyPanel();
        JPanel actions = getActionPanel();
        JPanel stats = getStatsPanel();

        // add panels to right stage
        rightStage.add(money, BorderLayout.NORTH);
        rightStage.add(actions, BorderLayout.CENTER);
        rightStage.add(stats, BorderLayout.SOUTH);

        // add panel that holds panels that hold player names and bets
        JPanel playerPanel = getPlayerPanel();
        centerStage.add(playerPanel, BorderLayout.SOUTH);

        content.add(rightStage, BorderLayout.EAST);
        content.add(centerStage, BorderLayout.CENTER);
    }

    /*
    getPlayerPanel()
        Adds player panel to bottom of GUI
     */
    private JPanel getPlayerPanel() {
        JPanel playerPanel = new JPanel(new GridLayout(1, 0));
        playerPanel.add(createNewPlayer("Player 1"));
        playerPanel.add(createNewPlayer("Player 2"));
        playerPanel.add(createNewPlayer("Player 3"));
        playerPanel.add(createNewPlayer("Player 4"));
        return playerPanel;
    }

    /*
    createNewPlayer()
        Does... something? Idk.
     */
    private JPanel createNewPlayer(String nombre) {
        JPanel p = new JPanel(new BorderLayout());
        JLabel name = new JLabel(nombre, SwingConstants.CENTER);
        JLabel bet = new JLabel("0", SwingConstants.CENTER);
        p.add(name, BorderLayout.NORTH);
        p.add(bet, BorderLayout.SOUTH);
        applyUIStyle(p);
        return p;
    }

    /*
    getMenuBar_()
        creates the menu bar for GUI
     */
    private JMenuBar getMenuBar_() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();
        menu = new JMenu("Menu Bar");
        menuBar.add(menu);
        menuItem = new JMenuItem("Menu");
        menu.add(menuItem);
        menuItem = new JMenuItem("Quit");
        menu.add(menuItem);
        return menuBar;
    }

    /*
    getStatsPanel()
        creates the state panel at right of GUI
     */
    private JPanel getStatsPanel() {
        JPanel stats = new JPanel();
        stats.setPreferredSize(new Dimension(250, 300));
        stats.setBackground(BOX_GREEN);
        stats.setBorder(BorderFactory.createRaisedBevelBorder());
        return stats;
    }

    /*
    getActionPanel()
        creates the action panel at right of GUI
        holds the action buttons
     */
    private JPanel getActionPanel() {
        JPanel actions = new JPanel(new GridLayout(3, 1));
        Dimension actionDimension = new Dimension(100, 50);
        Insets actionInsets = new Insets(0, 0, 0, 0);
        Font actionFont = new Font("Arial", Font.BOLD, 20);
        actions.setPreferredSize(new Dimension(250, 300));
        actions.setBackground(BOX_GREEN);
        actions.setBorder(BorderFactory.createRaisedBevelBorder());
        // add buttons
        JPanel hitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        hitPanel.setBackground(BOX_GREEN);
        JPanel standPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        standPanel.setBackground(BOX_GREEN);
        hit = new JButton("HIT");
        hit.setBackground(Color.YELLOW);
        hit.setFont(actionFont);
        hit.setMargin(actionInsets);
        hit.setPreferredSize(actionDimension);
        hit.addActionListener(this);

        stand = new JButton("STAND");
        stand.setBackground(Color.YELLOW);
        stand.setFont(actionFont);
        stand.setMargin(actionInsets);
        stand.setPreferredSize(actionDimension);
        stand.addActionListener(this);

        hitPanel.add(hit);
        standPanel.add(stand);
        actions.add(hitPanel);
        actions.add(standPanel);
        return actions;
    }

    /*
    getMoneyPanel()
        creates the money panel at right of GUI
        holds the betting buttons and the bank amount
     */
    private JPanel getMoneyPanel() {
        // create JPanels to make up rightStage
        JPanel money = new JPanel(new GridLayout(3, 1));
        money.setPreferredSize(new Dimension(250, 200));
        money.setBackground(BOX_GREEN);
        money.setBorder(BorderFactory.createRaisedBevelBorder());

        // add bank title
        JLabel totalBankTitle = new JLabel("Total Bank:");
        totalBankTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        totalBankTitle.setHorizontalAlignment(JLabel.CENTER);
        money.add(totalBankTitle);

        // add money
        JLabel bankAmt = new JLabel();
        bankAmt.setText(String.valueOf(df.format(userBank)));
        bankAmt.setFont(new Font("Serif", Font.BOLD, 25));
        bankAmt.setHorizontalAlignment(JLabel.CENTER);
        money.add(bankAmt);

        // add buttons
        Dimension d = new Dimension(57, 57);
        Insets i = new Insets(0, 0, 0, 0);

        five = new JButton("$5");
        five.addActionListener(this);
        five.setBackground(Color.YELLOW);
        five.setFont(new Font("Arial", Font.BOLD, 17));
        five.setMargin(i);
        five.setPreferredSize(d);

        ten = new JButton("$10");
        ten.addActionListener(this);
        ten.setBackground(Color.YELLOW);
        ten.setFont(new Font("Arial", Font.BOLD, 17));
        ten.setMargin(i);
        ten.setPreferredSize(d);

        twentyFive = new JButton("$25");
        twentyFive.addActionListener(this);
        twentyFive.setBackground(Color.YELLOW);
        twentyFive.setFont(new Font("Arial", Font.BOLD, 17));
        twentyFive.setMargin(i);
        twentyFive.setPreferredSize(d);

        JPanel buttonPanel = new JPanel(new FlowLayout(1, 10, 10));
        buttonPanel.setBackground(BOX_GREEN);
        buttonPanel.add(five);
        buttonPanel.add(ten);
        buttonPanel.add(twentyFive);
        money.add(buttonPanel);
        return money;
    }

    public void setGC(Games.GameCoordinator GC) {
        // need to eliminate the GameCoordinator in the gui folder

        // then this code can be implemented

        //gc = GC;
    }

    public void hideFrame() {
        f.setVisible(false);
    }

    public void showFrame() {
        f.setVisible(true);
    }

    // TODO: the panels that hold player names (e.g. "Player 4")
    // and betting amounts could be their own class for better
    // maintainability.
    // private class player /* Needs better name! */ extends JPanel{
    // }

}
