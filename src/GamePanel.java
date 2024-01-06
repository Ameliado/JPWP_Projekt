import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    GameWindow w;
    TaskPanel t;

    // map grid size settings
    public final int original_block_size = 16;
    public final int scale = 3;
    public final int block_size = scale * original_block_size;
    public final int grid_columns = 18;
    public final int grid_rows = 17;
    public final int panel_width = grid_columns * block_size;
    public  final int panel_height = grid_rows * block_size;

    int FPS = 60;

    public float game_time_start,game_time_end;

    public GamePanel(GameWindow w,TaskPanel t){
        this.w = w;
        this.t = t;
        this.setPreferredSize(new Dimension(panel_width,panel_height));
        this.setBackground(Color.cyan);
        this.addKeyListener(keys);
        this.setFocusable(true);
    }

    public KeyHandler keys = new KeyHandler();
    Thread game;
    public TileHandler tiles = new TileHandler(this);
    public Player player = new Player(this,keys);
    public CollisionHandler collision = new CollisionHandler(this,keys);
    public TaskHandler objects = new TaskHandler(this);

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
                switch (GameState.state) {
                    case GAME:
                        t.repaint();
                        this.requestFocus();
                        this.revalidate();
                        player.update();
                        repaint();
                        break;
                    case TASK:
                        this.setFocusable(false);
                        t.revalidate();
                        t.setFocusable(true);
                        t.requestFocus();
                        break;
                    case RESTART:
                        game_time_start = System.nanoTime();
                        objects.lives = 3;
                        objects.trash_collected = 0;
                        w.m.showPointsLives(objects.trash_collected,objects.lives);
                        TrashClickState.state = TrashClickState.NULL;
                        player.setDefaultMovement();
                        t.removeLabels();
                        t.removeTrashImage();
                        t.removeTrashButtons();
                        tiles.loadMap();
                        GameState.state = GameState.GAME;
                        break;
                    case FINISH:
                        game_time_end = (System.nanoTime() - game_time_start)/1000000000;
                        t.finishPanel(objects.trash_collected,objects.lives,game_time_end);
                        break;
                }
                delta--;
            }

        }
    }

}
