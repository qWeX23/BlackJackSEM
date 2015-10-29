package gui;

import backend.Table;

/**
 * Created by bjc90_000 on 10/29/2015.
 */
public class GameCoordinator {


    Table table;
    Boolean wantsHit, wantsStand,dealerWins=false,playerWins=false,winnerDetermined=false,endGame=false,GUIUpdated=false;

    public GameCoordinator(Table table){
        this.table=table;
    }


    public synchronized void requestHit(){

        wantsHit = true;

    }
    public synchronized void requestStand(){

        wantsStand = true;

    }

    public synchronized void playBlackJack(){



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


    }


}
