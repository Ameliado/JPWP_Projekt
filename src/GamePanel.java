import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // Labirynth grid settings

    final int original_block_size = 16;
    final int scale = 3;
    final int block_size = scale * original_block_size;
    final int grid_columns = 18;
    final int grid_rows = 20;
    final int panel_width = grid_columns * block_size;
    final int panel_height = grid_rows * block_size;

    //Position settings
    int x_position = 200;
    int y_position = 200;
    int change_position = block_size;
    int FPS = 60;

    KeyHandler keys = new KeyHandler();
    Thread game;

    public GamePanel(){
        this.setPreferredSize(new Dimension(panel_width,panel_height));
        this.setBackground(Color.cyan);
        this.addKeyListener(keys);
        this.setFocusable(true);
    }

    public void startThread(){
        game = new Thread(this);
        game.start();
    }

    public void update(){
        if(keys.up == true) {
            y_position -= change_position;
        }
        else if(keys.down == true) {
            y_position += change_position;
        }
        else if(keys.left == true) {
            x_position -= change_position;
        }
        else if(keys.right == true) {
            x_position += change_position;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.fillRect(x_position,y_position,48,48);
        g2.dispose();
    }

    public void run(){
        double draw_interval = 1000000000/FPS;
        double delta = 0;
        long t_last = System.nanoTime();
        long t_current;

        while(game != null){
            t_current = System.nanoTime();
            delta += (t_current - t_last) / draw_interval;
            t_last = t_current;

            if (delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

}
