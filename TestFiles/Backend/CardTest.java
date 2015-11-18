package Backend;

import backend.Card;
import java.io.IOException;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Lee K. Mills
 */
public class CardTest {
    
     /**
     * Test of constructor method, of class Card.
     */
    @Test
    public void testCard() {
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon());
        System.out.println("Testing cardConstructor");
        assertNotNull(instance);    
    }  

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon());
        System.out.println("Testing getSuit");
        String result = instance.getSuit();
        assertEquals("Spades", result);
    }

    /**
     * Test of setSuit method, of class Card.
     */
    @Test
    public void testSetSuit() {
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon());
        System.out.println("Testing setSuit");
        instance.setSuit("Clubs");
        assertEquals("Clubs", instance.getSuit());
    }

    /**
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRank() {
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon());  
        System.out.println("Testing getRank");
        String result = instance.getRank();
        assertEquals("ACE", result);  
    }

    /**
     * Test of setRank method, of class Card.
     */
    @Test
    public void testSetRank() {
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon());
        System.out.println("Testing setRank");
        instance.setRank("10");
        assertEquals("10", instance.getRank());
    }

    /**
     * Test of getPower method, of class Card.
     */
    @Test
    public void testGetPower() {
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon());
        System.out.println("Testing getPower");
        int result = instance.getPower();
        assertEquals(1, result);   
    }

    /**
     * Test of setPower method, of class Card.
     */
    @Test
    public void testSetPower() {
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon());
        System.out.println("Testing setPower");
        instance.setPower(2);
        assertEquals(2, instance.getPower());
    }
    
    /**
     * Test of getCardFront method, of class Card.
     * @throws java.io.IOException
     */
    @Test
    public void testGetCardFront() throws IOException {
        //Provide a local path to resources used
        ImageIcon test = new ImageIcon("C:\\Users\\Shannon Murphy\\Documents\\GitHub\\myBlackJackSIM\\Resources\\PNG-cards-1.3\\10_of_clubs.png");
        Card instance = new Card("Spades", "ACE", 1, test, new ImageIcon());
        System.out.println("Testing getCardFront");
        System.out.println('\t' + "Card Front toString = " + instance.getCardFront().toString());
        assertNotNull(instance.getCardFront()); 
    }

    /**
     * Test of setCardFront method, of class Card.
     * @throws java.io.IOException
     */
    @Test
    public void testSetCardFront() throws IOException {
        ImageIcon test = new ImageIcon("C:\\Users\\Shannon Murphy\\Documents\\GitHub\\myBlackJackSIM\\Resources\\PNG-cards-1.3\\10_of_clubs.png");
        ImageIcon test1 = new ImageIcon("C:\\Users\\Shannon Murphy\\Documents\\GitHub\\myBlackJackSIM\\Resources\\PNG-cards-1.3\\5_of_hearts.png");
        Card instance = new Card("Spades", "ACE", 1, test, new ImageIcon());
        System.out.println("Testing setCardFront");
        System.out.println('\t' + "Card Front toString before setting = " + instance.getCardFront().toString());
        instance.setCardFront(test1);
        System.out.println('\t' + "Card Front toString after setting = " + instance.getCardFront().toString());
        assertNotNull(instance.getCardFront());  
    }
    
        /**
     * Test of getCardBack method, of class Card.
     * @throws java.io.IOException
     */
    @Test
    public void testGetCardBack() throws IOException {
        //Provide a local path to resources used
        ImageIcon test = new ImageIcon("C:\\Users\\Shannon Murphy\\Documents\\GitHub\\myBlackJackSIM\\Resources\\BlackJackSnip.GIF");
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), test);
        System.out.println("Testing getCardBack");
        System.out.println('\t' + "Card Back toString = " + instance.getCardBack().toString());
        assertNotNull(instance.getCardBack()); 
    }

    /**
     * Test of setCardBack method, of class Card.
     * @throws java.io.IOException
     */
    @Test
    public void testSetCardBack() throws IOException {
        ImageIcon test = new ImageIcon("C:\\Users\\Shannon Murphy\\Documents\\GitHub\\myBlackJackSIM\\Resources\\BlackJackSnip.GIF");
        ImageIcon test1 = new ImageIcon("C:\\Users\\Shannon Murphy\\Documents\\GitHub\\myBlackJackSIM\\Resources\\PNG-cards-1.3\\5_of_hearts.png");
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), test);
        System.out.println("Testing setCardBack");
        System.out.println('\t' + "Card Back toString before setting = " + instance.getCardBack().toString());
        instance.setCardBack(test1);
        System.out.println('\t' + "Card Back toString after setting = " + instance.getCardBack().toString());
        assertNotNull(instance.getCardBack()); 
    }
    
    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        Card instance = new Card("Spades", "ACE", 1, new ImageIcon(), new ImageIcon());
        System.out.println("Testting toString");
        String expResult = "Card{rank='ACE', suit='Spades'}";
        assertEquals(expResult, instance.toString());    
    }
     
}

