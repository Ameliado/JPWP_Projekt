import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    final int menu_height = 50;

    public MenuPanel(int x, int y,int z){
        this.setSize(new Dimension(x,y));
        this.setBackground(Color.yellow);
        this.setLayout(null);

       FinishGameButton fgb = new FinishGameButton();
       add(fgb);
       fgb.setBounds(x-z/2,0,z/2,y);
       fgb.setPreferredSize(new Dimension(x-1000,y));

    }

}
