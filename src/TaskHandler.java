
public class TaskHandler {

    GamePanel p;

    //object and lives count
    final int trash_total = 9;
    final int lives_total = 3;
    public int trash_collected = 0;
    public int lives = 3;

    //points count
    final int points_basic = 100;
    final int bonus_60 = 200;
    final int bonus_120 = 100;
    final int bonus_200 = 50;
    public int bonus = 0;
    final int points_max = trash_total * points_basic + lives_total * points_basic + bonus_60;

    public TaskHandler(GamePanel p){
        this.p = p;
    }

    //appropriate object reaction to collision
    public void whatObject(int tile){
        while(GameState.state == GameState.TASK){
            switch (tile){
                case 3,4:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.BIO){
                       taskCompleted();
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
                case 5:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.GLASS){
                        taskCompleted();
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
                case 6,7:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.PAPER){
                        taskCompleted();
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
                case 8,9:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.PLASTIC){
                        taskCompleted();
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
                case 10,11:

                    paintTask(tile);

                    if (TrashClickState.state == TrashClickState.WASTE){
                        taskCompleted();
                    }
                    else if (!(TrashClickState.state == TrashClickState.NULL)){
                        checkLives();
                    }
                    break;
            }
        }
    }

    //checks if there are lives left
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

    //task completion actions
    public void taskCompleted(){
        p.t.removeTrashButtons();
        p.t.removeTrashImage();
        TrashClickState.state = TrashClickState.NULL;
        trash_collected += 1;
        p.w.m.showPointsLives(trash_collected,lives);
        GameState.state = GameState.GAME;
    }

}