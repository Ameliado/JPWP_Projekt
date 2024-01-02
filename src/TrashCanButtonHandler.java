import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrashCanButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof TrashCanButton){
            TrashCanButton clicked = (TrashCanButton) source;
            switch (clicked.getText()){
                case "paper":
                    TrashClickState.state = TrashClickState.PAPER;
                    break;
                case "plastic":
                    TrashClickState.state = TrashClickState.PLASTIC;
                    break;
                case "glass":
                    TrashClickState.state = TrashClickState.GLASS;
                    break;
                case "waste":
                    TrashClickState.state = TrashClickState.WASTE;
                    break;
                case "bio":
                    TrashClickState.state = TrashClickState.BIO;
                    break;
            }
        }
    }

}