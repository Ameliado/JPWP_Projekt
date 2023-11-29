import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // Labirynth grid settings

    public final int original_block_size = 16;
    public final int scale = 3;
    public final int block_size = scale * original_block_size;
    public final int grid_columns = 18;
    public final int grid_rows = 17;
    public final int panel_width = grid_columns * block_size;
    public  final int panel_height = grid_rows * block_size;

    int FPS = 60;

    public KeyHandler keys = new KeyHandler();
    Thread game;
    public TileHandler tiles = new TileHandler(this);
    public Player player = new Player(this,keys);
    public CollisionHandler collision = new CollisionHandler(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(panel_width,panel_height));
        this.setBackground(Color.cyan);
        this.addKeyListener(keys);
        this.setFocusable(true);
        this.requestFocus();
    }

    public void startThread(){
        game = new Thread(this);
        game.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tiles.draw(g2);
        player.draw(g2);
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
                player.update();
                repaint();
                delta--;
            }
        }
    }

}
