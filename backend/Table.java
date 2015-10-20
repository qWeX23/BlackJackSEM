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


    }


    public void playBlackJack() {

        while (true) {
            try {
                System.out.println("\n" + this.toString());

                if (new Scanner(System.in).next().equals("h")) {
                    players.listIterator(0).next().takeCard(deck.drawCard());
                }else{
                    if(players.listIterator(0).next().handPower()>dealer.handpower()){

                    }
                }

               while (dealer.doesDealerHit()) {
                    dealer.takeCard(deck.drawCard());
                }
                if(dealer.isBust()){
                    System.out.println("Dealer Bust, Player wins");
                    this.reset();
                }else
                    if (players.listIterator(0).next().isBust()){
                    System.out.println("Player Bust, Dealer Wins");
                    this.reset();

                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    private void reset() {
    }

    @Override
    public String toString() {
        return "Table{" +
                "dealer=" + dealer.toString() +
                ", players=" + players.toString() +
                '}';
    }
}
