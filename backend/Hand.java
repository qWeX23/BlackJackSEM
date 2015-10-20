package backend;

import java.util.ArrayList;

/**
 * Created by bjc90_000 on 10/14/2015.
 */
public class Hand {
    private static final int ALT_ACE_VALUE = 11;
    private static final int MAX_HAND = 21;
    ArrayList<Card> cards;

    @Override
    public String toString() {
        try {
            return "Hand{" +
                    "cards=" + cards.toString() + " for a total of " +calculateHandPower()+
                    '}';
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failed";
    }

    public Hand(){
        cards = new ArrayList<>();
    }

    public void addCard(Card c){
        cards.add(c);
    }
    public ArrayList<Card> getCards() {
        return cards;
    }

    public int calculateHandPower() throws Exception {
        boolean isBust = false;
        //boolean canGoHigher =true;
        int totalPower = 0;

        int max = calculateMaxPower(cards);
        int numAce = numAce();
        //everything is ok we did not bust
        if (max <= MAX_HAND)
            return max;
        else
            isBust = true;//max is over bust can we do anything about it?
        //its a bust and we cant do anything about it
        if (numAce == 0) {
            return max;
        } else
            //theres an ace!
            if (numAce > 0) {
                int currentUsedAces = numAce - 1;

                while (isBust) {
                    //add up ignoring aces
                    for (Card c : cards) {
                        if (c.getPower() != 1) {
                            totalPower += c.getPower();
                        }
                    }


                    totalPower += (currentUsedAces * ALT_ACE_VALUE);
                    totalPower += ((numAce - currentUsedAces));

                    if (totalPower <= MAX_HAND || currentUsedAces == 0) {
                        return totalPower;
                    } else {
                        currentUsedAces--;
                    }
                }


            }

        throw  new Exception("something has gone wrong with calculationg this hand"+toString());

    }


    private int numAce() {
        int num = 0;
        for (Card c : cards) {
            if (c.getPower() == 1) num++;


        }
        return num;
    }


    private int calculateMaxPower(ArrayList<Card> cards) {
        int power = 0;

        for (Card c : cards) {
            if (c.getPower() == 1) {
                power += 11;
            } else {
                power += c.getPower();
            }
        }
        return power;
    }
}
