package Games;

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
                Thread.sleep(10);
                //System.out.println("Stuck Waiting for stand");

                if (wantsHit) {
                    table.playerHit();
                    wantsHit = false;
                    System.out.println("YOUR TURN \n" + table.toString());
                    flagUpdate();
                }
            }
            //Dealer's Turn
            if (!table.playerisBust()) {
                table.dealersTurn();
                System.out.println("DEALER TURN \n" + table.toString());
                gameState = "Dealer Turn";
                flagUpdate();

            } else {
                System.out.println("DEALER WINS by player bustl");
                dealerWins = true;
                winnerDetermined = true;
                gameState = "Dealer Wins by Player Bust";
                flagUpdate();
            }
            //Determine Winner
            if (table.dealerisBust()) {
                System.out.println("PLAYER WINS by dealer bust");
                gameState = "Player Wins by Dealer Bust";

                playerWins = true;
                flagUpdate();

            } else if (!table.playerisBust() && !table.dealerisBust()) {

                if (table.playerBJ() || table.dealerBJ()) {

                    if (table.playerBJ() && !table.dealerBJ()) {

                        gameState ="BJ!!";
                        flagUpdate();

                    } else if (table.dealerBJ() && !table.dealerBJ()) {
                        flagUpdate();

                    }

                }else

                //TODO check for and give priority to blackjack
                if (table.playerHandPower() == table.dealerHandPower()) {
                    gameState = "PUSH";
                    flagUpdate();
                } else if (table.playerHandPower() > table.dealerHandPower()) {
                    playerWins = true;
                    System.out.println("PLAYER WINS by larger hand");
                    gameState = "Player Wins by Larger Hand";
                    flagUpdate();
                } else {
                    System.out.println("DEALER WINS by larger hand");
                    gameState = "Dealer Wins by Larger Hand";
                    dealerWins = true;
                    flagUpdate();
                }
            }

        }


        return null;
    }


}
