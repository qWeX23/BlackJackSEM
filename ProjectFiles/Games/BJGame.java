package Games;

import backend.Bank;
import backend.Table;

import java.util.concurrent.locks.Lock;

/**
 * Created by bjc90_000 on 11/6/2015.
 */
public class BJGame extends GameCoordinator {

    public BJGame(Table t) {
        this.table = t;
    }


    @Override
    protected Object doInBackground() throws Exception {
        table.hardReset();
        while (!endGame) {

            System.out.println("playing game");
            //gameState="playing game";

            System.out.println("Place Bet...");
            canBet = true;
            flagUpdate();
            while (canBet) Thread.sleep(10);//System.out.println("doing nothing waiting for the bet");
            flagUpdate();


            //Deal Cards to Dealer and Player


            table.reset();
            this.reset();

            System.out.println("INITiAL DEAL \n" + table.toString());
            gameState = "Initial Deal";

            flagUpdate();
            //signalGUI update
            //Players Turn
            System.out.println("YOUR TURN \n" + table.toString());
            gameState = "Your Turn";
            while (!wantsStand && !table.playerisBust()) {
                //player Hits or stands
                Thread.sleep(10);
                if (wantsHit) {
                    table.playerHit();
                    wantsHit = false;
                    System.out.println("YOUR TURN \n" + table.toString());
                    flagUpdate();
                }
            }
            //TODO If PLayer has BJ then he wins
            if (table.playerBJ()) {


                if (table.dealerBJ()) {
                    push();
                } else {

                    gameState = "PLAYER RECEIVED A BJ!";
                    setDealerReveal(true);
                    Bank.winBet(Bank.getCurrentBet(),2);
                    flagUpdate();
                    keepGoing = false;
                }
            } else {
                //Dealer's Turn
                setDealerReveal(true);
                table.dealersTurn();
                System.out.println("DEALER TURN \n" + table.toString());
                gameState = "Dealer Turn";
                flagUpdate();
                //************** determine winner ********
                if (table.playerisBust() && table.dealerisBust()) {
                    push();
                } else if (table.playerisBust() && !table.dealerisBust()) {
                    gameState = "Dealer wins! ... player Bust";
                    Bank.loseBet();
                   //table.getPlayer().getBank().loseBet();
                    keepGoing = false;
                    flagUpdate();
                } else if (!table.playerisBust() && table.dealerisBust()) {
                    gameState = "Player wins! ... Dealer Bust";
                    Bank.winBet(Bank.getCurrentBet(),1);
                    //table.getPlayer().getBank().winBet(100,1);
                    keepGoing = false;
                    flagUpdate();
                } else if (table.playerHandPower() > table.dealerHandPower()) {
                    // player wins
                    gameState = "Player wins! ... Bigger Hand";
                    Bank.winBet(Bank.getCurrentBet(),1);
                    //table.getPlayer().getBank().winBet(100,1);
                    keepGoing = false;
                    flagUpdate();
                }
                else if (table.playerHandPower() < table.dealerHandPower()){

                    //dealer wins
                    gameState = "Dealer wins! ... Bigger Hand";
                    Bank.loseBet();
                    //table.getPlayer().getBank().loseBet();
                    keepGoing = false;
                    flagUpdate();
                }else if (table.playerHandPower() == table.dealerHandPower()) push();

            }

            //System.out.println("Bank Balance is: "+table.getPlayer().getBank().getBalance());
        }
        return null;

    }

    private void push() {
        gameState = "PUSH";
        Bank.winBet(Bank.getCurrentBet(),0);
        //table.getPlayer().getBank().winBet(100,0);
        setDealerReveal(true);
        keepGoing = false;
        flagUpdate();
    }


}



