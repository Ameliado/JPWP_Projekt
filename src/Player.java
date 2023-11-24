import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Player {

    public BufferedImage mov1,mov2;

    public int x_position;
    public int y_position;
    public int change_position;
    GamePanel p;
    KeyHandler keys;

    public Player(GamePanel p, KeyHandler keys){
        this.p = p;
        this.keys = keys;
        setDefaultMovement();
        getPlayerImage();
    }

    public void setDefaultMovement(){
        x_position = 200;
        y_position = 200;
        change_position = p.block_size;
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

    public void update(){
        if(keys.up == true) {
            if(which_image == false) {
                which_image = true;
            }
            else {
                which_image = false;
            }
            y_position -= change_position;
        }
        else if(keys.down == true) {
            if(which_image == false) {
                which_image = true;
            }
            else {
                which_image = false;
            }
            y_position += change_position;
        }
        else if(keys.left == true) {
            if(which_image == false) {
                which_image = true;
            }
            else {
                which_image = false;
            }
            x_position -= change_position;
        }
        else if(keys.right == true) {
            if(which_image == false) {
                which_image = true;
            }
            else {
                which_image = false;
            }
            x_position += change_position;
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
