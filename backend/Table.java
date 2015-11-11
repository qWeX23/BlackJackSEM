package backend;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bjc90_000 on 10/14/2015.
 */
public class Table {
    ArrayList<Player> players;
    Dealer dealer;
    Deck deck;
    int numberOfPlayers;

    public Table(int numPlayers, Deck deck) {
        numberOfPlayers = numPlayers;
        this.deck = deck;
        players = new ArrayList<>();
        //for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
      //  }
        dealer = new Dealer();

        //test();
    }



    public void dealersTurn(){
        try {
            while (dealer.doesDealerHit()) {
                dealer.takeCard(deck.drawCard());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void reset() {
        players.remove(0);
        players.add(new Player(deck.drawCard(), deck.drawCard()));
        dealer= new Dealer(deck.drawCard(), deck.drawCard());
    }

    @Override
    public String toString() {
        return "Table{" +
                "dealer=" + dealer.toString() +
                ", players=" + players.toString() +
                '}';
    }

    public void playerHit() {

        players.listIterator(0).next().takeCard(deck.drawCard());

    }

    public boolean playerisBust() {

       return players.listIterator(0).next().isBust();


    }

    public boolean dealerisBust() {
        return dealer.isBust();
    }

    public int playerHandPower() {

        return players.listIterator(0).next().handPower();
    }

    public int dealerHandPower() {
        return dealer.handpower();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return  players.get(0);
    }

    public ArrayList<Player> getPlayerList() {
        return players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
