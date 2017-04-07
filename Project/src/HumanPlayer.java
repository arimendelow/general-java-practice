public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	Board board;
	
	int ID, numRows, numCols;
	int othersID = -1;
	int othersMove = -1;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){
		ID = playerID;
		
		if(ID == 1){
			othersID = 2;
		} else {
			othersID = 1;
		}
		board = new Board(row, col);
	}
	
	//receives the most recent move from the other player
	public void lastMove(int c) {
		othersMove = c;
	}
		
	//returns column of where to play a token
	public int playToken(){
	
		int myMove = -1;
		
		if(othersMove == -1){
			//do nothing
		} else {
			board.play(othersID, othersMove);
		}
		
		boolean goodInput = false;
		while(!goodInput){
			System.out.println("where do you want to go?");
			myMove = IO.readInt();
			if(myMove >= 0 && myMove < this.board.getNumCols() && board.play(this.getPlayerID(), myMove)){
				goodInput = true;
			} else {
				System.out.println("either column choice is full or choice is out of bounds");
			}
		}
		return myMove;
	}
	
	//get this player's id
	public int getPlayerID(){
		return ID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		this.board = new Board(board.getNumRows(), board.getNumCols());
		this.othersMove = -1;
	}
	
	
}