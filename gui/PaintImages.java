package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Frank on 10/29/2015.
 */
public class PaintImages {
    private int x, y;
    private Image image;

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public PaintImages(int x, int y, ImageIcon ic) {
        this.x = x;
        this.y = y;
        image = ic.getImage();
        image = image.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
    }

    public void setImage(ImageIcon ic) {
        image = ic.getImage();
        image = image.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
    }
}
