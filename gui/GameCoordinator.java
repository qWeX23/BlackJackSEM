package gui;

import backend.FirstDrawCollector;
import backend.Table;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by bjc90_000 on 10/29/2015.
 */
public class GameCoordinator extends SwingWorker<Boolean, Boolean> {

    FirstDrawCollector mainCollector;
    Table table;
<<<<<<< HEAD
    Boolean wantsHit, wantsStand, dealerWins = false, playerWins = false, winnerDetermined = false, endGame = false, GUIUpdated = false, startGame;
    boolean canBet =true;
=======
    Boolean wantsHit, wantsStand,dealerWins=false,playerWins=false,winnerDetermined=false,endGame=false,GUIUpdated=false,startGame;
>>>>>>> 277f6f82b19beee0b34c4b428d3eefcc6297b760
    PlayGUI mainGUI;

    public GameCoordinator(Table table, PlayGUI mainGUI){
        // create FirstDrawColletor class to collect draws
        mainCollector = table.getMainCollector();
        this.table=table;
        this.mainGUI = mainGUI;
        System.out.println("GAME COORDINATOR ONLINE");
    }


    @Override
    protected Boolean doInBackground() throws Exception {
      //  while(!startGame);
       // this.wait();
        while(!endGame) {
            System.out.println("playing game");

            System.out.println("Place Bet...");

            while(canBet)//System.out.println("doing nothing waiting for the bet");

            //Deal Cards to Dealer and Player
            table.reset();
            this.reset();
            System.out.println("INITiAL DEAL \n"+table.toString());




            //signalGUI update
            //Players Turn
            System.out.println("YOUR TURN \n"+table.toString());
            while (!wantsStand && !table.playerisBust()) {
                //System.out.println("Stuck Waiting for stand");

                if (wantsHit) {
                    table.playerHIt();
                    wantsHit = false;
                    System.out.println("YOUR TURN \n"+table.toString());

                    // adds the newly drawn card invoked by hit to the GUI
                    // the number 1 is the player number hard coded for the time being.
                    mainGUI.updatePlayer(1, mainCollector.getTopCard());
                }
            }
            //Dealer's Turn
            if (!table.playerisBust()) {
                table.dealersTurn();
                System.out.println("DEALER TURN \n"+table.toString());

            } else {
                System.out.println("DEALER WINS by player bustl");
                dealerWins = true;
                winnerDetermined = true;
            }
            //Determine Winner
            if (table.dealerisBust()) {
                System.out.println("PLAYER WINS by dealer bust");

                playerWins = true;

            } else if (!table.playerisBust() && !table.dealerisBust()) {
                if (table.playerHandPower() > table.deartHandPower()) {
                    playerWins = true;
                    System.out.println("PLAYER WINS by larger hand");
                } else {
                    System.out.println("DEALER WINS by larger hand");
                    dealerWins = true;
                }
            }
            //wait for GUI to UpDate
//            System.out.println("stuck Waiting---- press HIT to start over");;
//            while (!wantsHit);
        }


            return true;

    }



    protected void requestHit(){

        wantsHit = true;
    }
    public synchronized void requestStand(){

        wantsStand = true;

    }

<<<<<<< HEAD
    protected void setCanBet(boolean canBet) {
        this.canBet = canBet;
    }

    private void reset() {

        dealerWins = false;
        playerWins = false;
        winnerDetermined = false;
        GUIUpdated = false;
        wantsHit = false;
        wantsStand = false;
        canBet=true;

=======
   protected void playBlackJack(){
        System.out.println("black jack is happening now");


        while(!endGame) {
            //Deal Cards to Dealer and Player
            table.reset();
            this.reset();



            //signalGUI update
            //Players Turn
            while (!wantsStand && !table.playerisBust()) {
                if (wantsHit) {
                    table.playerHIt();
                    wantsHit = false;
                }
            }
            //Dealer's Turn
            if (!table.playerisBust()) {
                table.dealersTurn();
            } else {

                dealerWins = true;
                winnerDetermined = true;
            }
            //Determine Winner
            if (table.dealerisBust()) {

                playerWins = true;

            } else if (!table.playerisBust() && !table.dealerisBust()) {
                if (table.playerHandPower() > table.deartHandPower()) {
                    playerWins = true;
                } else {
                    dealerWins = true;
                }
            }
            //wait for GUI to UpDate
            while(!GUIUpdated);


        }
>>>>>>> 277f6f82b19beee0b34c4b428d3eefcc6297b760

    }

    private void reset() {

        dealerWins=false;playerWins=false;winnerDetermined=false;GUIUpdated=false;
        wantsHit=false; wantsStand=false;
        // reset GUI
        mainGUI.reset();
        // sort the collection of images collected by FirstDrawCollector class
        mainCollector.sortList();
        // update initial draw
        mainGUI.updateInit(1, mainCollector.getList());
    }

    public GCUpdate update(){
        return new GCUpdate(table.getPlayer(),table.getDealer());
    }


    public boolean getCanBet() {
        return canBet;
    }

    public boolean placeBet(int bet) {
       return table.getPlayer().getBank().placeBet(bet);
    }
}
