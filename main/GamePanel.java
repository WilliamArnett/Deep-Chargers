package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel implements Runnable{

    //Set screen settings
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 16;
    final int screenWidth = tileSize*maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        //this.setPreferredSize(new Dimension(x,y));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){ 
    
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}