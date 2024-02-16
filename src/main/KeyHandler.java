package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean upRediclePressed, downRediclePressed, leftRediclePressed, rightRediclePressed;

    public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            if(code == KeyEvent.VK_W){
                upPressed = true;
            }
            if(code == KeyEvent.VK_S){
                downPressed = true;
            }
            if(code == KeyEvent.VK_A){
                leftPressed = true;
            }
            if(code == KeyEvent.VK_D){
                rightPressed = true;
            }
            if(code == KeyEvent.VK_I){
                upRediclePressed = true;
            }
            if(code == KeyEvent.VK_K){
                downRediclePressed = true;
            }
            if(code == KeyEvent.VK_J){
                leftRediclePressed = true;
            }
            if(code == KeyEvent.VK_L){
                rightRediclePressed = true;
            }
    }

    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_I){
            upRediclePressed = false;
        }
        if(code == KeyEvent.VK_K){
            downRediclePressed = false;
        }
        if(code == KeyEvent.VK_J){
            leftRediclePressed = false;
        }
        if(code == KeyEvent.VK_L){
            rightRediclePressed = false;
        }
    }

    public void keyTyped(KeyEvent e) {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
    
}
