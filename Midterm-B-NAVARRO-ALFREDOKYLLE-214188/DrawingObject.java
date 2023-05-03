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
/*
 The drawObject interface contains the void drawObject class which will be used in drawing the other shape classes.
 */
interface DrawingObject {
    void drawObject(Graphics2D g2d);

}
