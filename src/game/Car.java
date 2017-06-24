/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Theo
 */
public class Car {
    int x = -20;
    int y = 0;
    int speed;
    Boolean isWestBound = false;
    Image paw;
    private Game game;
    
    public Car (Game game, int y, int speed, Boolean direction) {
        this.game = game;
        this.y = y;
        this.speed = speed;
        this.isWestBound = direction;
    }
    
    void move() {
        if(isWestBound){
            if(x < 0)
                x = (game.getWidth() + 20);
            x = x - speed;
        }
        else {
            if(x > game.getWidth())
                x = -20;
            x = x + speed;
        }
    }
    
    Boolean atEnd(){
        if(x > game.getWidth())
            return true;
        else
            return false;
    }
    
    public void paint(Graphics g) {
        g.fillRect(x, y, 20, 10);
    }
    
    public boolean collision() {
        return game.frog.getBounds().intersects(getBounds());
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 20, 10);
    }
}
