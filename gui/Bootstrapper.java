/**
 * 
 */
package gui;

import Games.BJGame;
import backend.Deck;
import backend.Table;

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

		System.out.println("BJ TIMEE!\n Loading...");


		Deck d = new Deck();

		Table t = new Table(1,d);
		new WindowController(t,new BJGame(t));

		//MainMenu main = new MainMenu(t);

		//System.out.println(t.toString());

		//t.playBlackJack();












		//System.out.println(d.drawCard());

	}

}
