package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Frank on 10/29/2015.
 */
public class PaintImages {
    int x, y;
    JPanel panel;
    ImageIcon ic;
    Image image;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(ImageIcon ic) {
        this.ic = ic;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public PaintImages(int x, int y, ImageIcon ic) {
        this.x = x;
        this.y = y;
        image = ic.getImage();
        System.out.println(ic + ")))))))))))))))))))222222222");
        image = image.getScaledInstance(70, 100, Image.SCALE_SMOOTH);
    }



}
