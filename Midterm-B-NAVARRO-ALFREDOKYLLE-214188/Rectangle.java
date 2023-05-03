//package com.company;
/**
 This class contains the rectangle. it paints rectanglular objects when called.
 @author Alfredo Kylle G Navarro (214188)
 @version April 4, 2022
 **/
/*
I have not discussed the Java language code in my program
with anyone other than my instructor or the teaching assistants
assigned to this course.
I have not used Java language code obtained from another student,
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program
was obtained from another source, such as a textbook or website,
that has been clearly noted with a proper citation in the comments
of my program.
*/
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle implements DrawingObject{
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;

    public Rectangle(int x, int y, int w, int h, Color color){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }
    /*
     The drawObject method is implemented from the DrawingObject Interface. This should draw a Rectangle which was used in the paddle class.
     */
    @Override
    public void drawObject(Graphics2D rectangle) {

        Rectangle2D.Double r1 = new Rectangle2D.Double(x,y,w,h);
        rectangle.setColor(color);
        rectangle.fill(r1);

    }
}
