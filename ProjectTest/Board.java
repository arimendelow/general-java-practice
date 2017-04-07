
public class Board {
	public char[][] board, theBoard;
	private char playerOne, playerTwo;
	
	public void printBoard() { //print current board
		
		char[][] board = this.board;
		
		for(int i = 0; i < getNumRows(); i++) {
			System.out.print("| ");
			for(int j = 0; j < getNumCols(); j++) {
				System.out.print(board[i][j] + "| ");
			}
			System.out.println();
		}
		int rowNum = 0;
		for(int j = 0; j < getNumCols(); j++) {
			System.out.print("*" + rowNum + "*");
			rowNum++;
		}
		System.out.println();
	}
	
	Board() { //creates a default board of size 7 columns x 6 rows 
		
		this.board = new char[6][7]; 
		for(int i = 0; i < 6; i++){ //iterate 6 rows
			for(int j = 0; j < 7; j++){ //iterate 7 columns
				board[i][j] = ' '; //init all places to space
			}
		}
		theBoard = this.board;
		setPlayerOne('o');
		setPlayerTwo('t');
		
	}
 	Board(int putRow, int putCol){ //creates a board of size numRows x numCols
 		
 		if(putRow <= 0 || putCol <= 0){
 			putRow = 6;
 			putCol = 7;
 		}
		
		this.board = new char[putRow][putCol]; 
		for(int i = 0; i < putRow; i++){ //iterate numRows rows
			for(int j = 0; j < putCol; j++){ //iterate numCols columns
				board[i][j] = ' '; //init all places to space
			}
		}
		theBoard = this.board;
		setPlayerOne('o');
		setPlayerTwo('t');
	}
 	
