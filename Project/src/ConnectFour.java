public class ConnectFour{
	
	public static void main(String[] args){
		
		//Create new board object
		Board board = new Board(6, 7);
		CFGUI gui = new CFGUI(board, ChipColor.BLUE, ChipColor.RED);
		
		//Set player tokens for player 1 and player 2
		board.setPlayerOne('o');
		board.setPlayerTwo('t');
		
		//Create Player objects
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		
		Player p1 = new HumanPlayer(1,6,7);
//		Player p1 = new AIPlayer(1,6,7);

		//Player p2 = new HumanPlayer(2,6,7); //comment this line when testing AIPlayer
		Player p2 = new AIPlayer(2,6,7); //uncomment this line when testing AIPlayer
		
		
		//Print your empty board
		board.printBoard();
		
		//WHILE the board is still playable
		//	get a column to play from player 1
		//	play that token on the board
		//  print the board
		//		has anyone won yet?
		// do the above for player 2
		int p = p1.getPlayerID();
		int c;
		while(board.isFinished() == -1){
			gui.redraw();
			System.out.println("Player " + p + "'s turn!");
			if(p == p1.getPlayerID()) {
				c = p1.playToken();
				board.play(p1.getPlayerID(), c);
				p2.lastMove(c);
				p = p2.getPlayerID();
			} else {
				c = p2.playToken();
				board.play(p2.getPlayerID(), c);
				p1.lastMove(c);
				p = p1.getPlayerID();
			}
			board.printBoard();
			System.out.println();
		}
		
		// Get the status code from the board (isFinished())
		// Print out the results of the game
		System.out.println();
		gui.redraw();
		if(board.isFinished() == 0){
			System.out.println("game ends in a tie!!");
			gui.gameOver(0);
			gui.close();
			return;
		} else if(board.isFinished() == 1){
			System.out.println("player 1 wins!!");
			gui.gameOver(1);
			gui.close();
			return;
		} else if(board.isFinished() == 2){
			System.out.println("player 2 wins!!");
			gui.gameOver(2);
			gui.close();
			return;
		}
		
	}
	
}