/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Theo
 */
public class Traffic {
    int y;
    int difficulty = 10;
    Boolean direction;
    int thisCar = 1;
    Boolean addCars;
    private Game game;
    int speed = (int) (Math.random() * difficulty) + 4;
    Car[] myCars = new Car[10];
    
    public Traffic (Game game, int y, Boolean direction) {
        this.game = game;
        this.y = y;
        this.direction = direction;
        for(int i = 0; i < 10; i++)
            myCars[i] = new Car(this.game, this.y, speed, this.direction);
    }
    
    public void moveCars(int x) {
        for(int i = 0; i < x; i++) {
            if(myCars[i].collision())
                game.gameOver();
            else
                myCars[i].move();
        }
            
    }
    
    void paintCars(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(int i = 0; i < 10; i++)
            myCars[i].paint(g2d);
    }
    
    public void levelUp() {
        difficulty += 1;
        speed += 1;
    }
}
