package Backend;

import backend.Card;
import backend.Hand;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class HandTest {
       
     /**
     * Test of constructor method, of class Hand.
     */
    @Test
    public void testHand() {
        Hand instance = new Hand();
        System.out.println("Testing Constructor");
        assertNotNull(instance);   
    } 

    /**
     * Test of toString method, of class Hand.
     * @throws java.lang.Exception
     */
    @Test
    public void testToString() throws Exception  {
        Hand instance = new Hand();
        System.out.println("Testing toString");
        String expResult = "Hand{" +
                    "cards=" + instance.getCards().toString() + " for a total of " + instance.calculateHandValue()+
                    '}';
        String result = instance.toString();
        assertEquals(expResult, result);    
    }

    /**
     * Test of isBust method, of class Hand.
     */
    @Test
    public void testIsBust() {
        Hand instance = new Hand();
        System.out.println("Testing isBust");
        instance.addCard(new Card("Spades", "10", 10, new ImageIcon(), new ImageIcon()));
        instance.addCard(new Card("Clubes", "8", 8, new ImageIcon(), new ImageIcon()));
        assertFalse(instance.isBust());
        instance.addCard(new Card("Clubes", "4", 4, new ImageIcon(), new ImageIcon()));
        assertTrue(instance.isBust());
    }

    /**
     * Test of addCard method, of class Hand.
     */
    @Test
    public void testAddCard() {
        Hand instance = new Hand();
        System.out.println("Testing addCard");
        instance.addCard(new Card("Spades", "10", 10, new ImageIcon(), new ImageIcon()));
        instance.addCard(new Card("Clubs", "8", 8, new ImageIcon(), new ImageIcon()));
        System.out.println('\t' + " Hand toString = " + instance.toString());   
    }

    /**
     * Test of getCards method, of class Hand.
     */
    @Test
    public void testGetCards() {
        Hand instance = new Hand();
        System.out.println("Testing getCards");
        instance.addCard(new Card("Spades", "10", 10, new ImageIcon(), new ImageIcon()));
        instance.addCard(new Card("Clubs", "8", 8, new ImageIcon(), new ImageIcon()));
        ArrayList<Card> result = instance.getCards();
        assertNotNull(result);
        for (Card card : result) {
            System.out.println('\t' + " Card = " + card.toString());
        }
    }
    
    /**
     * Test of calculateHandPower method, of class Hand.
     * @throws java.lang.Exception
     * Note this also tests private methods numAce 
     */
    @Test
    public void testCalculateHandValue() throws Exception {
        Hand instance = new Hand();
        System.out.println("Testing calculateHandPower");
        instance.addCard(new Card("Spades", "10", 10, new ImageIcon(), new ImageIcon()));
        instance.addCard(new Card("Clubs", "Ace", 1, new ImageIcon(), new ImageIcon()));
        int expResult = instance.calculateHandValue();
        assertEquals(expResult, 21); 
        instance = new Hand();
        instance.addCard(new Card("Spades", "10", 10, new ImageIcon(), new ImageIcon()));
        instance.addCard(new Card("Clubs", "10", 10, new ImageIcon(), new ImageIcon()));
        expResult = instance.calculateHandValue();
        assertEquals(expResult, 20); 
        instance = new Hand();
        instance.addCard(new Card("Spades", "Ace", 1, new ImageIcon(), new ImageIcon()));
        instance.addCard(new Card("Clubs", "Ace", 1, new ImageIcon(), new ImageIcon()));
        instance.addCard(new Card("Clubs", "Ace", 8, new ImageIcon(), new ImageIcon()));
        expResult = instance.calculateHandValue();
        assertEquals(expResult, 20);   
    }
    
     /**
     * Test of hasBJ method, of class Hand. 
     */
    @Test
    public void testHasBJ() {
        Hand instance = new Hand();
        System.out.println("Testing hasBJ");
        instance.addCard(new Card("Spades", "King", 10, new ImageIcon(), new ImageIcon()));
        instance.addCard(new Card("Clubs", "Ace", 1, new ImageIcon(), new ImageIcon()));
        assertTrue(instance.hasBJ());
        instance = new Hand();
        instance.addCard(new Card("Spades", "10", 10, new ImageIcon(), new ImageIcon()));
        instance.addCard(new Card("Clubs", "5", 5, new ImageIcon(), new ImageIcon()));
        assertFalse(instance.hasBJ());
    }
    
}
