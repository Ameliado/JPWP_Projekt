import javax.swing.*;
import java.awt.*;

public class TaskHandler {

    GamePanel p;
    int trash_collected = 0;
    int lives = 3;

    public TaskHandler(GamePanel p){
        this.p = p;
    }

    public void whatObject(int tile){
        while(GameState.state == GameState.TASK){
            switch (tile){
                case 3,4:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.BIO){
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        GameState.state = GameState.GAME;
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
                case 5:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.GLASS){
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        GameState.state = GameState.GAME;
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
                case 6,7:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.PAPER){
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        GameState.state = GameState.GAME;
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
                case 8,9:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.PLASTIC){
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        GameState.state = GameState.GAME;
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
                case 10,11:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.WASTE){
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        GameState.state = GameState.GAME;
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
            }
        }
    }

    public void checkLives(){
        if (lives > 0){
            lives -= 1;
            p.w.m.showPointsLives(trash_collected,lives);
            TrashClickState.state = TrashClickState.NULL;

        }
        else {
            p.t.removeTrashButtons();
            p.t.removeTrashImage();
            GameState.state = GameState.FINISH;
        }
    }

    public void paintTask(int tile){
        p.repaint();
        p.t.drawTrashImage(tile);
        p.t.addTrashButtons();
    }


}