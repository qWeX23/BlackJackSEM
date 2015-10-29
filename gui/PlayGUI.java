package gui;

import backend.Table;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Created by Frank on 10/27/2015.
 */
public class PlayGUI extends JFrame implements ActionListener{

	public static final Color BOX_GREEN = new Color(37, 168, 42);
	public static final Border YELLOW_BORDER = BorderFactory.createLineBorder(Color.YELLOW, 7);
	public static final int NUMBER_OF_PLAYERS = 4;

	private DecimalFormat df = new DecimalFormat("#.00");
	private double userBank = 1000;
	private JFrame f;
	private Container content;
	
	// TODO: the panels that hold player names (e.g. "Player 4")
	// and betting amounts could be their own class for better
	// maintainability.
	// private class player /* Needs better name! */ extends JPanel{
	// }

	private JPanel  centerStage, centerInner;
	private JButton hit, stand, twentyFive, ten, five;
	private JLabel p1Bet, p2Bet, p3Bet, p4Bet;


    public void update() {

    }




	public void applyUIStyle(JPanel panel){
		panel.setOpaque(true);
		panel.setBackground(BOX_GREEN);
		panel.setBorder(BorderFactory.createRaisedBevelBorder());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == hit) {
			System.out.println("HIT");
		}

		if (e.getSource() == stand) {
			System.out.println("STAND");
        }

		if (e.getSource() == twentyFive) {
			System.out.println("$25");

		}

		if (e.getSource() == ten) {
			System.out.println("$10");
		}

		if (e.getSource() == five) {
			System.out.println("$5");
		}
	}

	public PlayGUI(Table table){
		// create frame and content pane with borderLayout
		f = new JFrame();
		f.setSize(WIDTH, HEIGHT);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = f.getContentPane();
		changeContent();
		f.setVisible(true);
	}

    private void changeContent() {
        content.setLayout(new BorderLayout());

        // add center stage to center of content border layout
        centerStage = new JPanel(new BorderLayout());
        centerInner = new JPanel(new BorderLayout());
        centerStage.add(centerInner, BorderLayout.CENTER);

        // add tool bar to center stage
        centerInner.add(getMenuBar_(), BorderLayout.NORTH);

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

	private JPanel getPlayerPanel(){
		JPanel playerPanel = new JPanel(new GridLayout(1, 0));
		playerPanel.add(createNewPlayer("Player 4"));
		playerPanel.add(createNewPlayer("Player 3"));
		playerPanel.add(createNewPlayer("Player 2"));
		playerPanel.add(createNewPlayer("Player 1"));
		return playerPanel;
	}

	private JPanel createNewPlayer(String nombre){
		JPanel p = new JPanel(new BorderLayout());
		JLabel name = new JLabel(nombre, SwingConstants.CENTER);
		JLabel bet = new JLabel("0", SwingConstants.CENTER);
		p.add(name, BorderLayout.NORTH);
		p.add(bet, BorderLayout.SOUTH);
		applyUIStyle(p);
		return p;
	}

	public void addPlayerCards(){

	}
	
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

	private JPanel getStatsPanel() {
		JPanel stats = new JPanel();
		stats.setPreferredSize(new Dimension(250, 300));
		stats.setBackground(BOX_GREEN);
		stats.setBorder(BorderFactory.createRaisedBevelBorder());
		return stats;
	}

	private JPanel getActionPanel() {
		JPanel actions = new JPanel(new GridLayout(3,1));
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

	private JPanel getMoneyPanel() {
		// create JPanels to make up rightStage
		JPanel money = new JPanel(new GridLayout(3,1));
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
}
