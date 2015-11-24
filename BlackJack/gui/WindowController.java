package gui;

import Games.*;
import backend.Table;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bjc90_000 on 11/6/2015.
 */
public class WindowController {


    // how to get the main menu to talk?????????


    MainMenu mainMenu;
    JFrame mainFrame;
    JFrame tutorialSelect;
    JPanel selectionPanel;
    JButton basic, strats, extras;
    Table table;
    PlayGUI playGui;
    BJGame playBJGame;
    Basics basics;
    Strategies strat;
    StatsAndBJ stats;
    // other GCs go here
    //

    public static boolean showMenu = false, showPlayGUI = false ,playTutoial = false, playGame = false;

    // height and width of playGUI
    private int height, width;

    public WindowController(Table table, BJGame playBJGame, Basics basics, Strategies strat, StatsAndBJ stats) {

        this.table = table;
        getScreenSize();
        this.playBJGame = playBJGame;
        this.basics=basics;
        this.strat = strat;
        this.stats = stats;
        mainMenu = new MainMenu(table);
        playGui = new PlayGUI(playBJGame, width, height);
        hidePlayGUI();
        new MenuListener().run();
    }

    private void getScreenSize() {
        // Get Dimension of Screen Size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Width is 2/3 of the screen size, height is full height of screen size
        // width = (screenSize.width/3)*2;
        width = screenSize.width;
        height = screenSize.height;
    }

    public void showMainMenu() {
        mainMenu.setVisible(true);
    }

    private void showPlayGUI() {
        playGui.showFrame();
    }

    private void hideMainMenu() {
        mainMenu.setVisible(false);
    }

    private void hidePlayGUI() {
        playGui.hideFrame();
    }

    private void switchGC(GameCoordinator gc) {
        playGui.setGC(gc);
    }


    private class MenuListener extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (WindowController.showMenu) {
                    showMainMenu();
                    hidePlayGUI();
                    showMenu=false;
                }
                if (WindowController.showPlayGUI) {
                    showPlayGUI();
                    hideMainMenu();
                    showPlayGUI=false;
                }
                if (WindowController.playGame){
                    switchGC(playBJGame);
                    showPlayGUI();
                    hideMainMenu();
                    showPlayGUI=false;
                    playGame=false;
                }
                if(WindowController.playTutoial){
                	                		
	                    tutorialSelect = new JFrame();
	                    tutorialSelect.setSize(200, 120);
	                    tutorialSelect.setLocationRelativeTo(null);
	                    tutorialSelect.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                    tutorialSelect.setAlwaysOnTop(true);
	                    
	                    selectionPanel = new JPanel();
	                    selectionPanel.setLayout(new BorderLayout());
	                    
	                    basic = new JButton("Basics");
	                    basic.addActionListener(new buttonListener());
	                    
	                    strats = new JButton("Strategies");
	                    strats.addActionListener(new buttonListener());
	                    
	                    extras = new JButton("BlackJack and Stats");
	                    extras.addActionListener(new buttonListener());
	                    
	                    selectionPanel.add(basic, BorderLayout.NORTH);
	                    selectionPanel.add(strats, BorderLayout.CENTER);
	                    selectionPanel.add(extras, BorderLayout.SOUTH);
	                    
	                    tutorialSelect.add(selectionPanel);
	                    
	                    tutorialSelect.setVisible(true);

	                    playTutoial= false;
                    
                    /*switchGC(basics);
                    showPlayGUI();
                    hideMainMenu();
                    showPlayGUI=false;
                    playTutoial= false;*/
                }
            }
        }

    }
    


	private class buttonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource().equals(basic))
			{
				switchGC(basics);
                showPlayGUI();
                hideMainMenu();
                showPlayGUI=false;
                
                tutorialSelect.dispose();
			}
			
			if(e.getSource().equals(strats))
			{   
				switchGC(strat);
                showPlayGUI();
                hideMainMenu();
                showPlayGUI=false;
                
                tutorialSelect.dispose();
			}
			

			if(e.getSource().equals(extras))
			{     
				switchGC(stats);
                showPlayGUI();
                hideMainMenu();
                showPlayGUI=false;
                
                tutorialSelect.dispose();
			}
		}	
	}


}