 	Board(int a){ //creates a board of size numRows x numCols
 		
		char[][] theBoard = {{' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' '},{' ',' ','o',' ','t',' ',' '},{' ','t','o',' ','t',' ',' '},{'t','t','o','o','o',' ','t'},{'o','o','o','t','o','t','t'}}; 

		this.board = theBoard;
		setPlayerOne('o');
		setPlayerTwo('t');
	}
 	
	public int getNumRows() { //returns the number of rows in board 
		return board.length;
	}	public int getNumCols(){ //returns the number of cols in board 
		return board[0].length;
	}
	public char getPlayerOne() { //returns char representing player 1 
		return playerOne;
	}
	public char getPlayerTwo() { //returns char representing player 2 
		return playerTwo;
	}
	public void setPlayerOne(char o) { //sets char representing player 1
		playerOne = o;
	}
	public void setPlayerTwo(char t) { //sets char representing player 2
		playerTwo = t;
	}
	public char getToken(int row, int col){ //returns the char representing token at location row, col, returns '\0' if indices are invalid 
		if((row >= 0 && row < getNumRows()) && (col >=0 && col < getNumCols())) {
			return board[row][col];
		} else {
			return '\0';
		}
	}
	public boolean canPlay(){ //returns true if a token is still able to placed onto the board, false otherwise 
		for(int i = 0; i < getNumRows(); i++){
			if(board[0][i] == ' '){
				return true;
			}
		}
		return false;
	}
	public boolean play(int p, int c){ //places the appropriate token for player p in column c. returns true if successful, false otherwise. 
		char token;
		
		if(p!= 1 && p != 2){
			return false;
		}
		if(c < 0 || c > this.getNumRows()){
			return false;
		}
		
		if(p == 1){
			token = getPlayerOne();
		} else {
			token = getPlayerTwo();
		}
		
		if (board[0][c] != ' '){
			return false;
		} else {
			for (int i = 0; i < getNumRows(); i++) {
				if (board[i][c] != ' ') {
					board[i-1][c] = token;
					return true;
				}
			}
			board[getNumRows()-1][c] = token;
		return true;
		}
	}
	
	private char checkHorWin(char[][] board) { //check for horizontal (rows) win
		
		for(int i = 0; i < getNumRows(); i++){
			for(int j = 0; j < getNumCols() - 3; j++){
				if(board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j + 2] == board[i][j + 3]){
					if(board[i][j] != ' '){
						return board[i][j];
					}
				}
			}
		}
		return ' ';
	}
	private char checkVertWin(char[][] board) { //check for vertical (column) win
		
		for(int j = 0; j < getNumCols(); j++){
			for(int i = 0; i < getNumRows() - 3; i++){
				if(board[i][j] == board[i+1][j] && board[i+1][j] == board[i+2][j] && board[i+2][j] == board[i+3][j]){
					if(board[i][j] != ' '){
						return board[i][j];
					}
				}
			}
		}
		return ' ';
	}
    private char checkDiagWin(char[][] board) { //check for diagonal win
    	
    // diagonally down
    	for (int i = 0; i < getNumRows() - 3; i++) { // Checks to see if same colored tokens are lining diagonally to the left
            for (int j = 0; j < getNumCols() - 3; j++) {
                if (board[i][j] == board[i + 1][j + 1] && board[i +1 ][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3]) {
                	if(board[i][j] != ' '){
						return board[i][j];
					}
                }
            }
        }
    	
    	// diagonally up
    	for(int i = 3; i < getNumRows(); i++){ // checks to see if tokens are lining diagonally to the right
    		for(int j = 0; j < getNumCols() - 3; j++){
    			if(board[i][j] == board[i - 1][j + 1] && board[i - 1][j + 1] == board[i - 2][j + 2] && board[i - 2][j + 2] == board[i - 3][j + 3]){
    				if(board[i][j] != ' '){
						return board[i][j];
					}
    			}
    		}
    	}
    	return ' ';
    }
    
    public int isFinished() { //returns either the ID of the player who has won (1 or 2) OR 0 if the game has ended in a tie OR -1 if nobody has won yet

		if(checkHorWin(board) != ' '){
			if(checkHorWin(board) == getPlayerOne()){
				return 1;
			} else {
				return 2;
			}
		}
		if(checkVertWin(board) != ' ') {
			if(checkVertWin(board) == getPlayerOne()) {
				return 1;
			} else {
				return 2;
			}
		}
		if(checkDiagWin(board) != ' ') {
			if(checkDiagWin(board) == getPlayerOne()) {
				return 1;
			} else {
				return 2;
			}
		}
		int yes = 0;
		for(int j = 0; j < getNumCols(); j++) {
			if(board[0][j] == ' ') {
				yes++;
			} 
		}
		if(yes > 0){
			return -1;
		} else {
			return 0;
		} 
	}
	
	public static void main(String[] args) {
		Board board;
		
		System.out.println("1 default board, 2 for custom board");
		int input = IO.readInt();
		
		if(input == 2){
			System.out.println("how many rows?");
			int numRows = IO.readInt();
			System.out.println("how many columns?");
			int numCols = IO.readInt();
			board = new Board(numRows, numCols);
			board.printBoard();
			System.out.println();
		} else {
			board = new Board();
			board.printBoard();
			System.out.println();
		}
		
		System.out.println("now you need to choose the symbols you want to use for each player.");
		System.out.println("Player 1 symbol?");
		board.setPlayerOne(IO.readChar());
		
		System.out.println("Player 2 symbol?");
		board.setPlayerTwo(IO.readChar());
		
		System.out.println("Great! Time to play.");
		
		int p = 1;
		
		while(board.canPlay()){
			
			if(p == 1){
				System.out.println("Player one's turn!");
			} else {
				System.out.println("Player two's turn!");
			}
			System.out.println("Choose column (0 - " + (board.getNumCols() - 1) + ") to drop piece:");
			int c = IO.readInt();
			if(c < 0 || c > board.getNumCols() - 1){
				System.out.println("column choice must be between 0 and " + (board.getNumCols() - 1));
				continue;
			}
			if(!board.play(p, c)){
				System.out.println("this column is full!");
			}
			
			board.printBoard();
			
			System.out.println();
			
			if(board.isFinished() == -1){
				//do nothing;
			} else if(board.isFinished() == 0){
				System.out.println("game ends in a tie!!");
				return;
			} else if(board.isFinished() == 1){
				System.out.println("player 1 wins!!");
				return;
			} else if(board.isFinished() == 2){
				System.out.println("player 2 wins!!");
				return;
			}
			
			if(p == 1){
				p = 2;
			} else if(p == 2){
				p = 1;
			}
		}
	}
}