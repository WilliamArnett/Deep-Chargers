/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321.team6.deepchargers.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;

import cs321.team6.deepchargers.GamePanel;
import cs321.team6.deepchargers.KeyHandler;


public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    int moveTimer = 60;
    boolean canMove = true;
    BufferedImage image;
    int drawX, drawY;
    int subGridX = 3;
    int subGridY = 2;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        getPlayerImage();
        setDefaultValues();

    }
    public void setDefaultValues(){
        
        x=180;
        y=120;
        speed = 2*gp.tileSize/gp.FPS;
        direction = "right";
        keyH.upPressed = false;
        keyH.downPressed = false;
        keyH.leftPressed = false;
        keyH.rightPressed = false;
        image = rightFace;
    }
    public void getPlayerImage(){
        try{
            leftFace = ImageIO.read(getClass().getResourceAsStream("/player/submodelLeft.png"));
            rightFace = ImageIO.read(getClass().getResourceAsStream("/player/submodelRight.png"));
            upFace = ImageIO.read(getClass().getResourceAsStream("/player/unfilledtile.png"));
            System.out.println("Fetched!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void fire(int gridSquareX, int gridSquareY){
        gp.grid.returnTile(gridSquareY*gp.maxScreenCol+gridSquareX).click();
    }
    public void update(){
        //System.out.println(moveTimer);
        if(moveTimer < gp.FPS/2){
            moveDiscrete();
            moveTimer++;
        }else{
            direction = "none";
            canMove = true;
        }
        if(canMove){
            if(keyH.upPressed == true){
                direction = "up";
                canMove = false;
                moveTimer = 0;
                subGridY--;
            }
            else if(keyH.downPressed == true){
                direction = "down";
                canMove = false;
                moveTimer = 0;
                subGridY++;
            }
            else if(keyH.leftPressed == true){
                direction = "left";
                canMove = false;
                moveTimer = 0;
                subGridX--;
            }
            else if(keyH.rightPressed == true){
                direction = "right";

                canMove = false;
                moveTimer = 0;
                subGridX++;
            }
            else if(keyH.upRediclePressed == true){
                fire(subGridX,subGridY-1);
            }
            else if(keyH.downRediclePressed == true){
                fire(subGridX,subGridY+1);    
            }
            else if(keyH.leftRediclePressed == true){
                fire(subGridX-1,subGridY);    
            }
            else if(keyH.rightRediclePressed == true){
                fire(subGridX+1,subGridY);
            }

        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);

//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        /* */
        switch(direction) {
        case "left":
            image = leftFace;
            //System.out.println(direction);
            break;
        case "right":
            image = rightFace;
            //System.out.println(direction);
            break;
        }
        drawX = (int) x+gp.lBorder;
        drawY = (int) y+gp.uBorder;
        //System.out.println("("+subGridX+", "+subGridY+")");
        g2.drawImage(image, drawX, drawY, gp.tileSize, gp.tileSize, null);
    }

}
