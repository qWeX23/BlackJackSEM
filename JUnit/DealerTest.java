/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import Backend.*;
import backend.Card;
import backend.Dealer;
import backend.Hand;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class DealerTest {
    
    Dealer instance = new Dealer(new Card("Spades", "10", 10, new ImageIcon(), new ImageIcon()), new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon()));
    
     /**
     * Test of constructor method, of class Dealer.
     */
    @Test
    public void testDealer() {
         assertNotNull(instance);   
    }
    
    /**
     * Test of doesDealerHit method, of class Dealer.
     * @throws java.lang.Exception
     */
    @Test
    public void testDoesDealerHit() throws Exception {
        System.out.println("doesDealerHit");
        boolean expResult = false;
        boolean result = instance.doesDealerHit();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of takeCard method, of class Dealer.
     */
    @Test
    public void testTakeCard() {
        System.out.println("takeCard");
        Card card = null;
        instance.takeCard(card);
        
    }

    /**
     * Test of toString method, of class Dealer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Dealer{" +
                "hand=" + instance.getHand() +
                '}';
        String result = instance.toString();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isBust method, of class Dealer.
     */
    @Test
    public void testIsBust() {
        System.out.println("isBust");
        boolean expResult = false;
        boolean result = instance.isBust();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of handpower method, of class Dealer.
     */
    @Test
    public void testHandpower() {
        System.out.println("handpower");
        int expResult = 21;
        int result = instance.handpower();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHand method, of class Dealer.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        Hand result = instance.getHand();
        assertNotNull(result);
        
    }
    
}
