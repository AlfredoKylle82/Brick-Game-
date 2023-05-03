//package com.company;
/**
 This class contains the triangle. it paints triangular objects when called.
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
import java.awt.geom.Path2D;

public class Triangle implements DrawingObject{

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private Color color;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3,  Color color){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.color = color;
    }
    /*
     The drawObject method is implemented from the DrawingObject Interface. This should draw a Triangle when needed.
     */
    @Override
    public void drawObject(Graphics2D triangle) {
        Path2D.Double p = new Path2D.Double();
        p.moveTo(x1,y1);
        p.lineTo(x2,y2);
        p.lineTo(x3,y3);
        p.closePath();
        triangle.setColor(color);
        triangle.fill(p);

    }
}
