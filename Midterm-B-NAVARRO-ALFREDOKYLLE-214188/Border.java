//package com.company;

import java.awt.*;



public class Border implements DrawingObject {
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private Rectangle rectangle3;

    public Border(int x, int y, int w, int h, Color color){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    /*
     The drawObject method is implemented from the DrawingObject Interface. This should draw a border for the frame.
     */
    @Override
    public void drawObject(Graphics2D border) {

        rectangle1 = new Rectangle(x, y, w, h, color);
        rectangle2 = new Rectangle(x,y,w+1024,h-765,color);
        rectangle3 = new Rectangle(x+1021,y,w,h,color);

        rectangle1.drawObject(border);
        rectangle2.drawObject(border);
        rectangle3.drawObject(border);

    }
}

