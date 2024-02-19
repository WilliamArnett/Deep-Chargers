/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321.team6.deepchargers.entity;

import java.awt.image.BufferedImage;
public class Entity {
    
    public float x,y;
    public float speed;
    public BufferedImage leftFace,rightFace,upFace;
    public String direction;
    public boolean canMove;
    public void moveDiscrete(){
        switch(direction){
            case "up" -> this.y -= speed;
            case "down" -> this.y += speed;
            case "left" -> this.x -= speed;
            case "right" -> this.x += speed;
        }
    };
}
