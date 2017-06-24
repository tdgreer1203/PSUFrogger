/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Theo
 */
@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener{
    Traffic row1 = new Traffic(this, 380, false);   
    Traffic row2 = new Traffic(this, 360, true);
    Traffic row3 = new Traffic(this, 100, false);
    Traffic row4 = new Traffic(this, 120, true);
    Traffic row5 = new Traffic(this, 240, true);
    Traffic row6 = new Traffic(this, 260, false);
    Timer clock = new Timer(3000, this);
    Frog frog = new Frog(this);
    int current = 1;
    
    public Game() {
            addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                frog.keyReleased(e);
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                frog.keyPressed(e);
            }
        });
        setFocusable(true);
    }
    void move(int x) {
        row1.moveCars(x);
        row2.moveCars(x);
        row3.moveCars(x);
        row4.moveCars(x);
        row5.moveCars(x);
        row6.moveCars(x);
        frog.move();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        row1.paintCars(g2d);
        row2.paintCars(g2d);
        row3.paintCars(g2d);
        row4.paintCars(g2d);
        row5.paintCars(g2d);
        row6.paintCars(g2d);
        frog.paint(g2d);
        clock.start();
    }
    
    public void gameOver() {
        frog.x = 356;
        frog.y = 550;
    }
    
    public void nextLevel() {
        JOptionPane.showMessageDialog(this, "CONGRATS!!! You've made it to the next level.");
        row1.levelUp();
        row2.levelUp();
        row3.levelUp();
        row4.levelUp();
        row5.levelUp();
        row6.levelUp();
        this.gameOver();
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("PSU Frogger");
        Game game = new Game();
        frame.add(game);
        frame.setSize(712, 612);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            game.move(game.current);
            game.repaint();
            Thread.sleep(100);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.move(this.current);
        if (current < 10)
            current++;
        this.repaint();
        revalidate();
    }
}
