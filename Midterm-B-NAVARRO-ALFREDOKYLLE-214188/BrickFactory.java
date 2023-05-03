//package com.company;

import java.awt.*;


public class BrickFactory implements DrawingObject {
    public int bricks[][];
    public int bWidth;
    public int bHeight;
    public Rectangle rectangle;

    public BrickFactory (int row, int col){
        bricks = new int[row][col];
        for(int i = 0; i < bricks.length; i++){
            for(int j=0; j< bricks[0].length; j++){
                bricks[i][j] = 1;
            }
        }
        bWidth = 867 / col;
        bHeight = 300 / row;
    }
    /*
     The drawObject method is implemented from the DrawingObject Interface. This uses the 2dimensional array which should generate
     the bricks to be destroyed. It should draw a cyan rectangle with the given specifications, which has black borders to distinguish
     each bricks.
     */
    @Override
    public void drawObject(Graphics2D brickGenerator){
        for(int i = 0; i < bricks.length; i++){
            for(int j=0; j< bricks[0].length; j++){
                if(bricks[i][j] > 0) {

                    rectangle = new Rectangle(j * bWidth + 80, i * bHeight + 50, bWidth, bHeight, Color.cyan);
                    rectangle.drawObject(brickGenerator);


                    brickGenerator.setStroke(new BasicStroke(3));
                    brickGenerator.setColor(Color.black);
                    brickGenerator.drawRect(j * bWidth + 80, i * bHeight + 50, bWidth, bHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col){
        bricks[row][col] = value;
    }
}
