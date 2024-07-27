/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author zack
 */
public class GameLogic {
    private String[][] moves;
    private String playerTurn;
    private boolean gameOver;
    
    public GameLogic() {
        this.moves = new String[3][3];
        this.playerTurn = "X";
        this.gameOver = false;
    }
    
    public boolean playMove(int x, int y) {
        if (this.moves[x][y] == null) {
            this.moves[x][y] = this.playerTurn;
            checkWin();
            return true;
        }
        return false;
    }
    
    private void checkWin() {
        int[] diagSum = {0,0};
        int[] horizSum = {0,0,0};
        int[] vertSum = {0,0,0};
        for (int row=0; row < 3; row++) {
            for (int col=0; col < 3; col++) {
                if (this.moves[row][col] != null && this.moves[row][col].equals(this.playerTurn)) {
                    horizSum[row]++;
                    vertSum[col]++;
                    if (row == 0 && col == 0) {
                        diagSum[0]++;
                    } else if (row == 0 && col == 2) {
                        diagSum[1]++;
                    } else if (row == 1 && col == 1) {
                        diagSum[0]++;
                        diagSum[1]++;
                    } else if (row == 2 && col == 0) {
                        diagSum[1]++;
                    } else if (row == 2 && col == 2) {
                        diagSum[0]++;
                    }
                }
            }
        }
        for (int numd: diagSum) {
            if (numd == 3) {
                this.gameOver = true;
            }
        }
        for (int numh: horizSum) {
            if (numh ==3) {
                this.gameOver = true;
            }
        }
        for (int numv: vertSum) {
            if (numv == 3) {
                this.gameOver = true;
            }
        }
    }
    
    public void changePlayer() {
        if (this.playerTurn.equals("X")) {
            this.playerTurn = "O";
        } else {
        this.playerTurn = "X";
        }
    }
    
    public String getCurrentPlayer() {
        return this.playerTurn;
    }
    
    public boolean gameOver() {
        return this.gameOver;
    }
    
    
}
