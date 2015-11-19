package backend;

/**
 * Created by bjc90_000 on 10/20/2015.
 */
public class Dealer {

    private Hand hand;
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
        
       //return (hand.calculateHandPower()<DEALER_MAX_HAND);
        return (hand.calculateHandValue()<DEALER_MAX_HAND);

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
            //return (this.getHand().calculateHandPower()>MAX_HAND);
            return (this.getHand().calculateHandValue()>MAX_HAND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int handpower() {
        try {
            //return hand.calculateHandPower();
            return hand.calculateHandValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean hasBJ() {
        return hand.hasBJ();
    }
    
    public double probDealerBust() {
        String faceUpCard = hand.getCards().get(0).getRank();

        switch (faceUpCard) {
            case   "Ace": return 11.5;
            case     "2": return 35.4;
            case     "3": return 37.4;
            case     "4": return 39.4;  
            case     "5": return 41.6;
            case     "6": return 42.3;
            case     "7": return 26.2;
            case     "8": return 24.5;
            case     "9": return 22.8;
            case    "10": return 21.2;
            case  "Jack": return 21.2;
            case "Queen": return 21.2;
            case  "King": return 21.2;
            default: return 0.0;
        }
    }
}
