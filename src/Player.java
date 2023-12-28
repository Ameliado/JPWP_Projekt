import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Player {

    public int direction;
    public BufferedImage mov1,mov2;

    public int x_position;
    public int y_position;
    public int change_position;

    public Rectangle solid_size;
    public boolean player_collision = false;

    GamePanel p;
    KeyHandler keys;

    public Player(GamePanel p, KeyHandler keys){
        this.p = p;
        this.keys = keys;

        solid_size = new Rectangle();
        solid_size.x = 8;
        solid_size.y = 16;
        solid_size.width = p.block_size - 2* solid_size.x;
        solid_size.height = p.block_size - solid_size.y;

        setDefaultMovement();
        getPlayerImage();
    }

    public void setDefaultMovement(){
        x_position = p.block_size;
        y_position = p.grid_rows/2*p.block_size;
        change_position = 3;
    }

    public void getPlayerImage(){

        try{
            mov1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player1.png"));
            mov2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public boolean which_image;

    public void checkWhichImage(boolean which_image){
        if(which_image == false) {
            this.which_image = true;
        }
        else {
            this.which_image = false;
        }
    }

    public void update(){
        if( keys.up || keys.down || keys.left || keys.right){
            if(keys.up) {
                checkWhichImage(which_image);
                direction = 1;
            }
            else if(keys.down) {
                checkWhichImage(which_image);
                direction = 2;
            }
            else if(keys.left) {
                checkWhichImage(which_image);
                direction = 3;
            }
            else if(keys.right) {
                checkWhichImage(which_image);
                direction = 4;
            }
        }


        player_collision = false;
        p.collision.tileChecker(this);
        if (player_collision == false){
            switch(direction) {
                case 1:
                    y_position -= change_position;
                    break;
                case 2:
                    y_position += change_position;
                    break;
                case 3:
                    x_position -= change_position;
                    break;
                case 4:
                    x_position += change_position;
                    break;
            }

        direction = 0;
        }
    }

    public BufferedImage image;
    public void draw(Graphics2D g2){
       if (which_image == true) {
           image = mov1;
       }
       else {
           image = mov2;
       }
       g2.drawImage(image,x_position,y_position,p.block_size,p.block_size,null);
    }
}
