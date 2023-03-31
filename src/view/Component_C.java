package view;
import model.RowGameModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import model.RowGameModel;
import controller.RowGameController;

public class Component_C implements View{

    private JPanel messages;
    private JTextArea playerturn;

    public Component_C(JTextArea playerturn) {
        this.messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);
        this.playerturn = playerturn;
        this.messages.add(playerturn);
        this.playerturn.setText("Player 1 to play 'X'");
        this.playerturn.setEnabled(false);
    }
    
    public void update(RowGameModel model) {
        if(model.getFinalResult() != null) {
            this.playerturn.setText(model.getFinalResult());
        }
        else if(model.getFinalResult() == null && model.movesLeft == 9){
            this.playerturn.setText("Player 1 to play 'X'");
        }
        else if(model.getPlayer().equals("2")){
            this.playerturn.setText("'X': Player 1");
        }
        else {
            this.playerturn.setText("'O': Player 2");
        }
        
    }

    public JPanel getMessages() {
        return this.messages;
    }

    public JTextArea getPlayerturn() {
        return this.playerturn;
    }
}
