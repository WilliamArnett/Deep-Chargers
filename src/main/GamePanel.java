package main;

import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Player;
import entity.Grid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
@SuppressWarnings("unused")
public class GamePanel extends JPanel implements Runnable{

    //Set screen settings
    final int originalTileSize = 60;
    final int scale = 1;
    public final int lBorder = 100;
    public final int uBorder = 150;
    public final int rBorder = 100;
    public final int dBorder = 50;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 10;
    final int maxScreenRow = 10;
    final int screenWidth = tileSize*maxScreenCol+lBorder+rBorder;
    final int screenHeight = tileSize * maxScreenRow+uBorder+dBorder;

    public int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);
    public Grid grid = new Grid(this, maxScreenRow,maxScreenCol);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.gray);
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
                //System.out.println("FPS:" + drawCount);
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
        Font font = new Font("Verdana", Font.BOLD, 50);
        g.setFont(font);
        Graphics2D g2 = (Graphics2D)g;
        grid.draw(g2);
        player.draw(g2);

        getToolkit().sync();
        g2.dispose();
    }
}