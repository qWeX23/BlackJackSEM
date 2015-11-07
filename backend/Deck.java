package backend;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;

/**
 * Created by bjc90_000 on 10/14/2015.
 */
public class Deck {
    public final String[] SUITS = {"Spade","Diamond","Club","Heart"};
    public final String[] RANKS = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    Card[] cardList;
    public Deck() {
        //this code should probably go somewhere else
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("cards.bj"));
            cardList = (Card[]) in.readObject();
            //this will print the cards out
            //for(Card c : cardList)System.out.println(c);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Card newCard;
    public Card drawCard(){

       Random rg = new Random();

      // return new Card(RANKS[rg.nextInt(12)],SUITS[rg.nextInt(3)], power, front, back);
        return cardList[rg.nextInt(52)];
    }
}
