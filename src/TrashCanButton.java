import javax.swing.*;
import java.awt.*;

public class TrashCanButton extends JButton {
    final String text;
    final int x,y;
    final int width, height;

    public TrashCanButton(String text, int x, int y, int width, int height, ImageIcon icon) {
        super(text, icon);
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBackground(Color.darkGray);
        setBounds(this.x, this.y, this.width, this.height);
    }

}
