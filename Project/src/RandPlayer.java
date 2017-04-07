
public class RandPlayer implements Player{
//do not change the line above	
	
	Board board;
	
	int ID, numRows, numCols;
	int othersID = -1;
	int othersMove = -1;
	char othersToken;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public RandPlayer(int playerID, int row, int col){
		ID = playerID;
		board = new Board(row, col);
		
		if(ID == 1){
			othersID = 2;
			othersToken = board.getPlayerTwo();
		} else {
			othersID = 1;
			othersToken = board.getPlayerOne();
		}
	}
	//receives the most recent move from the other player
	public void lastMove(int c) {
		othersMove = c;
	}
	//returns column of where to play a token
	public int playToken(){
		
		if(this.othersMove == -1){
			//do nothing
		} else {
			board.play(othersID, this.othersMove);
		}
		int myMove = -1;
		while(myMove == -1){
			myMove = (int)((Math.random() * ((board.getNumCols()))));
			if((board.play(this.getPlayerID(), myMove))){
				return myMove;
			}
//			for(int i = 0; i < board.getNumCols(); i++){
//				if(board.getToken(0, i) == ' '){
//					return myMove = i;
//				}
//			}
			System.out.println("looping Rand player");
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