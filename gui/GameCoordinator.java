package gui;

import backend.Table;

import javax.swing.*;

/**
 * Created by bjc90_000 on 10/29/2015.
 */
public class GameCoordinator extends SwingWorker<Boolean, Boolean> {


    Table table;
    Boolean wantsHit, wantsStand,dealerWins=false,playerWins=false,winnerDetermined=false,endGame=false,GUIUpdated=false,startGame;

    public GameCoordinator(Table table){
        this.table=table;
        this.reset();
        System.out.println("GAME COORDINATOR ONLINE");
    }


    @Override
    protected Boolean doInBackground() throws Exception {

      //  while(!startGame);
       // this.wait();
        while(!endGame) {
            System.out.println("playing game");
            //Deal Cards to Dealer and Player
            table.reset();
            this.reset();


            //signalGUI update
            //Players Turn
            while (!wantsStand && !table.playerisBust()) {
                //System.out.println("Stuck Waiting for stand");
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
            System.out.println("stuck Waiting");;
            while (!GUIUpdated);
        }


            return true;

    }



    protected void requestHit(){

        wantsHit = true;

    }
    public synchronized void requestStand(){

        wantsStand = true;

    }

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

    }

    private void reset() {

        dealerWins=false;playerWins=false;winnerDetermined=false;GUIUpdated=false;
        wantsHit=false; wantsStand=false;


    }

    public GCUpdate update(){
        return new GCUpdate(table.getPlayer(),table.getDealer());
    }




}
