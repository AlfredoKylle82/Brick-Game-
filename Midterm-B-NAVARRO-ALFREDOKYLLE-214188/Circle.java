//package com.company;
/**
 This class contains the interface. it implements the drawing object graphics 2d when called to the other shape classes.
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
import java.awt.geom.Ellipse2D;

public class Circle implements DrawingObject {

    private int x;
    private int y;
    private int size;
    private Color color;



    public Circle(int x, int y, int size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /*
     The drawObject method is implemented from the DrawingObject Interface. This should draw the circle when called.
     */
    @Override
    public void drawObject(Graphics2D circle) {
        Ellipse2D.Double e1 = new Ellipse2D.Double(x,y,size,size);
        circle.setColor(color);
        circle.fill(e1);

    }
}
