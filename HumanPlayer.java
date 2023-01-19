import java.util.Scanner;

public class HumanPlayer extends Player{

	public HumanPlayer(char symbol, Board board, String name) {
		super(symbol, board, name);
		board.getPlayer1(this.symbol);
		board.getPlayer2(this.symbol);
	}

	@Override
	public void makeMove(Board board) {
		int move = -1;
		Scanner obj = new Scanner(System.in); 
	    System.out.println("Enter your next move: ");
	    if(obj.hasNextInt()) {
	        move = obj.nextInt(); 
	    }
		while (board.isUserInputColumnFull(move)) {
			System.out.println("Your input is invalid!!!\n");
			System.out.println("Please reEnter your next move: ");
			if(obj.hasNextInt()) {
		        move = obj.nextInt(); 
		    }
		}

	    if (move != 0) {
		    move = move - 1;
	    }
	    board.movement(move, super.symbol);
	}
		
	
}
