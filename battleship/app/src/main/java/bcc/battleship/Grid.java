package bcc.battleship;

public class Grid {

    private Location[][] grid;
    
    
    
    // Create a new Grid and initialize each Location.
    public Grid() {
        grid = new Location[10][10];
        for(int row =0; row< 10; row++){
            for(int col = 0; col < 10; col++ )
            grid[row][col]= new Location();
        }
    }
    
    // Mark a hit in the specified location.
    public void markHit(int row, int col) {
       grid[row][col].markHit();
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) {
        grid[row][col].markMiss();
    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) {
        grid[row][col].setStatus(status);

    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return grid[row][col].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        
        return !grid[row][col].isUnguessed() ;
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) {
        grid[row][col].setShip(val);
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return  grid[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return grid[row][col];
    }
    
    // Return the number of rows.
    public int numRows() {
        return grid.length;
    }
    
    // Return the number of columns.
    public int numCols() {
        return grid[0].length;
    }
    

    //maybe convert to boolean?
    public boolean addShip(Ship s) {
            int row =s.getRow();
            int col = s.getCol();
            
                if(s.getDirection() == Constants.HORIZONTAL){

                for(int i=0; i< s.getLength();i++){
                if( !grid[row][col+i].hasShip()&& col + s.getLength()<grid[0].length){


                    grid[row][col+i].setShip(true);
                }
                    else{
                        return false; 
                    }
                }
               return true; 
            }


            if(s.getDirection() == Constants.VERTICAL){
                for(int i=0; i< s.getLength();i++){
            if(!grid[row +i][col].hasShip()&& row + s.getLength()<grid.length ){

                grid[row+i][col].setShip(true);
            }
                else{
                    return false; 
                }
            }
           return true; 
        }
        return false;
    }
            

    

        
            
    

    public boolean allShipsSank(){
        for (int row = 0; row < grid.length; row++)
        {
        for (int col = 0; col < grid[0].length; col++)
        {
        if(grid[row][col].hasShip() && !grid[row][col].checkHit()){
            return false;
        }
       
    }
        
    }
    return true;  
}
}


