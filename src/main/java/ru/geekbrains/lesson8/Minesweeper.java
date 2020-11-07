package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Minesweeper extends JFrame {
    private final int width = 10;
    private final int height = 15;
    private final char mine = '✸';
    private final JButton resetButton = new JButton("Restart");
    private final String flag = Character.toString('⚑');
    private final Color background = new Color(236, 236, 236);
    boolean gameOver = false;
    private JButton[][] boardButtons;
    private char[][] board;

    public Minesweeper() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(createBoard());
        setResizable(false);
        setVisible(true);
    }

    public JPanel createBoard() {
        restart();

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gameBoard = new JPanel(new GridLayout(height, width));

        boardButtons = new JButton[height][width];

        add(mainPanel);

        setSize(550, 520);
        gameBoard.setPreferredSize(new Dimension(450, 450));

        mainPanel.add(gameBoard, BorderLayout.NORTH);
        mainPanel.add(resetButton);

        resetButton.addActionListener(new MyActionListener());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boardButtons[i][j] = new JButton();
                boardButtons[i][j].setVisible(true);
                setColour(i, j);

                gameBoard.add(boardButtons[i][j]);
                boardButtons[i][j].addMouseListener(new MyMouseListener());
                boardButtons[i][j].addActionListener(new MyActionListener());
                boardButtons[i][j].setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
            }
        }
        return mainPanel;
    }

    public void setColour(int row, int col) {
        switch (getPieceAt(row, col)) {
            case "1" -> boardButtons[row][col].setForeground(new Color(1, 0, 254));
            case "2" -> boardButtons[row][col].setForeground(new Color(1, 127, 1));
            case "3" -> boardButtons[row][col].setForeground(new Color(254, 0, 0));
            case "4" -> boardButtons[row][col].setForeground(new Color(0, 0, 127));
            case "5" -> boardButtons[row][col].setForeground(new Color(129, 1, 2));
            case "6" -> boardButtons[row][col].setForeground(new Color(0, 128, 129));
            case "7" -> boardButtons[row][col].setForeground(new Color(0, 0, 0));
            case "8" -> boardButtons[row][col].setForeground(new Color(128, 128, 128));
        }
    }

    public void reveal(int row, int col) {
        if (isPiece(row, col, ' ')) {
            revealBlanks(row, col);
        } else {
            if (isValid(row, col)
                    && !isPiece(row, col, mine)) {
                boardButtons[row][col].setText(getPieceAt(row, col));
                boardButtons[row][col].setBackground(background);
                setColour(row, col);
            }
        }
    }

    public void revealMines() {
        for (int i = 0; i < boardButtons.length; i++) {
            for (int j = 0; j < boardButtons[0].length; j++) {
                if (isPiece(i, j, mine)) {
                    if (!boardButtons[i][j].getText().equals(flag)) {
                        boardButtons[i][j].setForeground(Color.BLACK);
                        boardButtons[i][j].setText(getPieceAt(i, j));
                    } else if (isPiece(i, j, mine) &&
                            boardButtons[i][j].getText().equals(flag)) {
                        boardButtons[i][j].setForeground(Color.BLACK);
                        boardButtons[i][j].setBackground(Color.RED);
                    }
                }
            }
        }
    }

    public void revealBlanks(int row, int col) {
        if (!boardButtons[row][col].getBackground().equals(new JButton().getBackground())) {
            return;
        }
        if (isPiece(row, col, ' ')) {
            boardButtons[row][col].setBackground(background);
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (isPiece(i, j, ' ')) {
                        revealBlanks(i, j);
                    } else {
                        reveal(i, j);
                    }
                }
            }
        }
    }

    public boolean isWinner() {
        for (int i = 0; i < boardButtons.length; i++) {
            for (int j = 0; j < boardButtons[0].length; j++) {
                if (!isPiece(i, j, mine) && boardButtons[i][j].getBackground().equals(new JButton().getBackground())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setFlag(int row, int col) {
        if (!boardButtons[row][col].getText().equals(flag)) {
            boardButtons[row][col].setText(flag);
            boardButtons[row][col].setForeground(Color.RED);
        } else {
            boardButtons[row][col].setText("");
        }
    }

    public boolean isPiece(int row, int col, char piece) {
        return isValid(row, col) && this.board[row][col] == piece;
    }

    public boolean isValid(int row, int col) {
        return row >= 0 && row < this.height && col >= 0 && col < this.width;
    }

    public void restart() {
        board = new char[this.height][this.width];
        int mineCount = 15;
        int[] mineIndexes = new Random().ints(0, (this.width * this.height - 1)).limit(mineCount).distinct().toArray();
        for (int mineIndex : mineIndexes) {
            this.board[Math.floorDiv(mineIndex, this.width)][mineIndex % this.width] = this.mine;
        }
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if (this.board[i][j] != mine) {
                    int minesNearby = nearbyMines(i, j);
                    if (minesNearby != 0) {
                        this.board[i][j] = (char) (minesNearby + 48);
                    } else {
                        this.board[i][j] = ' ';
                    }
                }
            }
        }
    }

    public int nearbyMines(int row, int col) {
        int minesNearby = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isPiece(i, j, this.mine)) {
                    minesNearby++;
                }
            }
        }
        return minesNearby;
    }

    public String getPieceAt(int row, int col) {
        return Character.toString(this.board[row][col]);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == resetButton) {
                restart();
                gameOver = false;
                setTitle("Minesweeper");
                for (JButton[] boardButton : boardButtons) {
                    for (int j = 0; j < boardButtons[0].length; j++) {
                        boardButton[j].setBackground(new JButton().getBackground());
                        boardButton[j].setText("");
                    }
                }
            }
            if (!gameOver) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (e.getSource() == boardButtons[i][j] && !boardButtons[i][j].getText().equals(flag)) {
                            if (isPiece(i, j, mine)) {
                                gameOver = true;
                                revealMines();
                                setTitle("YOU LOSE");
                                boardButtons[i][j].setBackground(Color.RED);
                            } else {
                                reveal(i, j);
                                if (isWinner()) {
                                    gameOver = true;
                                    setTitle("YOU WIN");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public class MyMouseListener implements MouseListener {
        public void mousePressed(MouseEvent e) {
            if (!gameOver) {
                for (int i = 0; i < boardButtons.length; i++) {
                    for (int j = 0; j < boardButtons[0].length; j++) {
                        String buttonText = boardButtons[i][j].getText();
                        if (e.getButton() == 3 && e.getSource() == boardButtons[i][j]) {
                            if (buttonText.equals("") || buttonText.equals(flag)) {
                                setFlag(i, j);
                            }
                        }
                    }
                }
            }
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }
    }
}
