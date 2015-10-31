/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import backend.Dealer;
import backend.Deck;
import backend.Player;
import backend.Table;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class TableTest {
    
    Table instance = new Table(1, new Deck());

    /**
     * Test of constructor method, of class Table.
     */
   @Test
    public void testTable() {
         assertNotNull(instance);   
    }

    /**
     * Test of test method, of class Table.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        instance.test();
       
    }

    /**
     * Test of dealersTurn method, of class Table.
     */
    @Test
    public void testDealersTurn() {
        System.out.println("dealersTurn");
        instance.dealersTurn();
        
    }

    /**
     * Test of playBlackJack method, of class Table. Note this method will have to be tested during actual game play.
     */
//    @Test
//    public void testPlayBlackJack() {
//        System.out.println("playBlackJack");
//        instance.playBlackJack();
//        
//    }

    /**
     * Test of reset method, of class Table.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        instance.reset();
        
    }

    /**
     * Test of toString method, of class Table.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
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
        System.out.println("playerHIt");
        instance.playerHIt();
        
    }

    /**
     * Test of playerisBust method, of class Table.
     */
    @Test
    public void testPlayerisBust() {
        System.out.println("playerisBust");
        boolean expResult = false;
        boolean result = instance.playerisBust();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of dealerisBust method, of class Table.
     */
    @Test
    public void testDealerisBust() {
        System.out.println("dealerisBust");
        boolean expResult = false;
        boolean result = instance.dealerisBust();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of playerHandPower method, of class Table.
     */
    @Test
    public void testPlayerHandPower() {
        System.out.println("playerHandPower");
        int expResult = instance.getPlayer().handPower();
        int result = instance.playerHandPower();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of deartHandPower method, of class Table.
     */
    @Test
    public void testDeartHandPower() {
        System.out.println("deartHandPower");
        int expResult = instance.getDealer().handpower();
        int result = instance.deartHandPower();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDealer method, of class Table.
     */
    @Test
    public void testGetDealer() {
        System.out.println("getDealer");
        Dealer result = instance.getDealer();
        assertNotNull(result);
        
    }

    /**
     * Test of getPlayer method, of class Table.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        Player result = instance.getPlayer();
        assertNotNull(result);
        
    }

    /**
     * Test of getPlayerList method, of class Table.
     */
    @Test
    public void testGetPlayerList() {
        System.out.println("getPlayerList");
        ArrayList<Player> result = instance.getPlayerList();
        assertNotNull(result);
        
    }
    
}
