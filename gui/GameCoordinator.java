package gui;

import backend.Table;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by bjc90_000 on 10/29/2015.
 */
public class GameCoordinator extends SwingWorker<Boolean, Boolean> {


    Table table;
    Boolean wantsHit, wantsStand,dealerWins=false,playerWins=false,winnerDetermined=false,endGame=false,GUIUpdated=false,startGame;
    PlayGUI mainGUI;
    TestInit ti;    //TEST CODE
    TestExtraCards tec; //TEST CODE

    public GameCoordinator(Table table, PlayGUI mainGUI){
        ti = new TestInit();    //TEST CODE
        tec = new TestExtraCards(); //TEST CODE
        this.table=table;
        this.mainGUI = mainGUI;
        this.reset();
        System.out.println("GAME COORDINATOR ONLINE");
    }


    @Override
    protected Boolean doInBackground() throws Exception {
        mainGUI.updateInit(4, ti.getList());
      //  while(!startGame);
       // this.wait();
        while(!endGame) {
            System.out.println("playing game");
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

                    //TEST CODE, BEST PLACE TO PUT IT? I DONT KNOW. TALK ABOUT IT LATER.
                    mainGUI.updatePlayer(1, tec.getCard1());
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
