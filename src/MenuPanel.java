import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    final int menu_height = 50;
    GameWindow w;

    public MenuPanel(GameWindow w) {
        this.w = w;
        this.setSize(new Dimension(w.window_width, menu_height));
        this.setBackground(Color.ORANGE);
        this.setLayout(null);

        showPointsLives(w.p.objects.trash_collected, w.p.objects.lives);

        FinishGameButton fgb = new FinishGameButton();
        add(fgb);
        fgb.setBounds(w.window_width - (w.window_width-w.p.panel_width) / 2, 0, (w.window_width-w.p.panel_width) / 2, menu_height);
        fgb.setPreferredSize(new Dimension(w.window_width - 1000, menu_height));

        RestartButton rb = new RestartButton();
        add(rb);
        rb.setBounds((w.p.panel_width), 0, (w.window_width-w.p.panel_width) / 2, menu_height);
        rb.setPreferredSize(new Dimension(w.window_width - 1000, menu_height));

    }

    //shows current point and lives count on menu panel
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
