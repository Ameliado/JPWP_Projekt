import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    final int menu_height = 50;
    GameWindow w;

    public MenuPanel(int x,int z, GameWindow w){
        this.w = w;
        this.setSize(new Dimension(x,menu_height));
        this.setBackground(Color.yellow);
        this.setLayout(null);

        showPoints(w.p.objects.trash_collected);

       FinishGameButton fgb = new FinishGameButton();
       add(fgb);
       fgb.setBounds(x-z/2,0,z/2,menu_height);
       fgb.setPreferredSize(new Dimension(x-1000,menu_height));

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
        //revalidate();
        //repaint();
    }

}
