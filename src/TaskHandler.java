import javax.swing.*;
import java.awt.*;

public class TaskHandler {

    GamePanel p;
    Boolean done = false;
    int trash_collected = 0;

    public TaskHandler(GamePanel p){
        this.p = p;
    }

    public void whatObject(int tile){
        switch (tile){
            case 3,4:
                done = false;

                p.t.drawTrashImage(tile);
                p.t.addTrashButtons();

                while (!done){
                    //System.out.println(TrashClickState.state);
                    System.out.println("");

                    if (TrashClickState.state == TrashClickState.BIO){
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        done = true;
                    }
                    //else zycko -1
                }
                //System.out.println(TrashClickState.state);
                //System.out.println(GameState.state);
                break;
            case 5:
                done = false;

                p.t.drawTrashImage(tile);
                p.t.addTrashButtons();

                while (!done){
                    //System.out.println(TrashClickState.state);
                    System.out.println("");

                    if (TrashClickState.state == TrashClickState.GLASS){
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        done = true;
                    }
                    //else zycko -1
                }
                System.out.println(TrashClickState.state);
                System.out.println(GameState.state);
                break;
            case 6,7:
                done = false;

                p.t.drawTrashImage(tile);
                p.t.addTrashButtons();
                while (!done){
                    //System.out.println(TrashClickState.state);
                    System.out.println("");

                    if (TrashClickState.state == TrashClickState.PAPER){
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        done = true;
                    }
                    //else zycko -1
                }
                System.out.println(TrashClickState.state);
                System.out.println(GameState.state);
                break;
            case 8,9:
                done = false;

                p.t.drawTrashImage(tile);
                p.t.addTrashButtons();
                while (!done){
                    //System.out.println(TrashClickState.state);
                    System.out.println("");

                    if (TrashClickState.state == TrashClickState.PLASTIC){
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        done = true;
                    }
                    //else zycko -1
                }
                System.out.println(TrashClickState.state);
                System.out.println(GameState.state);
                break;
            case 10,11:
                done = false;

                p.t.drawTrashImage(tile);
                p.t.addTrashButtons();

                while (!done){
                    //System.out.println(TrashClickState.state);
                    System.out.println("");

                    if (TrashClickState.state == TrashClickState.WASTE){
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        done = true;
                    }
                    //else zycko -1
                }
                //System.out.println(TrashClickState.state);
                //System.out.println(GameState.state);
                break;
        }
    }


}
