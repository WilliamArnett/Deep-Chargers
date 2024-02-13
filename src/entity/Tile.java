package entity;

import java.awt.Graphics2D;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Tile {
    GamePanel gp;
    int x,y;
    boolean isClicked;
    BufferedImage unclicked,clicked;
    public Tile(int x, int y,GamePanel gp, boolean isClicked){
        this.x = x;
        this.y = y;
        this.gp = gp;
        this.isClicked = isClicked;
        getTileImage();
    }
    public void getTileImage(){
        try{
            clicked = ImageIO.read(getClass().getResourceAsStream("/field/unfilledtile.png"));
            unclicked = ImageIO.read(getClass().getResourceAsStream("/field/filledtile.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }    
    public void click(){
        isClicked = true;
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        if(isClicked){
            image = clicked;
        }else{
            image = unclicked;
        }
        //System.out.println("Printing at "+x+","+y+". Size: ("+gp.tileSize+") is clicked? " + isClicked);
        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
    }
}
