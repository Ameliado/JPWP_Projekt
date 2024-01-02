import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    final int menu_height = 50;
    GameWindow w;

    public MenuPanel(int x, int z, GameWindow w) {
        this.w = w;
        this.setSize(new Dimension(x, menu_height));
        this.setBackground(Color.yellow);
        this.setLayout(null);

        showPointsLives(w.p.objects.trash_collected, w.p.objects.lives);

        FinishGameButton fgb = new FinishGameButton();
        add(fgb);
        fgb.setBounds(x - z / 2, 0, z / 2, menu_height);
        fgb.setPreferredSize(new Dimension(x - 1000, menu_height));

    }

    public void showPointsLives(int trash_collected, int lives) {
        Component[] componentList = this.getComponents();

        for (Component c : componentList) {
            if (c instanceof JLabel) {
                this.remove(c);
            }
        }
        revalidate();
        repaint();

        JLabel jlabel = new JLabel("ZEBRANE ŚMIECI: " + trash_collected + "/9");
        jlabel.setFont(new Font("Verdana", 1, 20));
        jlabel.setBounds(0, 0, w.window_width / 4, menu_height);
        this.add(jlabel);

        JLabel jlabel2 = new JLabel("POZOSTAŁE ŻYCIA: " + lives + "/3");
        jlabel2.setFont(new Font("Verdana", 1, 20));
        jlabel2.setBounds(w.window_width / 4, 0, w.window_width / 4, menu_height);
        this.add(jlabel2);
    }

}
