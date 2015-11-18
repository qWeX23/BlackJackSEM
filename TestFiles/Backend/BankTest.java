package Backend;

import backend.Bank;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class BankTest {
    
    /**
     * Test of constructor method, of class Bank.
     */
    @Test
    public void testBank() {
        Bank instance = new Bank(100);
        System.out.println("Testing Constructor");
        assertNotNull(instance);    
    } 
    
    /**
     * Test of winBet method, of class Bank.
     */
    @Test
    public void testWinBet() {
        Bank instance = new Bank(100);
        System.out.println("Testing winBet");
        instance.placeBet(10);
        instance.winBet(1);
        assertEquals(instance.getBalance(), 110);
    }

    /**
     * Test of loseBet method, of class Bank.
     */
    @Test
    public void testLoseBet() {
        Bank instance = new Bank(100);
        System.out.println("Testing loseBet");
        instance.placeBet(10);
        instance.loseBet();
        assertEquals(instance.getBalance(), 90);    
    }

    /**
     * Test of placeBet method, of class Bank.
     */
    @Test
    public void testPlaceBet() {
        Bank instance = new Bank(100);
        System.out.println("Testing placeBet");
        assertFalse(instance.placeBet(105));
        assertTrue(instance.placeBet(10));
        assertEquals(instance.getCurrentBet(), 10);
    }

    /**
     * Test of isemptyBank method, of class Bank.
     */
    @Test
    public void testIsemptyBank() {
        System.out.println("Testing isemptyBank");
        Bank instance = new Bank(100);
        assertFalse(instance.isemptyBank());
        instance = new Bank(0);
        assertTrue(instance.isemptyBank());         
    }
   
    /**
     * Test of getBalance method, of class Bank.
     */
    @Test
    public void testGetBalance() {
        System.out.println("Testing getBalance");
        Bank instance = new Bank(100);
        assertEquals(instance.getBalance(), 100);     
    }
    
    /**
     * Test of setBalance method, of class Bank.
     */
    @Test
    public void testSetBalance() {
        System.out.println("Testing setBalance");
        Bank instance = new Bank(100);
        instance.setBalance(200);
        assertEquals(instance.getBalance(), 200);
    }
    
    /**
     * Test of getCurrentBet method, of class Bank.
     */
    @Test
    public void testGetCurrentBet() {
        System.out.println("Testing getCurrentBet");
        Bank instance = new Bank(100);
        instance.placeBet(10);
        assertEquals(instance.getCurrentBet(), 10);
    }
    
    /**
     * Test of setCurrentBet method, of class Bank.
     */
    @Test
    public void testSetCurrentBet() {
        System.out.println("Testing setCurrentBet");
        Bank instance = new Bank(100);
        instance.placeBet(10);
        instance.setCurrentBet(5);
        assertEquals(instance.getCurrentBet(), 5);
    }
}

