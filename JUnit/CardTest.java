/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import backend.Card;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class CardTest {
    
    Card instance = new Card("Spades", "2", 1, new ImageIcon(), new ImageIcon());

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        String expResult = "Spades";
        String result = instance.getSuit();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of setSuit method, of class Card.
     */
    @Test
    public void testSetSuit() {
        System.out.println("setSuit");
        String suit = "";
        instance.setSuit(suit);
     
    }

    /**
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        String expResult = "2";
        String result = instance.getRank();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setRank method, of class Card.
     */
    @Test
    public void testSetRank() {
        System.out.println("setRank");
        String rank = "";
        instance.setRank(rank);
        
    }

    /**
     * Test of getPower method, of class Card.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        int expResult = 1;
        int result = instance.getPower();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPower method, of class Card.
     */
    @Test
    public void testSetPower() {
        System.out.println("setPower");
        int power = 0;
        instance.setPower(power);

    }

    /**
     * Test of getAltPower method, of class Card with power of 1.
     */
    @Test
    public void testGetAltPower() {
        System.out.println("getAltPower");
        int expResult = 11;
        int result = instance.getAltPower();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getAltPower method, of class Card with power other than 1.
     */
    @Test
    public void testGetAltPower2() {
        System.out.println("getAltPower");
        Card instance1 = new Card("Spades", "2", 2, new ImageIcon(), new ImageIcon());
        int expResult = 999;
        int result = instance1.getAltPower();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Card{rank='2', suit='Spades'}";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
