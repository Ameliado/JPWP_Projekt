import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrashCanButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source instanceof TrashCanButton clicked){
            switch (clicked.getText()) {
                case "paper" -> TrashClickState.state = TrashClickState.PAPER;
                case "plastic" -> TrashClickState.state = TrashClickState.PLASTIC;
                case "glass" -> TrashClickState.state = TrashClickState.GLASS;
                case "waste" -> TrashClickState.state = TrashClickState.WASTE;
                case "bio" -> TrashClickState.state = TrashClickState.BIO;
            }
        }
    }

}