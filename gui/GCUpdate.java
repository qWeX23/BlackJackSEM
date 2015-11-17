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
    private String bankText;
    private int width, height;
    private int pos, dealerCard;
    private PaintImages dealersFirst;
    private ImageIcon otherSide;
    private boolean dealerReveal;


    public GCUpdate(String gameState, Player p, Dealer d, int num){
        width = 0; height = 0;
        this.gameState=gameState;
        this.player = p;
        this.dealer = d;
        this.pi = new ArrayList<>();
        this.player_x = 0;
        this.dealer_x = 0;
        this.numOfPlayers = num;
        this.bankText = Integer.toString(p.getBank().getBalance());
        dealerReveal = false;
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
        pos = ((width/3) - 100);
        this.player_x = pos;
        this.dealer_x = pos;
        // create player images
        for(Card c : player.getHand().getCards()) {
            pi.add(new PaintImages(player_x, (height/8)*5, c.getCardFront()));
            player_x += 50;

        }
        //create dealer images
        dealerCard = 0;
        for(Card c : dealer.getHand().getCards()) {
            if (dealerCard == 0) {
                dealersFirst = new PaintImages(dealer_x, (height / 8) * 1, c.getCardBack());
                otherSide = c.getCardFront();
                if (dealerReveal) {
                    dealersFirst.setImage(otherSide);
                }
                pi.add(dealersFirst);
                dealerCard++;
            } else {
                pi.add(new PaintImages(dealer_x, (height / 8) * 1, c.getCardFront()));
            }
            dealer_x += 50;
        }
        dealerCard = 0;
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
        try {
            return player.probPlayerBust();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public double getProbDealerBust(){
        try {
            return dealer.probDealerBust();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public double getProbPlayer21(){
        return player.getProb21();
    }

    public String getBank() {return bankText;}

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDealerReveal(boolean b) {
        dealerReveal = b;
    }
}
