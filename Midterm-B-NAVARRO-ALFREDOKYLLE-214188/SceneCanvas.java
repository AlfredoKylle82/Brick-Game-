//package com.company;
/**
 This class contains the Canvas of the program. It paints the necessary shapes which was created in different classes, and updates and repaints if
 an animation logic is included.
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
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.util.Random;


public class SceneCanvas extends JComponent implements KeyListener, ActionListener {
    /*
     The variable needed for the class is declared here, with some having constant values;
     */

    private Emoji ball;
    private Background b;
    private Border b2;
    private Paddle p;
    private Random randNum;

    public boolean leftPressed,rightPressed;

    private boolean play = false;
    private int score = 0;

    private int totalBricks = 300;

    private Timer timer;
    private int delay = 8;

    public int paddleX = 512;
    public int line1X = 512;
    public int line2X= 512;
    public int line1Y = 512;
    public int line2Y= 512;


    public int ballpositionX = 512;
    public int ballpositionY = 680;
    public int balldirectionX;
    public int balldirectionY;

    private BrickFactory map;

    /*
     This is the constructor of the class. This is where the important shapes and values are instantiated.
     */
    public SceneCanvas(){
        randNum = new Random(99);
        balldirectionX = -randNum.nextInt(7);
        balldirectionY = -randNum.nextInt(7);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    /*
        This creates and instantiates the Timer from java swing. It initializes the initial delay and between-event delay
        to delay milliseconds. Something similar to thread
     */
        timer = new Timer(delay, this);
        timer.start();


        this.setPreferredSize(new Dimension(1024,768));
        ball = new Emoji(ballpositionX, ballpositionY, 2,Color.YELLOW, Color.DARK_GRAY, Color.RED);
        b = new Background(0,0,1024, Color.BLACK);
        b2 = new Border(0,0,3,768, Color.GREEN);
        p = new Paddle(paddleX, 750, 150, 8, Color.green);
        map = new BrickFactory(15, 20);

    }
    /*
     This calls the paintComponent method of the JComponent class, which was called in this class in order to draw the shapes.
     */
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
    /*
     Anti-aliasing is used here.
     */
        RenderingHints rh = new RenderingHints (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
    /*
     These are called again in order to keep updating the screen whenever it gets repainted.
     */
        b2 = new Border(0,0,3,768, Color.GREEN);
        p = new Paddle(paddleX, 750, 150, 8, Color.green);
        ball = new Emoji(ballpositionX,ballpositionY,25,Color.YELLOW, Color.DARK_GRAY, Color.RED);

    /*
     This is where the objects were drawn.
     */
        b.drawObject(g2d);
        ball.drawObject(g2d);
        b2.drawObject(g2d);
        p.drawObject(g2d);
        map.drawObject(g2d);
    /*
     All if/else used in this methods are to draw a certain type of string whenever the conditions for finishing the game is met.
     */
        if(totalBricks <= 0){
            play = false;
            balldirectionX = 0;
            balldirectionY = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("Dialog",Font.BOLD, 30));
            g.drawString("Good Game! Your Score: ", 512, 650);

            g.setFont(new Font("Dialog",Font.BOLD,30));
            g.drawString("Press Enter to Play again", 512, 750);
        }


        if (ballpositionY > 760){
            play = false;
            balldirectionX = 0;
            balldirectionY = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("Dialog",Font.BOLD, 30));
            g.drawString("Nice Try! Your Score: " + score, 512, 650);

            g.setFont(new Font("Dialog",Font.BOLD,30));
            g.drawString("Press Enter to Play again ", 512, 700);
        }
        g2d.dispose();
    }

    /*
     This method is automatically called. The parameters here are invoked when certain actions are met, one of which is collision.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    /*
     When the timer starts, it sends the action events to the listeners.
     */
        timer.start();
    /*
     This contains the logic of the collision. new Rectangles acting as the "hitboxes" were created, and it bounces the emoji back if its hitbox collides with the
     paddle's hitbox. The hitboxes are the invisible rectangles following the paddle's X and ball's x and y position.
     */
        if(play) {
            if(new Rectangle(ballpositionX,ballpositionY,25,25).intersects(new Rectangle(paddleX, 750, 150, 8))) {
                balldirectionY = -balldirectionY;
            }

    /*
     This also contains the logic of the collision. for each row and columns, it creates hitboxes for the bricks. and the ball
     */
            A: for(int i = 0; i < map.bricks.length; i ++){
                 for(int j = 0; j<map.bricks[0].length; j ++){
                    if(map.bricks[i][j]>0){
                        int brickPositionX = j * map.bWidth + 80;
                        int brickPositionY = i * map.bHeight + 50;
                        int brickWidth = map.bWidth;
                        int brickHeight = map.bHeight;

                       Rectangle rect = new Rectangle(brickPositionX, brickPositionY,brickWidth,brickHeight);
                       Rectangle ballHitbox = new Rectangle(ballpositionX, ballpositionY, 20, 20);
                       Rectangle brickHitbox = rect;
    /*
     This contains the logic of the collision. new Rectangles acting as the "hitboxes" were created, and it bounces the emoji back if its hitbox collides with the
     paddle's hitbox. The hitboxes are the invisible rectangles following the paddle's X and ball's x and y position.
     */
                        if(ballHitbox.intersects(brickHitbox)){
                            map.setBrickValue(0, i, j);
                            // When the brick value are set to 0, it removes the element from the 2 dimensional list.
                            totalBricks --;
                            score +=5;
                            if(ballpositionX + 19 <= brickHitbox.x || ballpositionX + 1 >= brickHitbox.x + brickHitbox.width){
                                balldirectionX = -balldirectionX;
                            } else {
                                balldirectionY = -balldirectionY;
                            }

                            brickHitbox.setRect(0,0,0,0);
                            break A;
                        }
                    }
                }
            }
    /*
     this updates the ball
     */
            ballpositionX += balldirectionX;
            ballpositionY += balldirectionY;
            if(ballpositionX < 3){
                balldirectionX = -balldirectionX;
            }
            if(ballpositionY < 3){
                balldirectionY = -balldirectionY;
            }
            if(ballpositionX > 1020){
                balldirectionX = -balldirectionX;
            }
        }

        repaint();

    }
/*
 wasnt used but is required since keyListeners were implemented.
 */
    @Override
    public void keyTyped(KeyEvent e) {

    }
    /*
     This performs the actions when left and right keys are pressed.
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
            if (paddleX > 900) {
                paddleX = 900;
            } else {
                moveRight();
            }

        }
        if(code == KeyEvent.VK_LEFT){
            leftPressed = true;
            if (paddleX < 10) {
                paddleX = 10;
            } else {
                moveLeft();
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                ballpositionX = 512;
                ballpositionY = 680;
                balldirectionX = -randNum.nextInt(7)-2;
                balldirectionY = -randNum.nextInt(7)-2;
                paddleX = 310;
                score = 0;
                totalBricks = 300;
                map = new BrickFactory(15, 20);
                repaint();
            }
        }
    }
    /*
     this method is called above, it moves the paddle's X by 40 left and right
     */
    public void moveRight(){
        play = true;
        paddleX = paddleX + 40;
    }

    public void moveLeft(){
        play = true;
        paddleX = paddleX - 40;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
