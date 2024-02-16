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
    int surroundingMines;
    boolean isClicked;
    boolean hasMine;
    BufferedImage unclicked,clicked,unclickedDanger;


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
            unclickedDanger = ImageIO.read(getClass().getResourceAsStream("/field/filledtileDanger.png"));
            unclicked = ImageIO.read(getClass().getResourceAsStream("/field/filledtile.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }    
    public void click(){
        isClicked = true;
    }
    public void draw(Graphics2D g2, BufferedImage cat){
        BufferedImage image = null;
        if(!isClicked){
            image = unclicked;
        }else if(hasMine){
            unclickedDanger = cat;
            image = unclickedDanger;
        }else{
            image = clicked;
        }
        //System.out.println("Printing at "+x+","+y+". Size: ("+gp.tileSize+") is clicked? " + isClicked);
        g2.drawImage(image,x+gp.lBorder,y+gp.uBorder,gp.tileSize,gp.tileSize,null);
        if((surroundingMines != 0) && (isClicked)){
            g2.drawString(String.valueOf(surroundingMines),(gp.lBorder+10)+x,(gp.uBorder+46)+y);
        }
    }
}
