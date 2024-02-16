package entity;

import main.GamePanel;
import main.KeyHandler;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Grid extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    ArrayList<Tile> grid = new ArrayList<Tile>();
    ArrayList<BufferedImage> catframes = new ArrayList<BufferedImage>();
    Random rand = new Random();
    int rows, cols;
    int minesOnGrid = 10;
    int gifFrameCounter = 0;
    String formatted;
    public int catFrame = 1;
    public Grid(GamePanel gp, int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.gp = gp;
        for(int i=0; i<this.rows; i++){
            for(int j=0; j<this.cols;j++){
                Tile newTile = new Tile(j*gp.tileSize,i*gp.tileSize,gp,false);
                //System.out.println("Tile X:"+j*gp.tileSize+" Tile Y: "+i*gp.tileSize);
                grid.add(newTile);
            }
            
        }
        for(int i=1; i<188;i++){
            formatted = "/cat/"+ String.valueOf(i)+".gif";
            System.out.println(formatted);
            try{catframes.add(ImageIO.read(getClass().getResourceAsStream(formatted)));}
            catch(IOException e){e.printStackTrace();}
        }
        // grid.get(50).click();
        // grid.get(51).click();
        // grid.get(66).click();
        // grid.get(22).hasMine = true;
        // grid.get(20).hasMine = true;
        // grid.get(10).hasMine = true;
        // grid.get(10).hasMine = true;
        if(grid.get(1).hasMine){
            grid.get(0).surroundingMines++;    
        }

        generateMines();
        calculateSurroundingMines();
    }
    public void generateMines(){
        int generatedMines = 0;
        int randomIndex;
        while(generatedMines < minesOnGrid){
            randomIndex = rand.nextInt(rows*cols);
            if(!grid.get(randomIndex).hasMine){
                grid.get(randomIndex).hasMine = true;
                generatedMines++;
            }
        }
    }
    public void calculateSurroundingMines(){

        for(int i=0; i< grid.size(); i++){
            if(!grid.get(i).hasMine){
                //if not in top row
                if(i>cols){    
                //check for mines above
                    if(grid.get(i-cols).hasMine){
                        grid.get(i).surroundingMines++;
                    }
                
                    //if not on left row, check for mines top left
                    if(i%cols != 0){  
                        if(grid.get(i-cols-1).hasMine){
                            grid.get(i).surroundingMines++;
                        }
                    }
                    //if not on right row, check for mines top right
                    if(i%cols != cols-1){  
                        if(grid.get(i-cols+1).hasMine){
                            grid.get(i).surroundingMines++;
                        }
                    }                    
                }
                //if not in bottom row
                if(i<grid.size()-cols){    
                //check for tiles below
                    if(grid.get(i+cols).hasMine){
                        grid.get(i).surroundingMines++;
                    }
                    //if not on left row, check for mines bottom left
                    if(i%cols != 0){  
                        if(grid.get(i+cols-1).hasMine){
                            grid.get(i).surroundingMines++;
                        }
                    }
                    //if not on right row, check for mines bottom right
                    if(i%cols != cols-1){  
                        if(grid.get(i+cols+1).hasMine){
                            grid.get(i).surroundingMines++;
                        }
                    }                    
                }
                //if not in left row
                if(i%cols != 0){    
                //check for tiles left
                    if(grid.get(i-1).hasMine){
                        grid.get(i).surroundingMines++;
                    }
                }
                //if not in right row
                if(i%cols != cols-1){    
                    //check for tiles right
                    if(grid.get(i+1).hasMine){
                        grid.get(i).surroundingMines++;
                    }
                }

            }
        }
    }
    public Tile returnTile(int index){
        return grid.get(index);
    }
    public void draw(Graphics2D g2){

        for(int i=0; i < grid.size(); i++){
            grid.get(i).draw(g2, catframes.get(gifFrameCounter));
        }
        gifFrameCounter++;
        if(gifFrameCounter == 187){
            gifFrameCounter = 1;
        }

    }
}
