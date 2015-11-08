package backend;

/**
 * Created by bjc90_000 on 10/20/2015.
 */
public class Dealer {

    Hand hand;
    public static final int DEALER_MAX_HAND=17;
    public static final int MAX_HAND =21;

    public Dealer(Card c, Card c1){
        hand = new Hand();

        takeCard(c);takeCard(c1);
    }

    public Dealer() {
        hand = new Hand();
    }

    public boolean doesDealerHit() throws Exception {
        
       return (hand.calculateHandPower()<DEALER_MAX_HAND);


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

    public boolean isBust() {

        try {
            return (this.getHand().calculateHandPower()>MAX_HAND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int handpower() {
        try {
            return hand.calculateHandPower();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Hand getHand() {
        return hand;
    }
}
