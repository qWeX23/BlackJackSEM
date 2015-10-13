package backend;

import java.awt.Image;

public class Card {

	String suit,rank;
	int power,altPower;
	Image cardFront,cardBack;
	
	
	
	
	
	
	
	
	
	
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
	/**
	 * @param altPower the altPower to set
	 */
	public void setAltPower(int altPower) {
		this.altPower = altPower;
	}
	/**
	 * @return the cardFront
	 */
	public Image getCardFront() {
		return cardFront;
	}
	/**
	 * @param cardFront the cardFront to set
	 */
	public void setCardFront(Image cardFront) {
		this.cardFront = cardFront;
	}
	/**
	 * @return the cardBack
	 */
	public Image getCardBack() {
		return cardBack;
	}
	/**
	 * @param cardBack the cardBack to set
	 */
	public void setCardBack(Image cardBack) {
		this.cardBack = cardBack;
	}
	
	
	
}
