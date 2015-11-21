package gui;

import Games.*;
import backend.Bank;
import com.sun.xml.internal.bind.v2.TODO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;
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

    // bet currently on the table
    private int userBet;

    // Pieces for GUI
    private JFrame f;
    private Container content;
    private JPanel centerStage, centerInner, tableBottom;
    private JButton hit, stand, twentyFive, ten, five;
    private JLabel temporaryGameStateLabel;
    private String bankText;
    private JPanel bankPanel;
    private JLabel bankLabel;
    private JLabel statsLabel;
    private JLabel dealerStatsLabel;
    private JLabel betAmt;
    Image fiveIcon, tenIcon, twentyFiveIcon;
    private int w, h;
    private Image i;

    Games.GameCoordinator gc;
    // for the current size of the window
    Dimension d;
    // PaintImages array list for initial drawn cards
    ArrayList<PaintImages> paintImages;

    /*
    Constructor sets up GUI and initial coordinate variables
     */
    public PlayGUI(GameCoordinator gc, int width, int height) {
        // width and height for background painting
        w = width; h = height;
        // array list for initial draw
        paintImages = new ArrayList<>();
        bankText = "";
        // stats jlabel
        statsLabel = new JLabel("", SwingConstants.LEFT);
        statsLabel.setFont(new Font("Serif", Font.BOLD, 20));
        dealerStatsLabel = new JLabel("", SwingConstants.LEFT);
        dealerStatsLabel.setFont(new Font("Serif", Font.BOLD, 20));
        // create GUI
        f = new JFrame();
        f.setResizable(false);
        f.add(this);
        f.setSize(width, height);
        f.setExtendedState(JFrame.NORMAL);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                WindowController.showMenu = true;
            }
        });
        content = f.getContentPane();
        changeContent();
        f.setVisible(true);
        tableBottom.repaint();
        // create new Game Coordinator and pass this instance
        // of the GUI and the table (t)
        this.gc = gc;
        gc.execute();
        new UpdateListener().start();
        // temporary game state label
        temporaryGameStateLabel= new JLabel("", SwingConstants.CENTER);
        temporaryGameStateLabel.setFont(new Font("Serif", Font.BOLD, 20));
        centerInner.add(temporaryGameStateLabel, BorderLayout.NORTH);

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
                        // gets the current size of the window
                        d = f.getBounds().getSize();
                        update.setWidth((int)d.getWidth());
                        update.setHeight((int)d.getHeight());
                        update(update.getPlayerCards());
                        temporaryGameStateLabel.setText(update.getGameState());
                        statsLabel.setText("Probability Player Bust:  " + Double.toString(update.getProbPlayerBust()));
                        dealerStatsLabel.setText("Probability Dealer Bust:  " + Double.toString(update.getProbDealerBust()));
                        bankText = Integer.toString(Bank.getBalance());
                        bankLabel.setText(bankText);
                        betAmt.setText(Integer.toString(Bank.getCurrentBet()));
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
                System.out.println("Betting...");
                if (!Bank.placeBet(25)) {
                    System.out.println("Bet Not Placed insufficient Funds");
                }
            }
            gc.setCanBet(false);

        }

        if (e.getSource() == ten) {
            System.out.println("$10");
            if (gc.getCanBet()) {
                System.out.println("Betting...");
                if (!Bank.placeBet(10)) {
                    System.out.println("Bet Not Placed insufficient Funds");
                }
            }
            gc.setCanBet(false);
        }

        if (e.getSource() == five) {
            System.out.println("$5");
            if (gc.getCanBet()) {
                System.out.println("Betting...");
                if (!Bank.placeBet(5)) {
                    System.out.println("Bet Not Placed insufficient Funds");
                }
            }
            gc.setCanBet(false);
        }
    }

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
        // srt background image
        ImageIcon bg = new ImageIcon("poker-table-layout.jpg");
        i = bg.getImage();
        i = i.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        // add another panel to centerInner
        // contains the paintComponent method
        tableBottom = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                // positions backgound in correct place.
                g.drawImage(i, (0 - (w/8) - 10), (0 - (h/10)), this);
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
        // bottom player panel
        JPanel playerPanel = new JPanel(new GridLayout(1, 0));
        JPanel playerNamePanel = new JPanel(new BorderLayout());
        JLabel playerNameLabel = new JLabel("Player", SwingConstants.CENTER);
        playerNameLabel.setFont(new Font("Serif", Font.BOLD, 25));
        playerNamePanel.add(playerNameLabel, BorderLayout.NORTH);
        applyUIStyle(playerNamePanel);
        playerPanel.add(playerNamePanel);
        // bottom bank panelk
        bankPanel = new JPanel(new BorderLayout());
        bankLabel = new JLabel(bankText, SwingConstants.CENTER);
        bankLabel.setFont(new Font("Serif", Font.BOLD, 25));
        bankPanel.add(bankLabel, BorderLayout.NORTH);
        applyUIStyle(bankPanel);
        playerPanel.add(bankPanel);
        return playerPanel;
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
        stats.add(statsLabel);
        stats.add(dealerStatsLabel);
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
        JLabel totalBankTitle = new JLabel("Current Bet:");
        totalBankTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        totalBankTitle.setHorizontalAlignment(JLabel.CENTER);
        money.add(totalBankTitle);

        // add money
        betAmt = new JLabel("", SwingConstants.CENTER);
        betAmt.setFont(new Font("Serif", Font.BOLD, 25));
        money.add(betAmt);

        // add buttons
        Dimension d = new Dimension(57, 57);
        Insets i = new Insets(10, 10, 10, 10);
        try {
            fiveIcon = ImageIO.read(new File("chipRed_5.png"));
            fiveIcon = fiveIcon.getScaledInstance((int)d.getWidth(), (int)d.getHeight(), Image.SCALE_SMOOTH);
            tenIcon = ImageIO.read(new File("chipBlue_10.png"));
            tenIcon = tenIcon.getScaledInstance((int)d.getWidth(), (int)d.getHeight(), Image.SCALE_SMOOTH);
            twentyFiveIcon = ImageIO.read(new File("chipGreen_25.png"));
            twentyFiveIcon = twentyFiveIcon.getScaledInstance((int)d.getWidth(), (int)d.getHeight(), Image.SCALE_SMOOTH);

        } catch (IOException e) {
            e.printStackTrace();
        }
        five = new JButton(new ImageIcon(fiveIcon));
        five.setBorder(BorderFactory.createEmptyBorder());
        five.setContentAreaFilled(false);
        five.addActionListener(this);

        ten = new JButton(new ImageIcon(tenIcon));
        ten.setBorder(BorderFactory.createEmptyBorder());
        ten.setContentAreaFilled(false);
        ten.addActionListener(this);

        twentyFive = new JButton(new ImageIcon(twentyFiveIcon));
        twentyFive.setBorder(BorderFactory.createEmptyBorder());
        twentyFive.setContentAreaFilled(false);
        twentyFive.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(1, 10, 10));
        buttonPanel.setBackground(BOX_GREEN);
        buttonPanel.add(five);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
        buttonPanel.add(ten);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
        buttonPanel.add(twentyFive);
        money.add(buttonPanel);
        return money;
    }

    public void setGC(Games.GameCoordinator GC) {
        // need to eliminate the GameCoordinator in the gui folder

        // then this code can be implemented
        //gc.cancel(true);
        gc = GC;
        System.out.println("this GC has set now "+gc);
        if(!gc.getState().equals(SwingWorker.StateValue.STARTED)){
            gc.execute();
            System.out.println("this GC has started now " + gc);
        }

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





