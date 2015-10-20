package backend;

/**
 * Created by bjc90_000 on 10/20/2015.
 */
public class Dealer {

    Hand hand;
    public static final int DEALER_MAX_HAND=17;

    public Dealer(Card c, Card c1){
        hand = new Hand();

        takeCard(c);takeCard(c1);
    }

    public boolean doesDealerHit() throws Exception {
        
       return (hand.calculateHandPower()<=DEALER_MAX_HAND);


    }


    public void takeCard(Card card) {
        hand.addCard(card);
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "hand=" + hand +
                '}';
    }
}
