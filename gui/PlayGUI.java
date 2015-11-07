package gui;

import backend.Table;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Created by Frank on 10/27/2015.
 */
public class PlayGUI extends JComponent implements ActionListener{

	// Global Green Color
	private static final Color BOX_GREEN = new Color(37, 168, 42);
	// Global Yellow Border
	private static final Border YELLOW_BORDER = BorderFactory.createLineBorder(Color.YELLOW, 7);

	// Dealer Coordinates
	private static int DEALER_X = 400;
	private static int DEALER_Y = 100;

	// Hardcoded screen width until I can come up with a better
	// way to do it     - Frank P
	private static int PLAYER_SEPARATION = 1060;

	// Format money
	private DecimalFormat df = new DecimalFormat("#.00");

	// user's bank amount (temporarily hard coded)
	private double userBank = 1000;

	// Pieces for GUI
	private JFrame f;
	private Container content;
	private JPanel  centerStage, centerInner, tableBottom;
	private JButton hit, stand, twentyFive, ten, five;

	GameCoordinator gc;

	// players card positions set dynamically
	int x, y;

	// increments used for finding coordinates using multiplication
	int c, k;
	int one, two, three, four, dealer;

	// PaintImages array list for drawn cards.
	ArrayList<PaintImages> extraCards;
	// PaintImages array list for initial drawn cards
	ArrayList<PaintImages> paintImages;

	/*
	Constructor sets up GUI and initial coordinate variables
	 */
	public PlayGUI(Table t){
		// handles increments/multiplication for coordinate algorithm for extra cards
		one = 0; two = 0; three = 0; four = 0; dealer = 0;
		// coordinate variables for cards
		x = 0; y = 0;
		// handles increments/multiplication for coordinate algorithm for initial draw
		c = 0; k = 0;
		// array list for initial draw
		paintImages = new ArrayList<>();
		// array list for new draws.
		extraCards = new ArrayList<>();
		// create GUI
		f = new JFrame();
		f.setSize(WIDTH, HEIGHT);
		f.setExtendedState(JFrame.NORMAL);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = f.getContentPane();
		changeContent();
		// create new Game Coordinator and pass this instance
		// of the GUI and the table (t)
		gc = new GameCoordinator(t, this);
		gc.execute();
		f.setVisible(true);
	}

	/*
	reset()
		resets all incrementors and lists.
	 */
	public void reset() {
		one = 0; two = 0; three = 0; four = 0; dealer = 0;
		x = 0; c = 0; k = 0;
		paintImages.clear();
		extraCards.clear();
	}

	/*
	updatePlayer()
		recieves the player number (1-4, 5 for dealer) and an ImageIcon
		creates new PaintImage of the newly drawn card from the hit and adds
		it to the extraCards array list
	 */
	public void updatePlayer (int player, ImageIcon i) {
		y = 500;
		if (player == 1) {
			one++;
			x = (PLAYER_SEPARATION / 4) * 0 + 70 + (40 * one);
			extraCards.add(new PaintImages(x, y, i));
		}

		if (player == 2) {
			two++;
			x = (PLAYER_SEPARATION / 4) * 1 + 70 + (40 * two);
			extraCards.add(new PaintImages(x, y, i));
		}

		if (player == 3) {
			three++;
			x = (PLAYER_SEPARATION / 4) * 2 + 70 + (40 * three);
			extraCards.add(new PaintImages(x, y, i));
		}

		if (player == 4) {
			four++;
			x = (PLAYER_SEPARATION / 4) * 3 + 70 + (40 * four);
			extraCards.add(new PaintImages(x, y, i));
		}

		if (player == 5) {
			dealer++;
			paintImages.add(new PaintImages((DEALER_X + 70) + (40 * dealer), DEALER_Y, i));
		}

		tableBottom.repaint();
	}

	/*
	updateInit()
		takes in the number of players playing and an array list of sorted Image Icons
		they are sorted by the FirstDrawCollector class within the GameCoordinator
		creates PaintImages for each card in the initial draw and adds them to the
		paintImages array List.
	 */
	public void updateInit(int numOfPlayers, ArrayList<ImageIcon> cardImageIcons) {
		// this will take the array list of card image icons
		for (ImageIcon temp:cardImageIcons) {
			y = 500;
			// first card for the 4 players
			if (c < numOfPlayers) {
				x = (PLAYER_SEPARATION / 4) * c + 30;
				paintImages.add(new PaintImages(x, y, temp));
				c++;
			// dealers first card
			} else if (c == numOfPlayers) {
				paintImages.add(new PaintImages(DEALER_X, DEALER_Y, temp));
				c++;
			// second card for the 4 players
			} else if (k < numOfPlayers) {
				x = (PLAYER_SEPARATION / 4) * k + 70;
				paintImages.add(new PaintImages(x, y, temp));
				k++;
			}
			// dealers second card
			else if (k == numOfPlayers) {
				paintImages.add(new PaintImages(DEALER_X + 70, DEALER_Y, temp));
			}
		}
		// calls paint located in createContent method
		tableBottom.repaint();
	}

	public void applyUIStyle(JPanel panel){
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
			if(gc.getCanBet()){
				if(!gc.placeBet(25)){
					System.out.println("Bet Not Placed insufficient Funds");
				}
			}
			gc.setCanBet(false);

		}

		if (e.getSource() == ten) {
			System.out.println("$10");
			if(gc.getCanBet()){
				if(!gc.placeBet(10)){
					System.out.println("Bet Not Placed insufficient Funds");
				}
			}
			gc.setCanBet(false);
		}

		if (e.getSource() == five) {
			System.out.println("$5");
			if(gc.getCanBet()){
				if(!gc.placeBet(5)){
					System.out.println("Bet Not Placed insufficient Funds");
				}
			}
			gc.setCanBet(false);
		}
	}

	/*
	changeContent()
		Performs all the panels that make up the GUI
	 */
	private void changeContent(){
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

				//System.out.println("paint Images list is " + !paintImages.isEmpty());
				if (!paintImages.isEmpty()) {
					for (PaintImages temp : paintImages) {
						g.drawImage(temp.getImage(), temp.getX(), temp.getY(), this);
					}
				}
				//System.out.println("extra Cards list is " + !extraCards.isEmpty());
				if (!extraCards.isEmpty()) {
					for (PaintImages temp1 : extraCards) {
						g.drawImage(temp1.getImage(), temp1.getX(), temp1.getY(), this);
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
	private JPanel getPlayerPanel(){
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
	private JPanel createNewPlayer(String nombre){
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

	/*
	getMoneyPanel()
		creates the money panel at right of GUI
		holds the betting buttons and the bank amount
	 */
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

	public void setGC(Games.GameCoordinator GC) {
		// need to eliminate the GameCoordinator in the gui folder

		// then this code can be implemented

		//gc = GC;
	}

	// TODO: the panels that hold player names (e.g. "Player 4")
	// and betting amounts could be their own class for better
	// maintainability.
	// private class player /* Needs better name! */ extends JPanel{
	// }

}
