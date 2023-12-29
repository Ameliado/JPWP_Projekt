import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{
    //Program window settings
    final int window_width = 1280;
    final int window_height = 1024;
    final int menu_height = 50;

    GameWindow(String name){
        super();

        TaskPanel t = new TaskPanel();
        GamePanel p = new GamePanel(t);
        MenuPanel m = new MenuPanel(window_width,menu_height, window_width - p.panel_width);
        p.setBounds(0,menu_height,p.panel_width,p.panel_height);
        t.setBounds(p.panel_width,menu_height,window_width-p.panel_width,p.panel_height);
        t.setBackground(Color.darkGray);

        add(p);
        //getContentPane().add(t);
        add(t);
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
