package backend;

/**
 * Created by bjc90_000 on 10/14/2015.
 */
public class Player {

    private static final int DEFAULT_BANK = 1000;
    private Hand hand;
    private Bank bank;

    public Player(Card card, Card card1) {
        hand = new Hand();
        takeCard(card);
        takeCard(card1);
        //make a new bank or use old one
        if (bank != null) {
            bank = new Bank(bank.getBalance());
        } else {
            bank = new Bank(DEFAULT_BANK);
        }
    }

    public Player() {
        hand = new Hand();
        if (bank != null) {
            bank = new Bank(bank.getBalance());
        } else {
            bank = new Bank(DEFAULT_BANK);
        }
    }

    public void takeCard(Card c) {
        hand.addCard(c);
    }

    public boolean isBust() {
        return hand.isBust();
    }

    @Override
    public String toString() {
        return "Player{" +
                "hand=" + hand.toString() +
                '}';
    }

    public int handPower() {
        try {
            return hand.calculateHandPower();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Bank getBank() {
        return bank;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean hasBJ() {
        return hand.hasBJ();
    }

    public int probPlayerBust() throws Exception {
        int handValue = hand.calculateHandPower();

        if (handValue > 11) {
            switch (handValue) {
                case 21:
                    return 100;
                case 20:
                    return 92;
                case 19:
                    return 85;
                case 18:
                    return 77;
                case 17:
                    return 69;
                case 16:
                    return 62;
                case 15:
                    return 58;
                case 14:
                    return 56;
                case 13:
                    return 39;
                case 12:
                    return 31;
                default:
                    return 0;
            }
        } else
            return 0;
    }

    public double getProb21() {
        // here is my though process i have no clue wtf im doing
        // a probability of a certain card is 4/52
        // if you need a specific card ( any once card A-K ) to get 21 then 4/52 is the
        // if a single card (A-K) wont get you a 21 then the chance of 21 on the next hit is 0
        // it seems stupid to me but i think its right
        int numTill21 = 21 - handPower();
        System.out.println("the numTIll21 is "+numTill21);
        if (numTill21 <= 11) {
            System.out.println("Returning "+(double)(4/57));
            return (7.692307692);
        } else
            return 0;
    }
    
}