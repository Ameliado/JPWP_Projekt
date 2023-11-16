import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinishGameButton extends JButton {

    public FinishGameButton(){
        this.setText("Zakończ grę");
        this.setBackground(Color.gray);
        this.setFocusable(false);
        addActionListener (new B1());
    }

    private class B1 implements ActionListener{
        public void actionPerformed (ActionEvent a) {
            if (JOptionPane.showConfirmDialog( null,"Czy na pewno chcesz wyjść z gry?","Wyjście",
                    JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                System.exit(0);
            }

        }
    }


}
