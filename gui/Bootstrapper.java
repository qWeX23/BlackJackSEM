/**
 * 
 */
package gui;

import backend.Deck;
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

		Deck d = new Deck();

		Table t = new Table(1,d);

		System.out.println(t.toString());












		//System.out.println(d.drawCard());

	}

}
