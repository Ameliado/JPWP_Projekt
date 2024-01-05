import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestartButton extends JButton {

    public RestartButton(){

        this.setText("Zacznij od nowa");
        this.setBackground(Color.pink);
        this.setFocusable(false);
        addActionListener (new B2());
    }

    private class B2 implements ActionListener{
        public void actionPerformed (ActionEvent a) {
           GameState.state = GameState.RESTART;
        }
    }


}
