package entity;

import java.awt.image.BufferedImage;
public class Entity {
    
    public float x,y;
    public float speed;
    public BufferedImage leftFace,rightFace,upFace;
    public String direction;
    public boolean canMove;
    public void moveDiscrete(){
        switch(direction){
            case "up":
                this.y -= speed;
                break;
            case "down":
                this.y += speed;
                break;
            case "left":
                this.x -= speed;
                break;
            case "right":
                this.x += speed;
                break;
        }
    };
}
