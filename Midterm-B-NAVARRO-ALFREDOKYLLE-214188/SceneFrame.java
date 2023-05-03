//package com.company;
/**
 This class contains the JFrame which will contain the frame, with a width of 1024 and a height of 768, of the gui program.
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

import javax.swing.*;

public class SceneFrame extends JFrame {
        SceneFrame(){
            int w = 1024;
            int h = 768;
            SceneCanvas sceneCanvas = new SceneCanvas();

            this.setSize(w,h);
            this.setTitle("Midterm Project - Navarro, Alfredo Kylle - 214188");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            this.setResizable(false);
            this.add(sceneCanvas);
            this.pack();

        }
}
