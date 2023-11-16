import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{
    //Program window settings
    final int window_width = 1280;
    final int window_height = 1024;

    GameWindow(String name){
        super();

        GamePanel p = new GamePanel();
        MenuPanel m = new MenuPanel(window_width,window_height - p.panel_height, window_width - p.panel_width);
        p.setBounds(0,window_height - p.panel_height,p.panel_width,p.panel_height);

        add(p);
        add(m);

        this.setSize(window_width,window_height );
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        p.startThread();

    }


}
