package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Created by Frank on 10/27/2015.
 */
public class PlayGUI extends JFrame{

	private DecimalFormat df = new DecimalFormat("#.00");
	private double userBank = 1000;
	private Color boxGreen = new Color(37, 168, 42);
	private JFrame f;
	private Container content;

	private JPanel  centerStage,
					centerInner,
					rightStage,
					playerPanel;

	public static void main(String[] args) {
		PlayGUI pg = new PlayGUI();
	}

	public PlayGUI(){
		// create frame and content pane with borderLayout
		f = new JFrame();
		f.setBounds(0, 0, 900, 900);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = f.getContentPane();
		content.setLayout(new BorderLayout());

		// add center stage to center of content border layout
		centerStage = new JPanel(new BorderLayout());
		centerInner = new JPanel(new BorderLayout());
		centerStage.add(centerInner, BorderLayout.CENTER);

		// add menubar to center stage
		centerInner.add(getMenuBar_(), BorderLayout.NORTH);

		// add right bar to east of content border layout
		rightStage = new JPanel(new BorderLayout());
		rightStage.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 7));

		// create JPanels to make up rightStage
		JPanel money = getMoneyPanel();
		JPanel actions = getActionPanel();
		JPanel stats = getStatsPanel();

		// add panels to right stage
		rightStage.add(money, BorderLayout.NORTH);
		rightStage.add(actions, BorderLayout.CENTER);
		rightStage.add(stats, BorderLayout.SOUTH);

		content.add(rightStage, BorderLayout.EAST);
		content.add(centerStage, BorderLayout.CENTER);

		// create panel to hold player bets
		playerPanel = getPlayerPanel();
		centerStage.add(playerPanel, BorderLayout.SOUTH);

		f.setVisible(true);
	}

	public JPanel getPlayerPanel(){
		JPanel playerPanel = new JPanel(new GridLayout(1, 0));
		playerPanel.add(newPlayer("Player 4"));
		playerPanel.add(newPlayer("Player 3"));
		playerPanel.add(newPlayer("Player 2"));
		playerPanel.add(newPlayer("Player 1"));
		return playerPanel;
	}

	public JPanel newPlayer(String nombre){
		JPanel p = new JPanel(new BorderLayout());
		JLabel name = new JLabel(nombre, SwingConstants.CENTER);
		JLabel bet = new JLabel("0", SwingConstants.CENTER);
		p.add(name, BorderLayout.NORTH);
		p.add(bet, BorderLayout.SOUTH);
		p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		return p;
	}
	
	public JMenuBar getMenuBar_() {
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


	public JPanel getStatsPanel() {
		JPanel stats = new JPanel();
		stats.setPreferredSize(new Dimension(200, 300));
		stats.setBackground(boxGreen);
		stats.setBorder(BorderFactory.createRaisedBevelBorder());
		return stats;
	}

	public JPanel getActionPanel() {
		JPanel actions = new JPanel(new GridLayout(3,1));
		Dimension actionDimension = new Dimension(100, 50);
		Insets actionInsets = new Insets(0, 0, 0, 0);
		Font actionFont = new Font("Arial", Font.BOLD, 20);
		actions.setPreferredSize(new Dimension(200, 300));
		actions.setBackground(boxGreen);
		actions.setBorder(BorderFactory.createRaisedBevelBorder());
		// add buttons
		JPanel hitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		hitPanel.setBackground(boxGreen);
		JPanel standPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		standPanel.setBackground(boxGreen);
		JButton hit = new JButton("HIT");
		JButton stand = new JButton("STAND");
		hit.setBackground(Color.YELLOW);
		hit.setFont(actionFont);
		hit.setMargin(actionInsets);
		hit.setPreferredSize(actionDimension);
		stand.setBackground(Color.YELLOW);
		stand.setFont(actionFont);
		stand.setMargin(actionInsets);
		stand.setPreferredSize(actionDimension);

		hitPanel.add(hit);
		standPanel.add(stand);
		actions.add(hitPanel);
		actions.add(standPanel);
		return actions;
	}

	public JPanel getMoneyPanel() {
		// create JPanels to make up rightStage
		JPanel money = new JPanel(new GridLayout(3,1));
		money.setPreferredSize(new Dimension(200, 200));
		money.setBackground(boxGreen);
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
		Dimension d = new Dimension(50, 50);
		Insets i = new Insets(0, 0, 0, 0);
		JButton five = new JButton("$5");
		five.setBackground(Color.YELLOW);
		five.setFont(new Font("Arial", Font.BOLD, 17));
		five.setMargin(i);
		five.setPreferredSize(d);
		JButton ten = new JButton("$10");
		ten.setBackground(Color.YELLOW);
		ten.setFont(new Font("Arial", Font.BOLD, 17));
		ten.setMargin(i);
		ten.setPreferredSize(d);
		JButton twentyFive = new JButton("$25");
		twentyFive.setBackground(Color.YELLOW);
		twentyFive.setFont(new Font("Arial", Font.BOLD, 17));
		twentyFive.setMargin(i);
		twentyFive.setPreferredSize(d);
		JPanel buttonPanel = new JPanel(new FlowLayout(1, 10, 10));
		buttonPanel.setBackground(boxGreen);
		buttonPanel.add(five);
		buttonPanel.add(ten);
		buttonPanel.add(twentyFive);
		money.add(buttonPanel);
		return money;
	}
}