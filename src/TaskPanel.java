import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {

    public GameWindow w;
    public GamePanel p;

    public TaskPanel(GameWindow w){
        super();

        this.w = w;

        this.setLayout(null);
        setBackground(Color.DARK_GRAY);
    }

    //draws trash image which was stepped on
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

    //deletes trash image from task
    public void removeTrashImage(){
        Component[] componentList = this.getComponents();

        removeLabels();

        for(Component c : componentList){
            if(c instanceof TrashImage){
                this.remove(c);
            }
        }
        revalidate();
        repaint();
    }

    //draws trashcan buttons in task
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

    //deletes trashcan buttons from task
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

    //adds and defines finish panel reaction based on trash collected and lives
    public void finishPanel(boolean finish_collision,float game_time){
        p = w.getGamePanel();

        //win or defeat
        if ((finish_collision && p.objects.trash_collected == p.objects.trash_total) || (!finish_collision && p.objects.lives == 0)){

            removeLabels();

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

            JLabel jlabel3;
            if (p.objects.trash_collected == p.objects.trash_total){
                jlabel3 = new JLabel("GRATULACJE");
                jlabel3.setFont(new Font("Verdana", 1, 20));
                jlabel3.setForeground(Color.white);
                jlabel3.setBounds(130,100,w.window_width-p.panel_width,50);

                if (game_time < 60) p.objects.bonus = p.objects.bonus_60;
                else if (game_time < 120) p.objects.bonus = p.objects.bonus_120;
                else if (game_time < 200) p.objects.bonus = p.objects.bonus_200;

            }
            else{
                jlabel3 = new JLabel("SPRÓBUJ JESZCZE RAZ");
                jlabel3.setFont(new Font("Verdana", 1, 20));
                jlabel3.setForeground(Color.white);
                jlabel3.setBounds(80,100,w.window_width-p.panel_width,50);

            }
            this.add(jlabel3);

            JLabel jlabel4 = new JLabel("OTO TWÓJ WYNIK: ");
            jlabel4.setFont(new Font("Verdana", 1, 20));
            jlabel4.setForeground(Color.white);
            jlabel4.setBounds(100,130,w.window_width-p.panel_width,50);

            JLabel jlabel5 = new JLabel("Zebrane śmieci: "+ p.objects.trash_collected +"x"+ p.objects.points_basic+" = "+(p.objects.points_basic*p.objects.trash_collected));
            jlabel5.setFont(new Font("Verdana", 1, 20));
            jlabel5.setForeground(Color.white);
            jlabel5.setBounds(30,170,w.window_width-p.panel_width,50);

            JLabel jlabel6 = new JLabel("Pozostałe życia: "+ p.objects.lives +"x"+ p.objects.points_basic+" = "+(p.objects.points_basic*p.objects.lives));
            jlabel6.setFont(new Font("Verdana", 1, 20));
            jlabel6.setForeground(Color.white);
            jlabel6.setBounds(30,200,w.window_width-p.panel_width,50);

            JLabel jlabel7 = new JLabel("Premia za czas przejścia: "+p.objects.bonus);
            jlabel7.setFont(new Font("Verdana", 1, 20));
            jlabel7.setForeground(Color.white);
            jlabel7.setBounds(30,230,w.window_width-p.panel_width,50);

            JLabel jlabel8 = new JLabel("Suma: "+ (p.objects.points_basic*(p.objects.trash_collected+p.objects.lives)+p.objects.bonus) + "/"+p.objects.points_max);
            jlabel8.setFont(new Font("Verdana", 1, 20));
            jlabel8.setForeground(Color.white);
            jlabel8.setBounds(30,270,w.window_width-p.panel_width,50);

            this.add(jlabel4);
            this.add(jlabel5);
            this.add(jlabel6);
            this.add(jlabel7);
            this.add(jlabel8);

            revalidate();
            repaint();

            while ((GameState.state == GameState.FINISH)){
                System.out.println("");
            }


        }
        // not all trash collected but stepped on finish tile
        else {

            removeLabels();

            JLabel jlabel3 = new JLabel("Zostało jeszcze "+(p.objects.trash_total-p.objects.trash_collected));
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

        p.collision.finish_collision = false;

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
