package gui;

import backend.Table;

import javax.swing.*;

/**
 * Created by bjc90_000 on 10/29/2015.
 */
public class GameCoordinator extends SwingWorker<Boolean, Boolean> {

    Table table;

    Boolean wantsHit, wantsStand, dealerWins = false, playerWins = false, winnerDetermined = false, endGame = false, GUIUpdated = false, startGame;
    boolean canBet =true;

    PlayGUI mainGUI;
    GCUpdate gcu;

    public GameCoordinator(Table table, PlayGUI mainGUI){
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

            //while(canBet)Thread.sleep(10);//System.out.println("doing nothing waiting for the bet");

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
                    table.playerHit();
                    wantsHit = false;
                    System.out.println("YOUR TURN \n"+table.toString());
                    gcu = update();
                    mainGUI.update(gcu.getPlayerCards());
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


    protected void setCanBet(boolean canBet) {
        this.canBet = canBet;
    }



    private void reset() {
        dealerWins=false;playerWins=false;winnerDetermined=false;GUIUpdated=false;
        wantsHit=false; wantsStand=false;
        gcu = update();
        gcu.reset();
        // reset GUI
        mainGUI.reset();
        // update initial draw
        mainGUI.update(gcu.getPlayerCards());
    }

    public GCUpdate update(){
        return new GCUpdate(table.getPlayer(),table.getDealer(), table.getNumberOfPlayers());
    }

    public boolean getCanBet() {
        return canBet;
    }

    public boolean placeBet(int bet) {
        return table.getPlayer().getBank().placeBet(bet);
    }
}
