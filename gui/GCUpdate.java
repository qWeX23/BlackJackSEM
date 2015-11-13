package gui;

import backend.Card;
import backend.Dealer;
import backend.Player;

import javax.swing.*;
import java.util.ArrayList;

public class GCUpdate{
    private Player player;
    private Dealer dealer;
    private int numOfPlayers;
    private int player_x, dealer_x;
    private ArrayList<PaintImages> pi;
    private String gameState;

    private static final int PLAYER_Y = 500, DEALER_Y = 100;

    public GCUpdate(String gameState, Player p, Dealer d, int num){
        this.gameState=gameState;
        this.player = p;
        this.dealer = d;
        this.pi = new ArrayList<>();
        this.player_x = 0;
        this.dealer_x = 400;
        this.numOfPlayers = num;
    }

    /*
    getPlayerCards()
        called by GameCoordinator. Makes the lists of paint images and
        returns it to game coordinator.
     */
    public ArrayList<PaintImages> getPlayerCards(){
       if(!player.getHand().getCards().isEmpty() && !dealer.getHand().getCards().isEmpty())
        makeLists();
        return this.pi;
    }

    /*
    makeLists()
        called by the getPlayerCards() method.
        creates paint Image objects and adds them to paint image list.
     */
    private void makeLists() {
        // TODO:
        // Won't work for dealing animation (i.e., cards going across table in order).
        // Chalk it up to future enhancement for now until full functioning game and tutorial
        // is available.

        // create player images
        for(Card c : player.getHand().getCards()) {
            player_x += 40;
            pi.add(new PaintImages(player_x, PLAYER_Y, c.getCardFront()));
        }
        //create dealer images
        for(Card c : dealer.getHand().getCards()) {
            dealer_x += 40;
            pi.add(new PaintImages(dealer_x, DEALER_Y, c.getCardFront()));
        }
    }

    /*
    reset()
        reset lists and horizontal coordinates
     */
    public void reset() {
        pi.clear();
        player_x = 0;
        dealer_x = 400;
    }
    public String getGameState(){
        return gameState;
    }

    public double getProbPlayerBust(){
        return player.probBust();
    }
}
