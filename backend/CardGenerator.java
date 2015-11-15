package backend;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static javax.imageio.ImageIO.read;

/**
 * Created by bjc90_000 on 10/19/2015.
 */
public class CardGenerator {

    public static final String[] SUITS = {"Spades", "Diamonds", "Clubs", "Hearts"};
    public static final String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public static void main(String[] args) {

        Card[] c = new Card[52];
        try {
          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Cards.bj"));
            ImageIcon front;
            int power, index = 0;
            ImageIcon back = new ImageIcon(read(new File("C:/Users/bjc90_000/Downloads/JackBlack.jpg")));

            for (String s : SUITS) {
                power = 1;
                for (String r : RANKS) {
                    if (r.equals("Jack") || r.equals("Queen") || r.equals("King"))
                        front = new ImageIcon(read(new File("C:/Users/bjc90_000/Documents/GitHub/BlackJackSEM/Resources/PNG-cards-1.3/" + r.toLowerCase() + "_of_" + s.toLowerCase() + "2.png")));
                    else
                        front = new ImageIcon(read(new File("C:/Users/bjc90_000/Documents/GitHub/BlackJackSEM/Resources/PNG-cards-1.3/" + r.toLowerCase() + "_of_" + s.toLowerCase() + ".png")));
                    c[index] = new Card(s, r, power, front, back);
                    //System.out.println(c[index].toString()+"is at index->" +index);
                    System.out.println("Created"+c[index].toString());
                    if (power < 10) power++;
                    index++;
                }
            }
          out.writeObject(c);
          out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
