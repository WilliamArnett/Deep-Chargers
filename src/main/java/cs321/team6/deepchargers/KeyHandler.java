/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs321.team6.deepchargers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean upRediclePressed, downRediclePressed, leftRediclePressed, rightRediclePressed;

    public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            switch (code){
                case KeyEvent.VK_W:
                    upPressed = true;
                    break;
                case KeyEvent.VK_S:
                    downPressed = true;
                    break;
                case KeyEvent.VK_A:
                    leftPressed = true;
                    break;
                case KeyEvent.VK_D:
                    rightPressed = true;
                    break;
                case KeyEvent.VK_I:
                    upRediclePressed = true;
                    break;
                case KeyEvent.VK_K:
                    downRediclePressed = true;
                    break;
                case KeyEvent.VK_J:
                    leftRediclePressed = true;
                    break;
                case KeyEvent.VK_L:
                    rightRediclePressed = true;
                    break;
            }

    }

    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        switch (code){
            case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
            case KeyEvent.VK_I:
                upRediclePressed = false;
                break;
            case KeyEvent.VK_K:
                downRediclePressed = false;
                break;
            case KeyEvent.VK_J:
                leftRediclePressed = false;
                break;
            case KeyEvent.VK_L:
                rightRediclePressed = false;
                break;
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

