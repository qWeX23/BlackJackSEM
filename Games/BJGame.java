package Games;

import backend.Table;

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

            System.out.println("Place Bet...");

            while (canBet) Thread.sleep(10);//System.out.println("doing nothing waiting for the bet");

            //Deal Cards to Dealer and Player
            table.reset();
            this.reset();
            System.out.println("INITiAL DEAL \n" + table.toString());


            //signalGUI update
            //Players Turn
            System.out.println("YOUR TURN \n" + table.toString());
            while (!wantsStand && !table.playerisBust()) {
                //System.out.println("Stuck Waiting for stand");

                if (wantsHit) {
                    table.playerHit();
                    wantsHit = false;
                    System.out.println("YOUR TURN \n" + table.toString());
                }
            }
            //Dealer's Turn
            if (!table.playerisBust()) {
                table.dealersTurn();
                System.out.println("DEALER TURN \n" + table.toString());

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

        }


        return null;
    }


}
