package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;


public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    boolean left = false;
    boolean up = false;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        
        x=150;
        y=100;
        speed = 4;
        direction = "right";
    }
    public void getPlayerImage(){
        try{
            leftFace = ImageIO.read(getClass().getResourceAsStream("/player/submodelLeft.png"));
            rightFace = ImageIO.read(getClass().getResourceAsStream("/player/submodelRight.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){

        if(keyH.upPressed == true){
            y -= speed;
        }
        else if(keyH.downPressed == true){
            y += speed;
        }
        else if(keyH.leftPressed == true){
            x -= speed;
        }
        else if(keyH.rightPressed == true){
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);

//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image = null;
        switch(direction) {
        case "left":
            image = leftFace;
        case "right":
            image = rightFace;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
