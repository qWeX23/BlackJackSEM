package gui;

import backend.Card;
import backend.Dealer;
import backend.Player;

import javax.swing.*;
import java.util.ArrayList;

public class GCUpdate{
    Player player;
    Dealer dealer;


    public GCUpdate(Player p,Dealer d){
        this.player = p;this.dealer=d;

    }
    public ArrayList<ImageIcon> getPlayerCards(){
        ArrayList<ImageIcon> images = new ArrayList<>();

        for(Card c : player.getHand().getCards()){
            images.add(c.getFront());
        }
        return images;
    }


}
