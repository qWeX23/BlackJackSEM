/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import Backend.*;
import backend.Card;
import backend.Hand;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class HandTest {
    
    Hand instance = new Hand();
    
     /**
     * Test of constructor method, of class Hand.
     */
    @Test
    public void testHand() {
         assertNotNull(instance);   
    } 

    /**
     * Test of toString method, of class Hand.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        String expResult = "Hand{" +
                    "cards=" + instance.getCards().toString() + " for a total of " + instance.calculateHandPower()+
                    '}';
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isBust method, of class Hand.
     */
    @Test
    public void testIsBust() {
        System.out.println("isBust");
        boolean expResult = false;
        boolean result = instance.isBust();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addCard method, of class Hand.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card c = null;
        instance.addCard(c);
        
    }

    /**
     * Test of getCards method, of class Hand.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        //ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getCards();
        assertNotNull(result);
        
    }

    /**
     * Test of calculateHandPower method, of class Hand.
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateHandPower() throws Exception {
        System.out.println("calculateHandPower");
        int expResult = 0;
        int result = instance.calculateHandPower();
        assertEquals(expResult, result);
        
    }
    
}
