package Backend;

import backend.Card;
import backend.Deck;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class DeckTest {
    
     /**
     * Test of constructor method, of class Deck.
     */
    @Test
    public void testDeck() {
        Deck instance = new Deck();
        System.out.println("Testing Contructor");
        assertNotNull(instance);
    } 
    
      /**
     * Test of getSpecificCard method, of class Deck.
     */
    @Test
    public void testGetSpecificCard() {
        Deck instance = new Deck();
        System.out.println("Testing getSpecificCard");
        Card result = instance.getSpecificCard(51);
        System.out.println('\t' + "Card toString: " + result.toString());
        assertNotNull(result);
    }
    
     /**
     * Test of drawCard method, of class Deck.
     */
    @Test
    public void testDrawCard() {
        Deck instance = new Deck();
        System.out.println("Testing drawCard");
        Card result = instance.drawCard();
        System.out.println('\t' + "Card toString: " + result.toString());
        assertNotNull(result);   
    }   
}
