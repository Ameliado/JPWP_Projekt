import javax.swing.*;
import java.awt.*;

public class TrashImage extends JButton {
    private final String text;
    private final int x,y;
    private final int width, height;

    public TrashImage(String text, int x, int y, int width, int height, ImageIcon icon) {
        super(text, icon);
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBorderPainted(false);
        setBackground(Color.darkGray);
        setBounds(this.x, this.y, this.width, this.height);
        setMargin(new Insets(0, 17, 0, 0));
    }

}
