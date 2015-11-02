package gui;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Frank on 11/2/2015.
 */
public class TestInit {
    ArrayList<ImageIcon> list;

    public TestInit() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ImageIcon("Resources\\PNG-cards-1.3\\2_of_clubs.png"));
        }
    }

    public ArrayList<ImageIcon> getList() {
        return list;
    }
}
