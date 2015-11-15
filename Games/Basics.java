package Games;

import backend.Table;

import javax.swing.*;

/**
 * Created by bjc90_000 on 11/14/2015.
 */
public class Basics extends GameCoordinator {


    public Basics(Table table){
        this.reset();
        this.table=table;
    }




    @Override
    protected Object doInBackground() throws Exception {

        table.hardReset();
        gameState="THIS WILL BE THE STRING THAT EXPLAINS EVERYTHINGGGGG";
        // ""place bet"" to continue
        canBet = true;
        flagUpdate();
        while (canBet) Thread.sleep(10);
        flagUpdate();


        table.getPlayer().takeCard(table.getDeck().getSpecificCard(15));//3 of diamonds to player
        table.getPlayer().takeCard(table.getDeck().getSpecificCard(27));//2 of clubs to player
        gameState= "You can see that your hand value total is only 5, so no matter what there " +
                "is no chance of you busting if you decided to hit. The dealer’s visible card is " +
                "also an 8, so we want to assume that his hand total at the moment is 18. " +
                "Because we would lose if we decided not to hit, the correct move would be to hit on this hand.";
        flagUpdate();

        //wait for player hit
        while(!wantsHit)Thread.sleep(10);
        wantsHit=false;


        table.getPlayer().takeCard(table.getDeck().getSpecificCard(42));//4 of hearts to player
        gameState= "Alright, this hit puts us into an advantageous situation by putting our hand" +
                " total at 9. Since there is no way for us to bust on our next hit, and because " +
                "we assume that the next hit will result in a 10, the correct move would be to hit on this hand. ";
        flagUpdate();

        //wait for player hit
        while(!wantsHit)Thread.sleep(10);
        wantsHit=false;

        table.getPlayer().takeCard(table.getDeck().getSpecificCard(24));// queen of diamonds to player
        gameState="As assumed, you have hit into a 10 value card so your new hand total is 19. You are" +
                " now at an advantage because you want to assume that the dealer’s face-down card is of" +
                " 10 value, you would win this hand by staying. The correct move would be to stand on this hand.";
        flagUpdate();

        while (!wantsStand)Thread.sleep(10);
        wantsStand=false;

        gameState="Again as assumed, the dealer’s face-down card was of 10 value. You always want to assume tha" +
                "t the dealer’s face-down card is of 10 value because those cards have the greatest probability of" +
                " being that face-down card. ";
        flagUpdate();

        //somehow reveal the dealers play and then also let the user exit




        return null;
    }
}
