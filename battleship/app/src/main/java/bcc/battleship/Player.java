package bcc.battleship;
import bcc.battleship.Constants;

public class Player {
  
    private Ship[] ships;
    private Grid playergrid;
    private Grid opponentgrid;
    // Constructor: Initialize the grids and the ships.
    public Player() {
        ships = new Ship[5];
        ships[0] = new Ship(2);
        ships[1] = new Ship(3);
        ships[2] = new Ship(3);
        ships[3] = new Ship(4);
        ships[4] = new Ship(5);

        playergrid = new Grid();
        opponentgrid = new Grid();




        
    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    
    public boolean chooseShipLocation(int index, int row, int col, int direction) {

        ships[index].setDirection(direction);
        ships[index].setLocation(row,col);
        
            if(playergrid.addShip(ships[index])){

            return true;
        }
        else {
        return false;
    }
   
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col) {
        if(playergrid.get(row,col).hasShip()){
            playergrid.get(row,col).markHit();
            return true;
        } else
        playergrid.get(row,col).markMiss();
        return false;
    }
    
    
    public Grid getMyGrid() {
        return playergrid;
    }
    
    public Grid getOpponentGrid() {
        return opponentgrid;
    }
}
