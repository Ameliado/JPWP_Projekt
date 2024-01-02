import javax.swing.*;
import java.awt.*;

public class TaskHandler {

    GamePanel p;
    int trash_collected = 0;

    public TaskHandler(GamePanel p){
        this.p = p;
    }

    public void whatObject(int tile){
        while(GameState.state == GameState.TASK){
            switch (tile){
                case 3,4:

                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();

                    if (TrashClickState.state == TrashClickState.BIO){
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        GameState.state = GameState.GAME;
                    }
                    //else zycko -1
                    break;
                case 5:

                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();

                    if (TrashClickState.state == TrashClickState.GLASS){
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        GameState.state = GameState.GAME;

                    }
                    //else zycko -1
                    break;
                case 6,7:

                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();
                    if (TrashClickState.state == TrashClickState.PAPER){
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        GameState.state = GameState.GAME;
                    }
                    //else zycko -1
                    break;
                case 8,9:

                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();
                    if (TrashClickState.state == TrashClickState.PLASTIC){
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        GameState.state = GameState.GAME;
                    }
                    //else zycko -1
                    break;
                case 10,11:

                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();

                    if (TrashClickState.state == TrashClickState.WASTE){
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        trash_collected += 1;
                        p.w.m.showPoints(trash_collected);
                        GameState.state = GameState.GAME;
                    }
                    //else zycko -1
                    break;
            }
        }
    }


}