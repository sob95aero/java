package net.homecredit.conway.swing;

import net.homecredit.conway.model.Cell;

import java.awt.*;

abstract public class SwingCell implements Cell {

    private int x = 0;
    private int y = 0;
    public static final int SIZE = 20;

    private Graphics g;

    public void setG(Graphics g) {
        this.g = g;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void showSelf() {
        if (isLiving()) {
            g.setColor(Color.white);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(x, y, SIZE, SIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, SIZE, SIZE);
    }
}
