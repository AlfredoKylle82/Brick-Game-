//package com.company;
/**
 This class contains the line. It paints a line when called
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
import java.awt.geom.Line2D;

public class Line implements DrawingObject{

    private double x1;
    private double y1;
    private double x2;
    private double y2;

    private float strokeThickness;
    private Color color;

    public Line(double x1, double y1, double x2, double y2, float strokeThickness, Color color){
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;
        this.strokeThickness = strokeThickness;
        this.color = color;
    }

    /*
     The drawObject method is implemented from the DrawingObject Interface. This should draw a line when called.
     */
    @Override
    public void drawObject(Graphics2D line) {

        Line2D.Double l1 = new Line2D.Double(x1, y1, x2, y2);
        line.setStroke(new BasicStroke(strokeThickness));
        line.setColor(color);
        line.draw(l1);

    }
}
