package backend;

/**
 * Created by bjc90_000 on 10/14/2015.
 */
public class Player {

    private static final int DEFAULT_BANK = 1000;
    Hand hand;
    Bank bank;

    public Player(Card card, Card card1) {
        hand=new Hand();
        takeCard(card);
        takeCard(card1);
        //make a new bank or use old one
        if(bank!=null){
            bank = new Bank(bank.balance);
        }else{
            bank= new Bank(DEFAULT_BANK);
        }
    }

    public Player() {
        hand=new Hand();
        if(bank!=null){
            bank = new Bank(bank.balance);
        }else{
            bank= new Bank(DEFAULT_BANK);
        }
    }

    public void takeCard(Card c){
        hand.addCard(c);

    }
    public boolean isBust(){
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

    public Bank getBank(){
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
         
        if (handValue > 11)  {  
            switch(handValue)  {
                case 21: return 100;
                case 20: return 92;
                case 19: return 85;
                case 18: return 77;
                case 17: return 69;
                case 16: return 62;
                case 15: return 58;
                case 14: return 56;
                case 13: return 39;
                case 12: return 31;
                default: return 0;
            }
        }
        else
            return 0;
    }
    
}