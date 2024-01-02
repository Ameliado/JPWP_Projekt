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

                    p.repaint();
                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();

                    if (TrashClickState.state == TrashClickState.BIO){
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        GameState.state = GameState.GAME;
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL || TrashClickState.state == TrashClickState.BIO)){
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
                    break;
                case 5:

                    p.repaint();
                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();

                    if (TrashClickState.state == TrashClickState.GLASS){
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        GameState.state = GameState.GAME;

                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL || TrashClickState.state == TrashClickState.GLASS)){
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
                    break;
                case 6,7:

                    p.repaint();
                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();
                    if (TrashClickState.state == TrashClickState.PAPER){
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        GameState.state = GameState.GAME;
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL || TrashClickState.state == TrashClickState.PAPER)){
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
                    break;
                case 8,9:

                    p.repaint();
                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();
                    if (TrashClickState.state == TrashClickState.PLASTIC){
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        GameState.state = GameState.GAME;
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL || TrashClickState.state == TrashClickState.PLASTIC)){
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
                    break;
                case 10,11:

                    p.repaint();
                    p.t.drawTrashImage(tile);
                    p.t.addTrashButtons();

                    if (TrashClickState.state == TrashClickState.WASTE){
                        p.t.removeTrashButtons();
                        p.t.removeTrashImage();
                        TrashClickState.state = TrashClickState.NULL;
                        trash_collected += 1;
                        p.w.m.showPointsLives(trash_collected,lives);
                        GameState.state = GameState.GAME;
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL || TrashClickState.state == TrashClickState.WASTE)){
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
                    break;
            }
        }
    }


}