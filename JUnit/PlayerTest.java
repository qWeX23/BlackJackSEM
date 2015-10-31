/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import backend.Card;
import backend.Hand;
import backend.Player;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class PlayerTest {
    
    Player instance = new Player(new Card("Spades", "10", 10, new ImageIcon(), new ImageIcon()), new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon()));

    /**
     * Test of constructor method, of class Player.
     */
    @Test
    public void testPlayer() {
         assertNotNull(instance);   
    }
    
    /**
     * Test of takeCard method, of class Player.
     */
    @Test
    public void testTakeCard() {
        System.out.println("takeCard");
        Card c = null;
        instance.takeCard(c);
        
    }

    /**
     * Test of isBust method, of class Player.
     */
    @Test
    public void testIsBust() {
        System.out.println("isBust");
        boolean expResult = false;
        boolean result = instance.isBust();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Player{" +
                "hand=" + instance.getHand() +
                '}';
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of handPower method, of class Player.
     */
    @Test
    public void testHandPower() {
        System.out.println("handPower");
        int expResult = 21;
        int result = instance.handPower();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHand method, of class Player.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        Hand result = instance.getHand();
        assertNotNull(result);
        
    }
    
}
