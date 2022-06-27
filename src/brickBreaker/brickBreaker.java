package brickBreaker;

import javax.swing.*;

public class brickBreaker {

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        gamePlay gameplay = new gamePlay();
        obj.setBounds(10, 10, 710, 610);
        obj.setTitle("Breakout Ball");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);

        // System.out.println("Hello world!");
    }
}
