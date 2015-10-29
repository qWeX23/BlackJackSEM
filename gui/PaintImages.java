package gui;

import javax.swing.*;

/**
 * Created by Frank on 10/29/2015.
 */
public class PaintImages {
    double x, y;
    JPanel panel;
    ImageIcon image;

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public double getX() {

        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public PaintImages(double x, double y, ImageIcon image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }



}
