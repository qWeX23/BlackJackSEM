package Games;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import backend.Table;

import javax.swing.*;

/**
 * Created by bjc90_000 on 11/14/2015.
 */
public class StatsAndBJ extends GameCoordinator {

	private ArrayList<String> Instructions;
	private int listIndex;
	
	private JFrame testWindow;
    private JTextArea textArea;
    private JPanel instructionPanel;
    private JButton nextButton, closeButton;
    
	private Scanner scan;
	
	boolean done = true;
	
    public StatsAndBJ(Table table){
		
        this.reset();
        this.table=table;
    }

	private class buttonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource().equals(closeButton))
			{
				flagUpdate();
				testWindow.dispose();
				listIndex = 0;
				done = true;
			}
			
			if(e.getSource().equals(nextButton))
			{
				readFile();
				instructionPanel.remove(nextButton);
				instructionPanel.add(closeButton, BorderLayout.SOUTH);
			}
		}	
	}
	
	private void readFile()
	{
		scan = null;
		textArea.setText("");
		
		try 
		{
			scan = new Scanner(new File(Instructions.get(listIndex)));
		} 
		catch (FileNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(scan.hasNext())
		{
			textArea.append(scan.nextLine() + "\n");
		}
		
		if(listIndex < Instructions.size()-1)
			listIndex++;
		
		scan.close();
		
	}


    @Override
    protected Object doInBackground() throws Exception {
    	
    	while(done)
    	{	    	
	    	//create instructions panel
			Instructions = new ArrayList<String>();
			
			Instructions.add("StatsStep1.txt");
			Instructions.add("StatsStep2.txt");
			Instructions.add("StatsStep3.txt");
			
	        testWindow = new JFrame();
	        testWindow.setSize(550, 200);
	        testWindow.setLocationRelativeTo(null);
	        testWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        testWindow.setAlwaysOnTop(true);
	        
	        instructionPanel = new JPanel();
	        instructionPanel.setLayout(new BorderLayout());
	        textArea = new JTextArea(20,60);
	        textArea.setText("Place a bet in the top right to start the tutorial");
	        textArea.setEditable(false);
	        closeButton = new JButton("Close");
	        nextButton = new JButton("Next");
	
	        closeButton.addActionListener(new buttonListener());
	        nextButton.addActionListener(new buttonListener());
	        
	        instructionPanel.add(new JLabel("Stats and BlackJack Tutorial"), BorderLayout.NORTH);
	        instructionPanel.add(textArea, BorderLayout.CENTER);
	        
	        testWindow.add(instructionPanel);
	        testWindow.setVisible(true);
	        
	        done = false;
	        
	        //reset board
	        table.hardReset();
	        this.reset();
	        
	        // ""place bet"" to continue
	        canBet = true;
	        flagUpdate();
	        while (canBet) Thread.sleep(10);
	        testWindow.setVisible(true);
	        flagUpdate();
	
	        //set starting hands
	        table.getPlayer().takeCard(table.getDeck().getSpecificCard(13));//Ace of diamonds to player
	        table.getPlayer().takeCard(table.getDeck().getSpecificCard(37));//Queen of clubs to player
	        table.getDealer().takeCard(table.getDeck().getSpecificCard(25));//King of diamonds to dealer
	        table.getDealer().takeCard(table.getDeck().getSpecificCard(19));//7 of diamonds to dealer
	        flagUpdate();
	        readFile();
	
	        while (!wantsStand)Thread.sleep(10);
	        testWindow.setVisible(true);
	        wantsStand=false;
	        flagUpdate();
	        readFile();
	        
	        setDealerReveal(true);
	
	        instructionPanel.add(nextButton, BorderLayout.SOUTH);
	        while(!done)
	        {
	        	Thread.sleep(10);
		        testWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        }
		}

        return null;
    }
}
