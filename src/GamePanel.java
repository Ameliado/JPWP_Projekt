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

    public GamePanel(){
        this.setSize(new Dimension(panel_width,panel_height));
        this.setBackground(Color.cyan);
    }

    Thread game;

    public void start_thread(){
        game = new Thread(this);
        game.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(300,300,block_size,block_size);
        g.dispose();
    }

    public void run(){
        while(game != null){
            repaint();
        }
    }

}
