package gui;

import Games.BJGame;
import backend.Deck;
import backend.Table;

//@author bjc90_000
public class Bootstrapper {

	public static void main(String[] args) {
		System.out.println("BJ TIMEE!\n Loading...");
		Deck d = new Deck();
		Table t = new Table(1,d);
		new WindowController(t,new BJGame(t));
	}
}
