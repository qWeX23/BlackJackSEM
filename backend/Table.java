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

    public Table(int numPlayers, Deck deck) {


        this.deck = deck;
        players = new ArrayList<>();
        for (int i = 0; i <= numPlayers - 1; i++) {
            players.add(new Player(deck.drawCard(), deck.drawCard()));
        }
        dealer = new Dealer(deck.drawCard(), deck.drawCard());

        //test();
    }

    public void test() {
        // Ben, this is how I can get the Rank and Suit of the cards of the dealer
        String s = dealer.getHand().getCards().get(0).getRank();
        s += "\n" + dealer.getHand().getCards().get(0).getSuit();
        s += "\n" + dealer.getHand().getCards().get(1).getRank();
        s += "\n" + dealer.getHand().getCards().get(1).getSuit();
        System.out.println(s);

        s = players.get(0).getHand().getCards().get(0).getRank();
        s += "\n" + players.get(0).getHand().getCards().get(0).getSuit();
        System.out.println(s);
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

    public void reset() {
        dealer= new Dealer(deck.drawCard(), deck.drawCard());
        players.remove(0);
        players.add(new Player(deck.drawCard(), deck.drawCard()));

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

    public int deartHandPower() {
        return dealer.handpower();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return  players.listIterator(0).next();
    }

    public ArrayList<Player> getPlayerList() {
        return players;
    }
}
