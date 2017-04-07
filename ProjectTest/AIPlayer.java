
public class AIPlayer implements Player{
//do not change the line above	
	
	Board board;
	
	int ID, numRows, numCols;
	int dontGo1, dontGo2, dontGo3, dontGo4, dontGo5, dontGo6;
	int othersID = -1;
	int othersMove = -1;
	char othersToken, myToken;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		ID = playerID;
		board = new Board(row, col);
		board.setPlayerOne('o');
		board.setPlayerTwo('t');
		
		if(ID == 1){
			othersID = 2;
			othersToken = board.getPlayerTwo();
			myToken = board.getPlayerOne();
		} else {
			othersID = 1;
			othersToken = board.getPlayerOne();
			myToken = board.getPlayerTwo();
		}
	}
	
	//receives the most recent move from the other player
	public void lastMove(int c) {
		othersMove = c;
	}
	
	private int checkHorWinLong(Board board) { //check for horizontal (rows) win
		
		for(int i = 0; i < board.getNumRows(); i++){
			for(int j = 0; j < board.getNumCols() - 2; j++){
				if(board.getToken(i, j) == board.getToken(i, j + 1) && board.getToken(i, j + 1) == board.getToken(i, j + 2)){
					if(board.getToken(i, j) != ' ' && board.getToken(i, j) == othersToken){
						if(board.getToken(i, j + 3) == ' ' && board.getToken(i + 1, j + 3) != ' '){
							return j + 3;
						} else if(board.getToken(i, j - 1) == ' ' && board.getToken(i + 1, j - 1) != ' '){
							return j - 1;
						}
					}
				}
			}
		}
		return -1;
	}
	private int checkVertWinLong(Board board) { //check for vertical (column) win
		
		for(int j = 0; j < board.getNumCols(); j++){
			for(int i = 0; i < board.getNumRows() - 2; i++){
				if(board.getToken(i, j) == board.getToken(i + 1, j) && board.getToken(i + 1, j) == board.getToken(i + 2, j)){
					if(board.getToken(i, j) != ' ' && board.getToken(i, j) == othersToken && board.getToken(i - 1, j) == ' ') {
						return j;
					}
				}
			}
		}
		return -1;
	}
    private int checkDiagWinLong(Board board) { //check for diagonal win
    	
    // diagonally down
    	for (int i = 0; i < board.getNumRows() - 2; i++) { // Checks to see if same colored tokens are lining diagonally to the left
            for (int j = 0; j < board.getNumCols() - 2; j++) {
                if (board.getToken(i, j) == board.getToken(i + 1, j + 1) && board.getToken(i + 1, j + 1) == board.getToken(i + 2, j + 2)){
                	if(board.getToken(i, j) != ' ' && board.getToken(i, j) == othersToken) {
                		if(board.getToken(i, j - 1) != ' ' && board.getToken(i - 1, j - 1) == ' '){
                			return j - 1;
                		} else if(board.getToken(i + 2, j + 3) != ' ' && board.getToken(i + 3, j + 3) == ' '){
                			return j + 3;
                		}
                	}
                }
            }
        }
    	
    	// diagonally up
    	for(int i = 1; i < board.getNumRows(); i++){ // checks to see if tokens are lining diagonally to the right
    		for(int j = 0; j < board.getNumCols() - 2; j++){
    			if(board.getToken(i, j) == board.getToken(i - 1, j + 1) && (board.getToken(i - 1, j + 1) == board.getToken(i - 2, j + 2))){
    				if(board.getToken(i, j) != ' ' && board.getToken(i, j) == othersToken){
    					if(board.getToken(i + 2, j - 1) != ' ' && board.getToken(i + 1, j - 1) == ' '){
    						return j - 1;
    					} else if((board.getToken(i - 2, j + 3) != ' ') && board.getToken(i - 3, j + 3) == ' '){
    						return j + 3;
    					}
    				}
    			}
    		}
    	}
    	return -1;
    }
	
	private int checkHorWin(Board board) { //check for horizontal (rows) win
		
		for(int i = 0; i < board.getNumRows(); i++){
			for(int j = 0; j < board.getNumCols() - 1; j++){
				if(board.getToken(i, j) == board.getToken(i, j + 1)){
					if(board.getToken(i, j) != ' ' && board.getToken(i, j) == othersToken){
						if(board.getToken(i, j + 2) == ' ' && board.getToken(i + 1, j + 2) != ' '){
							return j + 2;
						} else if(board.getToken(i, j - 1) == ' ' && board.getToken(i + 1, j - 1) != ' '){
							return j - 1;
						}
					}
				}
			}
		}
		return -1;
	}
	private int checkVertWin(Board board) { //check for vertical (column) win
		
		for(int j = 0; j < board.getNumCols(); j++){
			for(int i = 0; i < board.getNumRows() - 2; i++){
				if(board.getToken(i, j) == board.getToken(i + 1, j) && board.getToken(i + 1, j) == board.getToken(i+2, j)){
					if(board.getToken(i, j) != ' ' && board.getToken(i, j) == othersToken && board.getToken(i - 1, j) == ' ') {
						return j;
					}
				}
			}
		}
		return -1;
	}
    private int checkDiagWin(Board board) { //check for diagonal win
    	
    // diagonally down
    	for (int i = 0; i < board.getNumRows() - 1; i++) { // Checks to see if same colored tokens are lining diagonally to the left
            for (int j = 0; j < board.getNumCols() - 1; j++) {
                if (board.getToken(i, j) == board.getToken(i + 1, j + 1)){
                	if(board.getToken(i, j) != ' ' && board.getToken(i, j) == othersToken) {
                		if(board.getToken(i, j - 1) == ' ' && board.getToken(i - 1, j - 1) == ' '){
                			dontGo3 = j - 1;
                		} else if(board.getToken(i + 3, j + 2) == ' ' && board.getToken(i + 2, j + 2) == ' '){
                			dontGo4 =  j + 2;
                		}
                		if(board.getToken(i, j - 1) != ' ' && board.getToken(i - 1, j - 1) == ' '){
                			return j - 1;
                		} else if(board.getToken(i + 3, j + 2) != ' ' && board.getToken(i + 3, j + 2) == ' '){
                			return j + 2;
                		}
                	}
                }
            }
        }
    	
    	// diagonally up
    	for(int i = 1; i < board.getNumRows(); i++){ // checks to see if tokens are lining diagonally to the right
    		for(int j = 0; j < board.getNumCols() - 1; j++){
    			if(board.getToken(i, j) == board.getToken(i - 1, j + 1)){
    				if(board.getToken(i, j) != ' ' && board.getToken(i, j) == othersToken){
    					if(board.getToken(i + 2, j - 1) == ' ' && board.getToken(i + 1, j - 1) == ' '){
    						dontGo5 = j - 1;
    					} else if(board.getToken(i - 1, j + 2) == ' ' && board.getToken(i - 2, j + 2) == ' '){
    						dontGo6 = j + 2;
    					}
    					if(board.getToken(i + 2, j - 1) != ' ' && board.getToken(i + 1, j - 1) == ' '){
    						return j - 1;
    					} else if((board.getToken(i - 1, j + 2) != ' ') && board.getToken(i - 2, j + 2) == ' '){
    						return j + 2;
    					}
    				}
    			}
    		}
    	}
    	return -1;
    }
	
	private int checkHorWinSelfLong(Board board) { //check for horizontal (rows) win
		
		for(int i = 0; i < board.getNumRows(); i++){
			for(int j = 0; j < board.getNumCols() - 2; j++){
				if(board.getToken(i, j) == board.getToken(i, j + 1) && board.getToken(i, j + 1) == board.getToken(i, j + 2)){
					if(board.getToken(i, j) != ' ' && board.getToken(i, j) == myToken){
						if(board.getToken(i, j + 3) == ' ' && board.getToken(i + 1, j + 3) != ' '){
							return j + 3;
						} else if(board.getToken(i, j - 1) == ' ' && board.getToken(i + 1, j - 1) != ' '){
							return j - 1;
						}
					}
				}
			}
		}
		return -1;
	}
	private int checkVertWinSelfLong(Board board) { //check for vertical (column) win
		
		for(int j = 0; j < board.getNumCols(); j++){
			for(int i = 0; i < board.getNumRows() - 2; i++){
				if(board.getToken(i, j) == board.getToken(i + 1, j) && board.getToken(i + 1, j) == board.getToken(i + 2, j)){
					if(board.getToken(i, j) != ' ' && board.getToken(i, j) == myToken && board.getToken(i - 1, j) == ' ') {
						return j;
					}
				}
			}
		}
		return -1;
	}
    private int checkDiagWinSelfLong(Board board) { //check for diagonal win
    	
    // diagonally down
    	for (int i = 0; i < board.getNumRows() - 2; i++) { // Checks to see if same colored tokens are lining diagonally to the left
            for (int j = 0; j < board.getNumCols() - 2; j++) {
                if (board.getToken(i, j) == board.getToken(i + 1, j + 1) && board.getToken(i + 1, j + 1) == board.getToken(i + 2, j + 2)){
                	if(board.getToken(i, j) != ' ' && board.getToken(i, j) == myToken) {
                		if(board.getToken(i, j - 1) != ' ' && board.getToken(i - 1, j - 1) == ' '){
                			return j - 1;
                		} else if(board.getToken(i + 2, j + 3) != ' ' && board.getToken(i + 3, j + 3) == ' '){
                			return j + 3;
                		}
                	}
                }
            }
        }
    	
    	// diagonally up
    	for(int i = 1; i < board.getNumRows(); i++){ // checks to see if tokens are lining diagonally to the right
    		for(int j = 0; j < board.getNumCols() - 2; j++){
    			if(board.getToken(i, j) == board.getToken(i - 1, j + 1) && (board.getToken(i - 1, j + 1) == board.getToken(i - 2, j + 2))){
    				if(board.getToken(i, j) != ' ' && board.getToken(i, j) == myToken){
    					if(board.getToken(i + 2, j - 1) != ' ' && board.getToken(i + 1, j - 1) == ' '){
    						return j - 1;
    					} else if((board.getToken(i - 2, j + 3) != ' ') && board.getToken(i - 3, j + 3) == ' '){
    						return j + 3;
    					}
    				}
    			}
    		}
    	}
    	return -1;
    }
    
    private int checkHorWinSelf(Board board) { //check for horizontal (rows) win
		
		for(int i = 0; i < board.getNumRows(); i++){
			for(int j = 0; j < board.getNumCols() - 1; j++){
				if(board.getToken(i, j) == board.getToken(i, j + 1)){
					if(board.getToken(i, j) != ' ' && board.getToken(i, j) == myToken){
						if(board.getToken(i, j + 2) == ' ' && board.getToken(i + 1, j + 2) != ' '){
							return j + 2;
						} else if(board.getToken(i, j - 1) == ' ' && board.getToken(i + 1, j - 1) != ' '){
							return j - 1;
						}
					}
				}
			}
		}
		return -1;
	}
	private int checkVertWinSelf(Board board) { //check for vertical (column) win
		
		for(int j = 0; j < board.getNumCols(); j++){
			for(int i = 0; i < board.getNumRows() - 2; i++){
				if(board.getToken(i, j) == board.getToken(i + 1, j) && board.getToken(i + 1, j) == board.getToken(i+2, j)){
					if(board.getToken(i, j) != ' ' && board.getToken(i, j) == myToken && board.getToken(i - 1, j) == ' ') {
						return j;
					}
				}
			}
		}
		return -1;
	}
    private int checkDiagWinSelf(Board board) { //check for diagonal win
    	
    // diagonally down
    	for (int i = 0; i < board.getNumRows() - 1; i++) { // Checks to see if same colored tokens are lining diagonally to the left
            for (int j = 0; j < board.getNumCols() - 1; j++) {
                if (board.getToken(i, j) == board.getToken(i + 1, j + 1)){
                	if(board.getToken(i, j) != ' ' && board.getToken(i, j) == myToken) {
                		if(board.getToken(i, j - 1) != ' ' && board.getToken(i - 1, j - 1) == ' '){
                			return j - 1;
                		} else if(board.getToken(i + 3, j + 2) != ' ' && board.getToken(i + 3, j + 2) == ' '){
                			return j + 2;
                		}
                	}
                }
            }
        }
    	
    	// diagonally up
    	for(int i = 1; i < board.getNumRows(); i++){ // checks to see if tokens are lining diagonally to the right
    		for(int j = 0; j < board.getNumCols() - 1; j++){
    			if(board.getToken(i, j) == board.getToken(i - 1, j + 1)){
    				if(board.getToken(i, j) != ' ' && board.getToken(i, j) == othersToken){
    					if(board.getToken(i + 2, j - 1) == ' ' && board.getToken(i + 1, j - 1) == ' '){
    						dontGo5 = j - 1;
    					} else if(board.getToken(i - 1, j + 2) == ' ' && board.getToken(i - 2, j + 2) == ' '){
    						dontGo6 = j + 2;
    					}
    					if(board.getToken(i + 2, j - 1) != ' ' && board.getToken(i + 1, j - 1) == ' '){
    						return j - 1;
    					} else if((board.getToken(i - 1, j + 2) != ' ') && board.getToken(i - 2, j + 2) == ' '){
    						return j + 2;
    					}
    				}
    			}
    		}
    	}
    	return -1;
    }
	
	//returns column of where to play a token
	public int playToken(){
		
		if(this.othersMove == -1){
			//do nothing
		} else {
			board.play(othersID, this.othersMove);
		}
		int myMove = -1;
		int loop = 0;
		while(myMove == -1){
			
			if(myMove == -1){
				myMove = checkDiagWinLong(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See opponent diagonal potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			if(myMove == -1){
				myMove = checkVertWinLong(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See opponent vert potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			if(myMove == -1){
				myMove = checkHorWinLong(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See opponent horizontal potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}

			if(myMove == -1){
				myMove = checkDiagWin(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See opponent diagonal potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			if(myMove == -1){
				myMove = checkVertWin(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See opponent vert potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			if(myMove == -1){
				myMove = checkHorWin(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See opponent horizontal potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			
			if(myMove == -1){
				myMove = checkDiagWinSelfLong(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See my diagonal potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			if(myMove == -1){
				myMove = checkVertWinSelfLong(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See my vertical potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			if(myMove == -1){
				myMove = checkHorWinSelfLong(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See my horizontal potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			
			if(myMove == -1){
				myMove = checkDiagWinSelf(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See my diagonal potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			if(myMove == -1){
				myMove = checkVertWinSelf(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See my vertical potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			if(myMove == -1){
				myMove = checkHorWinSelf(this.board);
				if(myMove != -1){
					if((board.play(this.getPlayerID(), myMove))){
//						System.out.println("See my horizontal potential at " + myMove);
//						System.out.println("Going " + myMove);
						return myMove;
					}
				}
			}
			
			if(myMove == -1){
				myMove = (int)((Math.random() * ((board.getNumCols()))));
				if((board.play(this.getPlayerID(), myMove))){
//					System.out.println("See no potential wins, so");
//					System.out.println("going randomly at " + myMove);
					return myMove;
				} else {
					myMove = -1;
				}
			}
			if(loop > 20){
				break;
			}
			loop++;
//			System.out.println("looping AI player");
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