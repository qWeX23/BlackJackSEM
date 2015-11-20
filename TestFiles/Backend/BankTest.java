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
        Bank instance = new Bank();
        System.out.println("Testing Constructor");
        assertNotNull(instance);    
    } 
    
    /**
     * Test of winBet method, of class Bank.
     */
    @Test
    public void testWinBet() {
        System.out.println("Testing winBet");
        Bank.setBalance(100);
        Bank.winBet(10, 1);
        assertEquals(Bank.getBalance(), 110);
    }

    /**
     * Test of loseBet method, of class Bank.
     */
    @Test
    public void testLoseBet() {
        System.out.println("Testing loseBet");
        Bank.setBalance(100);
        Bank.placeBet(10);
        Bank.loseBet();
        assertEquals(Bank.getBalance(), 90);    
    }

    /**
     * Test of placeBet method, of class Bank.
     */
    @Test
    public void testPlaceBet() {
        System.out.println("Testing placeBet");
        Bank.setBalance(100);
        assertFalse(Bank.placeBet(105));
        assertTrue(Bank.placeBet(10));
        assertEquals(Bank.getCurrentBet(), 10);
    }

    /**
     * Test of isemptyBank method, of class Bank.
     */
    @Test
    public void testIsemptyBank() {
        System.out.println("Testing isemptyBank"); 
        Bank.setBalance(100);
        assertFalse(Bank.isemptyBank());
        Bank.setBalance(0);
        assertTrue(Bank.isemptyBank());         
    }
   
    /**
     * Test of getBalance method, of class Bank.
     */
    @Test
    public void testGetBalance() {
        System.out.println("Testing getBalance");
        Bank.setBalance(100);
        assertEquals(Bank.getBalance(), 100);     
    }
    
    /**
     * Test of setBalance method, of class Bank.
     */
    @Test
    public void testSetBalance() {
        System.out.println("Testing setBalance");   
        Bank.setBalance(200);
        assertEquals(Bank.getBalance(), 200);
    }
    
    /**
     * Test of getCurrentBet method, of class Bank.
     */
    @Test
    public void testGetCurrentBet() {
        System.out.println("Testing getCurrentBet");
        Bank.setBalance(100);
        Bank.placeBet(10);
        assertEquals(Bank.getCurrentBet(), 10);
    }
    
    /**
     * Test of setCurrentBet method, of class Bank.
     */
    @Test
    public void testSetCurrentBet() {
        System.out.println("Testing setCurrentBet");
        Bank.setBalance(100);
        Bank.placeBet(10);
        Bank.setCurrentBet(5);
        assertEquals(Bank.getCurrentBet(), 5);
    }
}

