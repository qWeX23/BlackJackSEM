package backend;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Frank on 11/3/2015.
 */
public class FirstDrawCollector {
    ArrayList<ImageIcon> list;
    ArrayList<ImageIcon> listToSend;
    ArrayList<ImageIcon> temp;
    int numOfPlayers;

    public FirstDrawCollector(int i) {
        list = new ArrayList<>();
        listToSend = new ArrayList<>();
        temp = new ArrayList<>();
        numOfPlayers = i;
    }

    public void addToList(ImageIcon i) {
        list.add(i);
    }

    public void clearList() {
        list.clear();
    }

    public ArrayList<ImageIcon> getList() {
        return listToSend;
    }

    public ImageIcon getTopCard() {
        return list.get(list.size()-1);
    }

    public void sortList() {
        for (int i = 0; i < ((numOfPlayers+1)*2); i++) {
            listToSend.add(list.get(i));
            i++;
            temp.add(list.get(i));
        }
        for (ImageIcon temporary : temp) {
            listToSend.add(temporary);
        }
    }

    public void reset() {
        list.clear();
        listToSend.clear();
        temp.clear();
    }
}
