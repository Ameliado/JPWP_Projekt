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
        t = new Tile[3];
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
        } catch(IOException e){
            e.printStackTrace();
        }
    }

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
