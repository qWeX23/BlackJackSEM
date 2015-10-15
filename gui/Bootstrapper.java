/**
 * 
 */
package gui;

import backend.Deck;

/**
 * @author bjc90_000
 *
 */
public class Bootstrapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hello world");
		Deck d = new Deck();


		while(true)d.drawCard();

	}

}
