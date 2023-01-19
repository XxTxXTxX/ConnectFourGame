
public class ConnectGame {
	
	public static void main(String[] args) {
		Board board = new Board();
		ConnectFour game = new ConnectFour(board);
		game.setPlayer1(new HumanPlayer('E', board, "Errin"));
		game.setPlayer2(new AIPlayer('J', board, "James"));
	    game.playGame();
	}
}
