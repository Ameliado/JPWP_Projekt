import javax.swing.*;

public class GameWindow extends JFrame{
    //Program window settings
    final int window_width = 1280;
    final int window_height = 1024;

    GamePanel p;
    MenuPanel m;

    GameWindow(){
        super();

        TaskPanel t = new TaskPanel(this);
        p = new GamePanel(this,t);
        m = new MenuPanel(this);

        p.setBounds(0,m.menu_height,p.panel_width,p.panel_height);
        t.setBounds(p.panel_width,m.menu_height,window_width-p.panel_width,p.panel_height);

        add(p);
        add(t);
        add(m);

        this.setSize(window_width,window_height );
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        p.startThread();

    }

    public GamePanel getGamePanel(){
        return p;
    }


}
