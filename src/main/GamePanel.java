package main;

import javax.swing.JPanel;

import entity.Player;
import entity.Grid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{

    //Set screen settings
    final int originalTileSize = 60;
    final int scale = 1;
    final int lrBorders = 0;
    final int udBorders = 0;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 15;
    final int maxScreenRow = 15;
    final int screenWidth = tileSize*maxScreenCol+lrBorders;
    final int screenHeight = tileSize * maxScreenRow+udBorders;

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);
    Grid grid = new Grid(this, maxScreenRow,maxScreenCol);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){ 
    
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null){
            
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            
            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if(timer >= 100000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }
    public void update(){
        player.update();
        //TODO: grid.update();

    }
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        grid.draw(g2);
        player.draw(g2);
        getToolkit().sync();
        g2.dispose();
    }
}