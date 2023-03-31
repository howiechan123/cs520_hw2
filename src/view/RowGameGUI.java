package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import model.RowGameModel;
import controller.RowGameController;

public class RowGameGUI implements View {

    public JFrame gui = new JFrame("Tic Tac Toe");
    public RowGameModel gameModel = new RowGameModel();
    public JButton[][] blocks = new JButton[3][3];
    public JButton reset = new JButton("Reset");
    public JTextArea playerturn = new JTextArea();

    Component_A a = new Component_A(blocks);
    Component_C c = new Component_C(playerturn);

    public void update(RowGameModel model) {
        a.update(model);
        c.update(model);
    }


    

    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameGUI(RowGameController controller) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);

        gui.add(a.getGamePanel(), BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(c.getMessages(), BorderLayout.SOUTH);

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.resetGame();
            }
        });

        // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                JPanel game = a.getGame();
                game.add(blocks[row][column]);
                a.setGame(game);
                blocks[row][column].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
			controller.move((JButton)e.getSource());
                    }
                });
            }
        }
    }
}
