/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    private int currentPLayer; //variables
    private int [][] gameBoard;


    public GameBoard() //constructor
    {
        newGame(); // to avoid code duplication, since we cant call constructor from new game and they both do the same thing

    }
    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        //TODO Implement this method
        return currentPLayer;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        if (gameBoard[col][row] == -1) {
            gameBoard[col][row] = currentPLayer;
            if (currentPLayer == 0){
                currentPLayer = 1;
            }
            else{
                currentPLayer = 0;
            }
            return true; //allows to play

        }

        return false; // if the cell has a number in it, will not let the game progress
    }

    public boolean isGameOver()
    {
        for (int i = 0; i < 3; i++) {
            if(gameBoard[i][0] != -1 && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] ==gameBoard[i][2]){
                return true; // first checks rows
            }
            if(gameBoard[0][i] != -1 && gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] ==gameBoard[2][i]){
                return true; // second checks columns
            }
                //checks if the row is occupied by the same player

        }
        if(gameBoard[0][0] != -1 && gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] ==gameBoard[2][2]){
            return true; //  checks diagonals for winner
        }
        if(gameBoard[0][2] != -1 && gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] ==gameBoard[2][2]){
            return true; // checks diagonals for winner
        }

        //TODO Implement this method
        // a check that loops through the array and checks if winning conditions are met
       return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        if (currentPLayer == 0){
            currentPLayer = 1;
        }
        else{
            currentPLayer = 0;
        }
        return currentPLayer; //change player again to get the right winner
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
       currentPLayer = 0; // 0=X
       gameBoard =new int[3][3]; // board
        for (int i = 0; i < 3; i++) { // nested iteration loop(loop in loop) makes loop check row by row
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = -1; // -1= empty spot/ game  board  location

            }

        }
        //resets the board and the player
            //TODO Implement this method
    }

}
