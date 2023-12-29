import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {

    public GameWindow w;
    public GamePanel p;

    public TaskPanel(GameWindow w){
        super();
        this.setLayout(null);
        this.w = w;

    }

    public void drawTrashImage(int tile){
        p = w.getGamePanel();
        Image image = p.tiles.t[tile].image.getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        TrashImage trash = new TrashImage("trash",130,100,160,160,new ImageIcon(image));
        //JLabel label = new JLabel("Do jakiego kosza należy wrzucić ten przedmiot?");
        //label.setBounds(20,50,50,50);
        //this.add(label);
        this.add(trash);
    }

    public void removeTrashImage(){
        Component[] componentList = this.getComponents();

        for(Component c : componentList){
            if(c instanceof TrashImage){
                this.remove(c);
            }
        }
        revalidate();
        repaint();
    }

    public void addTrashButtons() {

        TrashCanButton paper = new TrashCanButton("paper", 40, 350, 100, 200, new ImageIcon("res/trashcans/papercan.png"));
        TrashCanButton plastic = new TrashCanButton("plastic", 160, 350, 100, 200, new ImageIcon("res/trashcans/plasticcan.png"));
        TrashCanButton glass = new TrashCanButton("glass", 280, 350, 100, 200, new ImageIcon("res/trashcans/glasscan.png"));
        TrashCanButton waste = new TrashCanButton("waste", 100, 570, 100, 200, new ImageIcon("res/trashcans/wastecan.png"));
        TrashCanButton bio = new TrashCanButton("bio", 220, 570, 100, 200, new ImageIcon("res/trashcans/biocan.png"));

        TrashCanButtonHandler tbh = new TrashCanButtonHandler();

        paper.addActionListener(tbh);
        plastic.addActionListener(tbh);
        glass.addActionListener(tbh);
        waste.addActionListener(tbh);
        bio.addActionListener(tbh);

        this.add(paper);
        this.add(plastic);
        this.add(glass);
        this.add(waste);
        this.add(bio);

        revalidate();
        repaint();

    }

    public void removeTrashButtons(){
        Component[] componentList = this.getComponents();

        for(Component c : componentList){
            if(c instanceof TrashCanButton){
                this.remove(c);
            }
        }
        revalidate();
        repaint();
    }



}
