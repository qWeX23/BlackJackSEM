package backend;

import java.util.ArrayList;

/**
 * Created by bjc90_000 on 10/14/2015.
 */
public class Hand {
    ArrayList<Card> cards;
    final int MAX_HAND=21;
    public int calculateHandPower(){
        boolean isBust =false;
        boolean canGoHigher =true;
        int totalPower=0;

        int max = calculateMaxPower(cards);
        if(max<MAX_HAND)
            return max;
        else


        for(Card c:cards){


        }





    return 99;
    }

    private int calculateMaxPower(ArrayList<Card> cards) {
        int power=0;

        for(Card c:cards){
            if(c.getPower()==1){
                power+=11;
            }else {
                power+=c.getPower();
            }
        }
        return power;
    }
}
