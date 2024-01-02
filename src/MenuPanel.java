import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    final int menu_height = 50;
    GameWindow w;

    public MenuPanel(int x, int y,int z, GameWindow w){
        this.w = w;
        this.setSize(new Dimension(x,y));
        this.setBackground(Color.yellow);
        this.setLayout(null);

       FinishGameButton fgb = new FinishGameButton();
       add(fgb);
       fgb.setBounds(x-z/2,0,z/2,y);
       fgb.setPreferredSize(new Dimension(x-1000,y));

    }

    public void showPoints(int trash_collected) {
        Component[] componentList = this.getComponents();

        for(Component c : componentList){
            if(c instanceof JLabel){
                this.remove(c);
            }
        }
        revalidate();
        repaint();

        JLabel jlabel = new JLabel("Punkty: " + trash_collected + "/9");
        jlabel.setFont(new Font("Verdana", 1, 20));
        jlabel.setBounds(0,0,w.window_width/4,menu_height);
        this.add(jlabel);
        revalidate();
        repaint();
    }

}
