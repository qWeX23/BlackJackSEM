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

    public Table(int numPlayers,Deck deck)  {



        this.deck = deck;
        players=new ArrayList<>();

        for(int i = 0;i<=numPlayers-1;i++){
            players.add(new Player(deck.drawCard(),deck.drawCard()));
        }
        dealer=new Dealer(deck.drawCard(),deck.drawCard());


        while(true){
            System.out.println("\n"+this.toString());

            if(new Scanner(System.in).next().equals("h")){
                players.listIterator(0).next().takeCard(deck.drawCard());
            }
            try {
                if(dealer.doesDealerHit()){
                    dealer.takeCard(deck.drawCard());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public String toString() {
        return "Table{" +
                "dealer=" + dealer.toString() +
                ", players=" + players.toString() +
                '}';
    }
}
