/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import backend.Card;
import backend.Deck;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class DeckTest {
    
    Deck instance = new Deck();
    
     /**
     * Test of constructor method, of class Deck.
     */
    @Test
    public void testDeck() {
         assertNotNull(instance);
    }    
    
     /**
     * Test of drawCard method, of class Deck.
     */
    @Test
    public void testDrawCard() {
        System.out.println("drawCard");
        Card result = instance.drawCard();
        assertNotNull(result);
       
    }
    
}
