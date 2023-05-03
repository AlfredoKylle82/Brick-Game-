//package com.company;
/**
 This class is the Paddle class. It should draw the paddle to be used by the player in the program.
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

public class Paddle implements DrawingObject{
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;
    private Rectangle rectangle;
    private Triangle triangle1;
    private Triangle triangle2;


    public Paddle(int x, int y, int w, int h, Color color){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    /*
     The drawObject method is implemented from the DrawingObject Interface. This should draw a rectangular paddle which the player will use for the game.
     */
    @Override
    public void drawObject(Graphics2D paddle) {
        rectangle = new Rectangle(x, y, w, h, color);
        rectangle.drawObject(paddle);

        triangle1 = new Triangle(x,y,x-20,y,x,y-20,Color.BLUE);
        triangle1.drawObject(paddle);

        triangle2 = new Triangle(x+w,y,x+w+20,y,x+w,y-20,Color.BLUE);
        triangle2.drawObject(paddle);





    }

}
