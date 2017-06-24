/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

/**
 *
 * @author Theo
 */
public class Frog {
    int xa = 0;
    int ya = 0;
    private Game game;
    int y = 550;
    int x = 356;
    
    public Frog(Game game) {
        this.game = game;
    }
    
    public void move() {
        if(y <= 20) {
            game.nextLevel();
        }
        else{
            if(x + xa > 0 && x + xa < game.getWidth() - 10)
                x = x + xa;
            if(y + ya > 0 && y + ya < game.getHeight() - 8)
                y = y + ya; 
        } 
    }
    
    public void paint(Graphics2D g){
        g.fillRect(x, y, 10, 10);
    }
    
    public void keyReleased(KeyEvent e) {
        xa = 0;
        ya = 0;
    }
    
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -5;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 5;
        if(e.getKeyCode() == KeyEvent.VK_UP)
            ya = -5;
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            ya = 5;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 10);
    }
}
