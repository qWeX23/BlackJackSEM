package backend;

import java.util.Random;

/**
 * Created by bjc90_000 on 10/14/2015.
 */
public class Deck {
    public final String[] SUITS = {"Spade","Diamond","Club","Heart"};
    public final String[] RANKS = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

   public Card drawCard(){

       Random rg = new Random();

       return new Card(RANKS[rg.nextInt(12)],SUITS[rg.nextInt(3)]);

    }
}
