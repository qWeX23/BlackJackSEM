package Games;

import backend.Table;
import gui.GCUpdate;

import javax.swing.*;

/**
 * Created by bjc90_000 on 11/6/2015.
 */
public abstract class GameCoordinator extends SwingWorker{

    Table table = null;
    String gameState;

    Boolean wantsHit = null, wantsStand = null, dealerWins = false, playerWins = false, winnerDetermined = false, endGame = false, GUIUpdated = false, startGame = null;
    boolean canBet = true;
    boolean updateGUI= true;
    boolean dealerReveal=false;
    boolean keepGoing =true;

    public synchronized void setDealerReveal(boolean b){
        dealerReveal=b;
    }

    public synchronized void flagUpdate(){
        updateGUI=true;
    }

    public synchronized void requestHit() {

        wantsHit = true;
    }

    public synchronized void requestStand() {

        wantsStand = true;

    }

    public void setCanBet(boolean canBet) {
        this.canBet = canBet;
    }

    public synchronized void reset() {

        dealerWins = false;
        playerWins = false;
        winnerDetermined = false;
        GUIUpdated = false;
        wantsHit = false;
        wantsStand = false;
        dealerReveal=false;

    }

    public synchronized GCUpdate update() {
        if(updateGUI){
            updateGUI=false;
            return new GCUpdate(gameState,table.getPlayer(), table.getDealer(), table.getNumberOfPlayers(),dealerReveal);
        }

        return null;
    }
    //for testing only pls
    public Table getTable(){return table;}

    public boolean getCanBet() {
        return canBet;
    }

//    public boolean placeBet(int bet) {
//        return table.getPlayer().getBank().placeBet(bet);
//    }


}
