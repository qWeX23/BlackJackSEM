/**
 * 
 */
package gui;

import backend.Deck;
import backend.FirstDrawCollector;
import backend.Table;

import java.util.Scanner;
import java.util.Timer;

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

		System.out.println("BJ TIME!\n Loading...");

		FirstDrawCollector mainCollector = new FirstDrawCollector(1);

		Deck d = new Deck(mainCollector);

		Table t = new Table(1,d, mainCollector);

		MainMenu main = new MainMenu(t);

		//System.out.println(t.toString());

		//t.playBlackJack();












		//System.out.println(d.drawCard());

	}

}
