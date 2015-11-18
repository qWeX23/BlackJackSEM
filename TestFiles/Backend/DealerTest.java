package Backend;

import backend.Card;
import backend.Dealer;
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
public class DealerTest {
    
     /**
     * Test of constructor method, of class Dealer.
     */
    @Test
    public void testDealer() {
        Dealer instance = new Dealer();
        System.out.println("Testing Constructor");
        assertNotNull(instance);   
    }
    
    /**
     * Test of doesDealerHit method, of class Dealer.
     * @throws java.lang.Exception
     */
    @Test
    public void testDoesDealerHit() throws Exception {
        Dealer instance = new Dealer();
        System.out.println("Testing doesDealerHit");
        backend.Card c = new backend.Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        backend.Card d = new backend.Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        assertTrue(instance.doesDealerHit());   
    }

    /**
     * Test of takeCard method, of class Dealer.
     */
    @Test
    public void testTakeCard() {
        Dealer instance = new Dealer();
        System.out.println("Testing takeCard");
        backend.Card c = new backend.Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        backend.Card d = new backend.Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        System.out.println('\t' + "Hand toString = " + instance.getHand().toString());
    }

    /**
     * Test of toString method, of class Dealer.
     */
    @Test
    public void testToString() {
        Dealer instance = new Dealer();
        System.out.println("Testing toString");
        String expResult = "Dealer{" +
                "hand=" + instance.getHand() +
                '}';
        String result = instance.toString();
        assertEquals(expResult, result);      
    }

    /**
     * Test of isBust method, of class Dealer.
     * Note the the method isBust() for the class Hand is tested in HandTest class
     */
    @Test
    public void testIsBust() {
        Dealer instance = new Dealer();
        System.out.println("Testing isBust");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        assertFalse(instance.isBust());        
    }

    /**
     * Test of handpower method, of class Dealer.
     * Note the the method calculateHandPower() for the class Hand is tested in HandTest class
     */
    @Test
    public void testHandpower() {
        Dealer instance = new Dealer();
        System.out.println("Testing handPower");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        int result = instance.handpower();
        assertEquals(result, 15);
        
    }

    /**
     * Test of getHand method, of class Dealer.
     */
    @Test
    public void testGetHand() {
        Dealer instance = new Dealer();
        System.out.println("Testing getHand");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d); 
        assertNotNull(instance.getHand());
        System.out.println('\t' + "Hand toString = " + instance.getHand().toString());       
    }
    
    /**
     * Test of hasBJ method, of class Dealer.
     */
    @Test
    public void testHasBJ() {
        Dealer instance = new Dealer();
        System.out.println("Testing hasBJ");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "King", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        assertFalse(instance.hasBJ());
        instance = new Dealer();
        c = new Card("Club", "Ace", 1, new ImageIcon(), new ImageIcon());
        d = new Card("Spade", "King", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        assertTrue(instance.hasBJ());
    } 
    
    /**
     * Test of probDealerBust method, of class Dealer.
     */
    @Test
    public void testProbDealerBust() {
        Dealer instance = new Dealer();
        System.out.println("Testing probDealerBust");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "King", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        assertEquals(41.6, instance.probDealerBust(), .001);
    }
}
