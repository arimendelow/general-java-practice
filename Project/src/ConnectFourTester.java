public class ConnectFourTester{
	
	public static void main(String[] args){
		
		//Create new board object
		Board board = new Board(6,7);
		
		//Set player tokens for player 1 and player 2
		board.setPlayerOne('o');
		board.setPlayerTwo('t');
		
		//Create Player objects
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		
//		Player p1 = new HumanPlayer(1,6,7);
		Player p1 = new AIPlayer(1,6,7);
//		Player p1 = new RandPlayer(1,6,7);

		//Player p2 = new HumanPlayer(2,6,7); //comment this line when testing AIPlayer
//		Player p2 = new RandPlayer(2,6,7); //uncomment this line when testing AIPlayer
		Player p2 = new AIPlayer(2,6,7);
		
		
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
		int AIWin = 0, randWin = 0, ties = 0;
		while(AIWin + randWin + ties < 1000){
			while(board.isFinished() == -1){
				
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
//				board.printBoard();
			}
			board.printBoard();
			if(board.isFinished() == 0){
				System.out.println("game ends in a tie!!");
				ties++;
			} else if(board.isFinished() == 1){
				System.out.println("AI wins!!");
				AIWin++;
			} else if(board.isFinished() == 2){
				System.out.println("AI 2.0 wins!!");
				randWin++;
			}
			System.out.println();
			p1.reset();
			p2.reset();
			p = p1.getPlayerID();
			board = new Board(6,7);
		}
		System.out.println("run");
		System.out.println(ties + " ties, " + AIWin + " AI Wins, " + randWin + " AI 2.0 wins");
	}
}