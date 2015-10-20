package backend;

/**
 * Created by bjc90_000 on 10/14/2015.
 */
public class Player {

    Hand hand;

    public Player(Card card, Card card1) {
        hand=new Hand();
        takeCard(card);
        takeCard(card1);
    }

    public void takeCard(Card c){
        hand.addCard(c);

    }

    @Override
    public String toString() {
        return "Player{" +
                "hand=" + hand.toString() +
                '}';
    }
}
