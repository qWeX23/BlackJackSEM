package backend;

import javax.swing.*;
import java.io.Serializable;

public class Card implements Serializable{

	String suit,rank;
	int power,altPower;
	ImageIcon cardFront,cardBack;


	public Card(String suit, String rank, int power,  ImageIcon cardFront, ImageIcon cardBack) {
		this.suit = suit;
		this.rank = rank;
		this.power = power;
		if(power==1)altPower=11;
				else altPower= 999;
		this.cardFront = cardFront;
		this.cardBack = cardBack;
	}

	//########### getters and setters ###########
	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}
	/**
	 * @param suit the suit to set
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}
	/**
	 * @param power the power to set
	 */
	public void setPower(int power) {
		this.power = power;
	}
	/**
	 * @return the altPower
	 */
	public int getAltPower() {
		return altPower;
	}

	@Override
	public String toString() {
		return "Card{" +
				"rank='" + rank + '\'' +
				", suit='" + suit + '\'' +
				'}';
	}
}
