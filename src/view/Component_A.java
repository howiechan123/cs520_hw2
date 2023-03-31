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

public class Component_A implements View {

    private JPanel game;
    private JPanel gamePanel;
    private JButton[][] blocks;

    public Component_A(JButton[][] blocks) {
        this.game = new JPanel(new GridLayout(3,3));
        this.gamePanel = new JPanel(new FlowLayout());
        gamePanel.add(game, BorderLayout.CENTER);
        this.blocks = blocks;
    }
    
    
    public void update(RowGameModel model) {
        for(int row = 0; row < blocks.length; row++) {
            for(int column = 0; column < blocks[0].length; column++) {
                updateBlock(model, row, column);
            }
        }
    }

    public void updateBlock(RowGameModel gameModel, int row, int column) {
        
        this.blocks[row][column].setText(gameModel.blocksData[row][column].getContents());
        this.blocks[row][column].setEnabled(gameModel.blocksData[row][column].getIsLegalMove());
            
    }

    public JPanel getGame() {
        return this.game;
    }

    public JPanel getGamePanel() {
        return this.gamePanel;
    }

    public void setGame(JPanel game) {
        this.game = game;
    }

}
