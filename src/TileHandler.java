import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileHandler {

    GamePanel p;
    Tile[] t;
    public int map_tile_number[][];

    TileHandler(GamePanel p){
        this.p = p;
        t = new Tile[12];
        map_tile_number = new int[p.grid_columns][p.grid_rows];

        getTileImage();
        loadMap();
    }

    public void getTileImage(){

        try{
            t[0] = new Tile();
            t[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/sand.png"));

            t[1] = new Tile();
            t[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall.png"));
            t[1].collision = true;

            t[2] = new Tile();
            t[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/finish.png"));
            t[2].collision = true;

            t[3] = new Tile();
            t[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/bio1.png"));

            t[4] = new Tile();
            t[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/bio2.png"));

            t[5] = new Tile();
            t[5].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/glass1.png"));

            t[6] = new Tile();
            t[6].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/paper1.png"));

            t[7] = new Tile();
            t[7].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/paper2.png"));

            t[8] = new Tile();
            t[8].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/plastic1.png"));

            t[9] = new Tile();
            t[9].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/plastic2.png"));

            t[10] = new Tile();
            t[10].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/waste1.png"));

            t[11] = new Tile();
            t[11].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/waste2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //loads map from txt to an array
    public void loadMap(){
        try{
            InputStream i = getClass().getClassLoader().getResourceAsStream("map.txt");
            BufferedReader b = new BufferedReader(new InputStreamReader(i));

            int column = 0;
            int row = 0;

            while(column < p.grid_columns && row < p.grid_rows){
                String line = b.readLine();

                while(column < p.grid_columns){
                    String number[] = line.split(" ");
                    int num = Integer.parseInt((number[column]));
                    map_tile_number[column][row] = num;
                    column++;
                }

                if(column == p.grid_columns){
                    column = 0;
                    row++;
                }
            }
            b.close();

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

        int column = 0;
        int row = 0;
        int x_position = 0;
        int y_position = 0;

        while(column < p.grid_columns && row < p.grid_rows){
            int tile_number = map_tile_number[column][row];

            g2.drawImage(t[tile_number].image,x_position,y_position,p.block_size,p.block_size,null);
            column++;
            x_position += p.block_size;

            if(column == p.grid_columns){
                column = 0;
                x_position = 0;
                row++;
                y_position += p.block_size;
            }
        }

    }
}
