import javax.swing.*;

public class TaskPanel extends JPanel {

    GamePanel p;
    MenuPanel m;

    public TaskPanel(){
        super();
        this.setLayout(null);
        initTrashButtons();
    }

    public void initTrashButtons() {

        TrashCanButton paper = new TrashCanButton("paper", 40, 350, 100, 200, new ImageIcon("res/trashcans/papercan.png"));
        TrashCanButton plastic = new TrashCanButton("plastic", 160, 350, 100, 200, new ImageIcon("res/trashcans/plasticcan.png"));
        TrashCanButton glass = new TrashCanButton("glass", 280, 350, 100, 200, new ImageIcon("res/trashcans/glasscan.png"));
        TrashCanButton waste = new TrashCanButton("waste", 100, 570, 100, 200, new ImageIcon("res/trashcans/wastecan.png"));
        TrashCanButton bio = new TrashCanButton("bio", 220, 570, 100, 200, new ImageIcon("res/trashcans/biocan.png"));

        this.add(paper);
        this.add(plastic);
        this.add(glass);
        this.add(waste);
        this.add(bio);
    }

}
