import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(int x, int y,int z){
        this.setSize(new Dimension(x,y));
        this.setBackground(Color.green);
        this.setLayout(null);

       FinishGameButton fgb = new FinishGameButton();
       add(fgb);
       fgb.setBounds(x-z/2,0,z/2,y);
       fgb.setPreferredSize(new Dimension(x-1000,y));

    }

}
