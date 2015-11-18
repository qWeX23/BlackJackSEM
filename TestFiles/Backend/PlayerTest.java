package Backend;

import backend.Card;
import backend.Player;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class PlayerTest {
    
    /**
     * Test of constructor method, of class Player.
     */
    @Test
    public void testPlayer() {
        Player instance = new Player();
        System.out.println("Testing constructor");
        assertNotNull(instance);   
    }
    
    /**
     * Test of takeCard method, of class Player.
     */
    @Test
    public void testTakeCard() {
        Player instance = new Player();
        System.out.println("Testing takeCard");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d); 
        System.out.println('\t' + "Hand toString = " + instance.getHand().toString());
    }

    /**
     * Test of isBust method, of class Player.
     * Note the the method isBust() for the class Hand is tested in HandTest class
     */
    @Test
    public void testIsBust() {
        Player instance = new Player();
        System.out.println("Testing isBust");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        assertFalse(instance.isBust());      
    }

    /**
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        Player instance = new Player();
        System.out.println("Testing toString");
        String expResult = "Player{" +
                "hand=" + instance.getHand() +
                '}';
        String result = instance.toString();
        assertEquals(expResult, result);      
    }

    /**
     * Test of handPower method, of class Player.
     * Note the the method calculateHandPower() for the class Hand is tested in HandTest class
     */
    @Test
    public void testHandPower() {
        Player instance = new Player();
        System.out.println("Testing handPower");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        int result = instance.handPower();
        assertEquals(result, 15);       
    }
    
    
    /**
     * Test of getBank method, of class Player.
     * Note this test assumes Bank object is Null and uses DEFAULT_BANK value of 1000
     */
    @Test
    public void testGetBank() {
        Player instance = new Player();
        System.out.println("Testing getBank");
        assertEquals(instance.getBank().getBalance(), 1000);    
    }

    /**
     * Test of getHand method, of class Player.
     */
    @Test
    public void testGetHand() {
        Player instance = new Player();
        System.out.println("Testing getHand");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d); 
        assertNotNull(instance.getHand());
        System.out.println('\t' + "Hand toString = " + instance.getHand().toString());      
    }
    
    /**
     * Test of probPlayerBust method, of class Player.
     * @throws java.lang.Exception
     */
    @Test
    public void testProbPlayerBust() throws Exception {
        Player instance = new Player();
        System.out.println("Testing probPlayerBust");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.takeCard(c); 
        instance.takeCard(d);
        assertEquals(instance.probPlayerBust(), 58);
    }
    
}
