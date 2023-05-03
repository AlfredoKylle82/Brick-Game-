//package com.company;
/**
 This class contains the square. it paints square objects when called.
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

public class Square implements DrawingObject{

    private double x;
    private double y;
    private double size;
    private Color color;

    public Square(double x, double y, double size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
    /*
     The drawObject method is implemented from the DrawingObject Interface. This should draw a square which was used in the Emoji class.
     */
    @Override
    public void drawObject(Graphics2D square) {

        Rectangle2D.Double rectangle = new Rectangle2D.Double(x,y,size,size);
        square.setColor(color);
        square.fill(rectangle);

    }
}
