//package com.company;
/**
 This class is the Emoji class. It contains the ball which would be used to collide with the bricks.
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
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.time.Year;

public class Emoji implements DrawingObject{
    private int x;
    private int y;
    private int size;
    private Color headColor;
    private Color shadesColor;
    private Color mouthColor;
    private Circle head;
    private Line shadeLine;
    private Square shadeSquare1;
    private Square shadeSquare2;

    /*
     The constructor of the Emoji class. It accepts int x, y, and size, and also the colors of the head, shades, and mouth, which would be used
     in creating the head of the emoji.
     */
    public Emoji(int x, int y, int size, Color headColor, Color shadesColor, Color mouthColor){

        this.x = x;
        this.y = y;
        this.size = size;
        this.headColor = headColor;
        this.shadesColor = shadesColor;
        this.mouthColor = mouthColor;
    }
    /*
     The drawObject method is implemented from the DrawingObject Interface. This should draw the emoji.
     */
    @Override
    public void drawObject(Graphics2D emoji) {


        head = new Circle(x,y,size, headColor);
        head.drawObject(emoji);

        shadeLine = new Line(x,y+size*.35,x+size,y+size*.35,2, shadesColor);
        shadeLine.drawObject(emoji);

        shadeSquare1 = new Square(x+size*.2,y+size*.3, size*.3, Color.GRAY);
        shadeSquare1.drawObject(emoji);

        shadeSquare2 = new Square(x+size*.6,y+size*.3, size*.3, Color.GRAY);
        shadeSquare2.drawObject(emoji);

        Path2D.Double mouth = new Path2D.Double();
        mouth.moveTo(x+size*.5-size*.15,y+size*.5+size*.1);
        mouth.curveTo(x+size*.5-size*.1,y+size*.5+size*.2,x+size*.5+size*.1,y+size*.5+size*.2,x+size*.5+size*.15,y+size*.5+size*.1);
        emoji.setColor(mouthColor);
        emoji.draw(mouth);



    }
}
