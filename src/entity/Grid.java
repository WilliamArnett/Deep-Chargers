package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Grid extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    ArrayList<Tile> grid = new ArrayList<Tile>();
    int rows, cols;
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
        grid.get(50).click();
        grid.get(51).click();
        grid.get(66).click();
    }
    public Tile returnTile(int index){
        return grid.get(index);
    }
    public void draw(Graphics2D g2){
        for(int i=0; i < grid.size(); i++){
            grid.get(i).draw(g2);
        }

    }
}
