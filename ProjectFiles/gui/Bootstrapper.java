package gui;

import Games.BJGame;
import Games.Basics;
import backend.Deck;
import backend.Table;

//@author bjc90_000
public class Bootstrapper {

	public static void main(String[] args) {
		System.out.println("BJ TIMEE!\n Loading...");
		Deck d = new Deck();
		Table t = new Table(1,d);
		new WindowController(t,new BJGame(t),new Basics(t));
	}
}
