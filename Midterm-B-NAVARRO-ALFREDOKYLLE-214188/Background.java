//package com.company;

import java.awt.*;
import java.awt.geom.Rectangle2D;


public class Background implements DrawingObject {
    private int x;
    private int y;
    private int size;
    private Color color;

    public Background(int x, int y, int size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /*
     The drawObject method is implemented from the DrawingObject Interface. This should draw a rectangle that should cover the whole frame.
     */
    @Override
    public void drawObject(Graphics2D background) {
        Rectangle2D.Double rectangle = new Rectangle2D.Double(x,y,size,size);
        background.setColor(color);
        background.fill(rectangle);
    }
}
