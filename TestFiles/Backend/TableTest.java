package Backend;

import backend.Card;
import backend.Deck;
import backend.Player;
import backend.Table;
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
public class TableTest {

    /**
     * Test of constructor method, of class Table.
     */
   @Test
    public void testTable() {
        Table instance = new Table(1, new Deck());
        System.out.println("Testing constructor");
        assertNotNull(instance);   
    }

    /**
     * Test of dealersTurn method, of class Table.
     */
    @Test
    public void testDealersTurn() {
        Table instance = new Table(1, new Deck());
        System.out.println("Testing dealersTurn");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        Card e = new Card("Club", "10", 10, new ImageIcon(), new ImageIcon());
        instance.getDealer().takeCard(c); 
        instance.getDealer().takeCard(d);
        instance.getPlayer().takeCard(d); 
        instance.getPlayer().takeCard(e);
        instance.dealersTurn();
        String result = instance.getDealer().getHand().toString();
        System.out.println('\t' + "Dealer Hand = " + result);
    }

    /**
     * Test of reset method, of class Table.
     */
    @Test
    public void testReset() {
        Table instance = new Table(1, new Deck());
        System.out.println("Testing reset");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        Card e = new Card("Club", "10", 10, new ImageIcon(), new ImageIcon());
        instance.getDealer().takeCard(c); 
        instance.getDealer().takeCard(d);
        instance.getPlayer().takeCard(d); 
        instance.getPlayer().takeCard(e);
        System.out.println('\t' + "Dealer and Player hand before reset:");
        System.out.println('\t' + "Dealer Hand =" + instance.getDealer().getHand().toString());
        System.out.println('\t' + "PLayer Hand =" + instance.getPlayer().getHand().toString());
        instance.reset();  
        System.out.println('\t' + "Dealer and Player hand after reset:");
        System.out.println('\t' + "Dealer Hand = " + instance.getDealer().getHand().toString());
        System.out.println('\t' + "Player Hand = " + instance.getPlayer().getHand().toString());
    }

    /**
     * Test of toString method, of class Table.
     */
    @Test
    public void testToString() {
        Table instance = new Table(1, new Deck());
        System.out.println("Testing toString");
        String expResult = "Table{" +
                "dealer=" + instance.getDealer() +
                ", players=" + instance.getPlayerList() +
                '}';
        String result = instance.toString();
        assertEquals(expResult, result);     
    }

    /**
     * Test of playerHIt method, of class Table.
     */
    @Test
    public void testPlayerHIt() {
        Table instance = new Table(1, new Deck());
        System.out.println("Testing playerHIt");
        instance.playerHit();
        System.out.println('\t' + "Player Hand = " + instance.getPlayer().getHand().toString());
    }

    /**
     * Test of playerisBust method, of class Table.
     * Note isBust method references back to hand class and has been previously tested
     */
    @Test
    public void testPlayerisBust() {
        Table instance = new Table(1, new Deck());
        System.out.println("Testing playerisBust");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.getPlayer().takeCard(c); 
        instance.getPlayer().takeCard(d);
        assertFalse(instance.playerisBust());
    }

    /**
     * Test of dealerisBust method, of class Table.
     * Note isBust method references back to hand class and has been previously tested
     */
    @Test
    public void testDealerisBust() {
        Table instance = new Table(1, new Deck());
        System.out.println("Testing dealerisBust");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.getDealer().takeCard(c); 
        instance.getDealer().takeCard(d);
        assertFalse(instance.playerisBust());       
    }

    /**
     * Test of playerHandPower method, of class Table.
     * Note handPower() method references back to hand class and has been previously tested
     */
    @Test
    public void testPlayerHandPower() {
        Table instance = new Table(1, new Deck());
        System.out.println("Testing playerHandPower");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.getPlayer().takeCard(c); 
        instance.getPlayer().takeCard(d);
        assertEquals(instance.playerHandPower(), 15);        
    }

    /**
     * Test of deartHandPower method, of class Table.
     * Note handpower() method references back to hand class and has been previously tested
     */
    @Test
    public void testDeartHandPower() {
        Table instance = new Table(1, new Deck());
        System.out.println("Testing deartHandPower");
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.getDealer().takeCard(c); 
        instance.getDealer().takeCard(d);
        assertEquals(instance.dealerHandPower(), 15);
    }

    /**
     * Test of getDealer method, of class Table.
     */
    @Test
    public void testGetDealer() {
        System.out.println("Testing getDealer");
        Table instance = new Table(1, new Deck());
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.getDealer().takeCard(c); 
        instance.getDealer().takeCard(d);
        assertNotNull(instance.getDealer());
        System.out.println('\t' + "Dealer Hand = " + instance.getDealer().getHand().toString());
    }

    /**
     * Test of getPlayer method, of class Table.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("Testing getPlayer");
        Table instance = new Table(1, new Deck());
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.getPlayer().takeCard(c); 
        instance.getPlayer().takeCard(d);
        assertNotNull(instance.getDealer());
        System.out.println('\t' + "Player Hand = " + instance.getPlayer().getHand().toString());      
    }

    /**
     * Test of getPlayerList method, of class Table.
     */
    @Test
    public void testGetPlayerList() {
        System.out.println("Testing getPlayerList");
        Table instance = new Table(1, new Deck());
        Card c = new Card("Club", "5", 5, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "10", 10, new ImageIcon(), new ImageIcon());
        instance.getPlayer().takeCard(c); 
        instance.getPlayer().takeCard(d);
        ArrayList<Player> result = instance.getPlayerList();
        assertNotNull(result);
        for(Player p : result)
            System.out.println('\t' + "Player Hand = " + p.getHand().toString()); 
    }
    
    /**
     * Test of getNumberOfPlayers method, of class Table.
     */
    @Test 
    public void testGetNumberOfPlayers() {
        System.out.println("Testing getNumberOfPlayers");
        Table instance = new Table(1, new Deck());
        assertEquals(instance.getNumberOfPlayers(), 1);
    }
    
     /**
     * Test of playerBJ method, of class Table.
     * Note hasBJ method reference back to hand class and has been previously tested
     */
    @Test
    public void testPlayerBJ() {
        System.out.println("Testing playerBJ");
        Table instance = new Table(1, new Deck());
        Card c = new Card("Club", "Ace", 1, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "King", 10, new ImageIcon(), new ImageIcon());
        instance.getPlayer().takeCard(c); 
        instance.getPlayer().takeCard(d);
        assertTrue(instance.playerBJ());
    }
    
      /**
     * Test of dealerBJ method, of class Table.
     * Note hasBJ method reference back to hand class and has been previously tested
     */
    @Test
    public void testDealerBJ() {
        System.out.println("Testing dealer BJ");
        Table instance = new Table(1, new Deck());
        Card c = new Card("Club", "Ace", 1, new ImageIcon(), new ImageIcon());
        Card d = new Card("Spade", "King", 10, new ImageIcon(), new ImageIcon());
        instance.getDealer().takeCard(c); 
        instance.getDealer().takeCard(d);
        assertTrue(instance.dealerBJ());
    }
      
}
