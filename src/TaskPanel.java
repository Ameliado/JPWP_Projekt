import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {

    public GameWindow w;
    public GamePanel p;

    public TaskPanel(GameWindow w){
        super();
        this.setLayout(null);
        this.w = w;
        setBackground(Color.DARK_GRAY);
    }

    public void drawTrashImage(int tile){
        p = w.getGamePanel();

        JLabel jlabel = new JLabel("Do jakiego kosza powinien");
        jlabel.setFont(new Font("Verdana", 1, 20));
        jlabel.setForeground(Color.white);
        jlabel.setBounds(60,0,w.window_width-p.panel_width,50);

        JLabel jlabel2 = new JLabel("trafić ten przedmiot?");
        jlabel2.setFont(new Font("Verdana", 1, 20));
        jlabel2.setForeground(Color.white);
        jlabel2.setBounds(90,30,w.window_width-p.panel_width,50);

        Image image = p.tiles.t[tile].image.getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        TrashImage trash = new TrashImage("trash",130,100,160,160,new ImageIcon(image));

        this.add(jlabel);
        this.add(jlabel2);
        this.add(trash);
    }

    public void removeTrashImage(){
        Component[] componentList = this.getComponents();

        for(Component c : componentList){
            if(c instanceof JLabel){
                this.remove(c);
            }
        }

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

    public void finishPanel(int trash_collected, int lives,float game_time){

        Component[] componentList = this.getComponents();

        if (trash_collected == 9 || lives == 0){

            for(Component c : componentList){
                if(c instanceof JLabel){
                    this.remove(c);
                }
            }
            revalidate();
            repaint();

            JLabel jlabel = new JLabel("KONIEC GRY");
            jlabel.setFont(new Font("Verdana", 1, 20));
            jlabel.setForeground(Color.white);
            jlabel.setBounds(130,0,w.window_width-p.panel_width,50);

            JLabel jlabel2 = new JLabel("Czas gry: "+game_time+ "s");
            jlabel2.setFont(new Font("Verdana", 1, 20));
            jlabel2.setForeground(Color.white);
            jlabel2.setBounds(90,50,250,50);

            this.add(jlabel);
            this.add(jlabel2);

            revalidate();
            repaint();

            while (!(GameState.state == GameState.RESTART)){

            }


        }
        else {

            for(Component c : componentList){
                if(c instanceof JLabel){
                    this.remove(c);
                }
            }
            revalidate();
            repaint();

            JLabel jlabel3 = new JLabel("Zostało jeszcze "+(9-trash_collected));
            jlabel3.setFont(new Font("Verdana", 1, 20));
            jlabel3.setForeground(Color.white);
            jlabel3.setBounds(90,0,400,50);

            JLabel jlabel4 = new JLabel("przedmiotów do zebrania!");
            jlabel4.setFont(new Font("Verdana", 1, 20));
            jlabel4.setForeground(Color.white);
            jlabel4.setBounds(50,30,400,50);

            this.add(jlabel3);
            this.add(jlabel4);

            GameState.state = GameState.GAME;

        }


    }

    public void removeLabels(){
        Component[] componentList = this.getComponents();

        for(Component c : componentList){
            if(c instanceof JLabel){
                this.remove(c);
            }
        }
        revalidate();
        repaint();
    }


}
