public class ObjectHandler {

    GamePanel p;
    TaskPanel t;

    public ObjectHandler(GamePanel p,TaskPanel t){
        this.p = p;
        this.t = t;
    }

    public void whatObject(int tile){
        switch (tile){
            case 3,4:
                bio();
                p.game_state = 1;
                break;
            case 5:
                glass();
                p.game_state = 1;
                break;
            case 6,7:
                paper();
                p.game_state = 1;
                break;
            case 8,9:
                plastic();
                p.game_state = 1;
                break;
            case 10,11:
                waste();
                p.game_state = 1;
                break;
        }
    }

    public void paper(){
        System.out.println("paper");
    }

    public void plastic(){
        System.out.println("plastic");
    }

    public void bio(){
        System.out.println("bio");
    }

    public void waste(){
        System.out.println("waste");
    }

    public void glass(){
        System.out.println("glass");
    }

}
