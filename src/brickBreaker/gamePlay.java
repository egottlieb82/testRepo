package brickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gamePlay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;

    private int totalBricks = 21;

    private Timer timer;
    private int delay = 1;

    private int playerX = 285;
    private int playerXstart = playerX;

    private int ballposX = 350;
    private int ballposXstart = ballposX;
    private int ballposY = 525;
    private int ballposYstart = ballposY;
    private int ballXdir = -2;
    private int ballXdirStart = ballXdir;
    private int ballYdir = -4;
    private int ballYdirStart = ballYdir;

    private int startCounter = 0;

    private mapGenerator map;

    public gamePlay() {
        map = new mapGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        // Background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        // Drawing map
        map.draw((Graphics2D)g);

        // Borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        // Scores
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString(""+score, 590, 30);

        // Paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 150, 8);

        // Ball
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20, 20);

        if (totalBricks <= 0) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            startCounter = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Win!",  260, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Continue", 230, 350);

        }

        if (ballposY > 570) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            startCounter = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, Score: " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 350);

        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (startCounter == 1) {
            ballXdir = -2;
            startCounter += 2;
        } else if (startCounter == 2) {
            ballXdir = 2;
            startCounter += 2;
        }

        if (play) {
            Rectangle ballCheck = new Rectangle(ballposX, ballposY, 20, 20);
            if (ballCheck.intersects(new Rectangle(playerX, 550, 150, 8))) {
                ballYdir = -ballYdir;
                if (ballposX + 9 <= playerX + 74) {
                    ballXdir = -2;
                } else {
                    ballXdir = 2;
                }
            }

            A: for (int i=0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickX = j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;

                        if(ballRect.intersects(brickRect)) {
                            map.setBrickValue(0,i,j);
                            totalBricks--;
                            score += 5;

                            if (ballposX + 18 <= brickRect.x || ballposX + 2 >= brickRect.x + brickRect.width) {
                                ballXdir = -ballXdir;
                            } else {
                                ballYdir = -ballYdir;
                            }

                            break A;
                        }
                    }
                }
            }

            ballposX += ballXdir;
            ballposY += ballYdir;
            if (ballposX < 0 ) {
                ballXdir = -ballXdir;
            }
            if (ballposY < 0 ) {
                ballYdir = -ballYdir;
            }
            if (ballposX > 670 ) {
                ballXdir = -ballXdir;
            }
        }

        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            startCounter += 1;
            if (playerX >= 550) {
                playerX = 550;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            startCounter += 2;
            if (playerX <= 0) {
                playerX = 0;
            } else {
                moveLeft();
            }
        }
//        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            ballXdir = ballXdir * 2;
//            ballYdir = ballYdir * 2;
//        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                // play = true;
                ballposX = ballposXstart;
                ballposY = ballposYstart;
                ballXdir = ballXdirStart;
                ballYdir = ballYdirStart;
                playerX = playerXstart;
                if (totalBricks > 0) {
                    score = 0;
                }
                totalBricks = 21;
                map = new mapGenerator(3,7);

                repaint();
            }
        }
    }

    public void moveRight() {
        play = true;
        playerX+=20;
    }

    public void moveLeft() {
        play = true;
        playerX-=20;
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            ballXdir = ballXdir / 2;
//            ballYdir = ballYdir / 2;
//        }
    }
}
