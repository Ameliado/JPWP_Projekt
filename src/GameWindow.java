import javax.swing.*;
import java.awt.*;

public class GameWindow extends JWindow{
    //Program window settings
    final int window_width = 1280;
    final int window_height = 1024;

    GameWindow(String name){
        super();
        setSize(window_width,window_height );
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        GamePanel p = new GamePanel();
        MenuPanel m = new MenuPanel(window_width,window_height - p.panel_height);
        add(m);
        add(p);
    }



}
