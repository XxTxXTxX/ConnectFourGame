import java.util.Random;

public class AIPlayer extends Player{

	private boolean AIPlayer = true;
	public AIPlayer(char symbol, Board board, String name) {
		super(symbol, board, name);
		board.getPlayer1(this.symbol);
		board.getPlayer2(this.symbol);
	}

	@Override
	public void makeMove(Board board) {
		char[] container;
		Random num = new Random();
		int move = num.nextInt(6) + 1;
		int arrayPos = 6;
		int opponent = 2;
		
		container = board.helpAI(AIPlayer);
		if (container[6] != super.symbol) {
			arrayPos = 2;
			opponent = 6;
		}
		
		
		int rowPosition = container[arrayPos - 2] - '0';
		int columnPosition = container[arrayPos - 1] - '0';
		
		
		//Against opponent player::::
		
		
		int oppRowPosition = container[opponent - 2] - '0';
		int oppColumnPosition = container[opponent - 1] - '0';
		
		if (container[opponent + 1] == 'h'){
			if (board.isEmpty(oppRowPosition, oppColumnPosition - 1)) {
				board.movement(oppColumnPosition - 1, super.symbol);
			}
			else if (board.isEmpty(oppRowPosition, oppColumnPosition + 3)) {
				board.movement(oppColumnPosition + 3, super.symbol);
			}
			else {
				while (!board.validMove(move)) {
					move = num.nextInt(6) + 1;
				}
				board.movement(move, super.symbol);
			}
		}
		
		
		
		else if (container[opponent + 1] == 'v'){
			if (board.isEmpty(oppRowPosition, oppColumnPosition - 1)) {
				board.movement(oppRowPosition, super.symbol);
			}
			else {
				while (!board.validMove(move)) {
					move = num.nextInt(6) + 1;
				}
				board.movement(move, super.symbol);
			}
		}
		
		
		
		else if (container[opponent + 1] == 'u') {
			if (board.isEmpty(oppRowPosition - 1, oppColumnPosition - 1)) {
				board.movement(oppColumnPosition - 1, super.symbol);
			}
			else if (board.isEmpty(oppRowPosition + 3, oppColumnPosition + 3)) {
				board.movement(oppColumnPosition + 3, super.symbol);
			}
			else {
				while (!board.validMove(move)) {
					move = num.nextInt(6) + 1;
				}
				board.movement(move, super.symbol);
			}
		}
		
		else if (container[opponent + 1] == 'd') {
			if (board.isEmpty(oppRowPosition + 1, oppColumnPosition - 1)) {
				board.movement(oppColumnPosition - 1, super.symbol);
			}
			else if (board.isEmpty(oppRowPosition - 3, oppColumnPosition + 3)) {
				board.movement(oppColumnPosition + 3, super.symbol);
			}
			else {
				while (!board.validMove(move)) {
					move = num.nextInt(6) + 1;
				}
				board.movement(move, super.symbol);
			}
		}
		
		else if(container[opponent + 1] != 'r' && container[opponent + 1] != 'l' && container[opponent + 1] != 'v' && container[opponent + 1] != 'h') {
			//Self WinWin
			
			
			if (container[arrayPos + 1] == 'h' && container[arrayPos] == super.symbol){
				if (board.isEmpty(rowPosition, columnPosition - 1)) {
					board.movement(columnPosition - 1, super.symbol);
				}
				else if (board.isEmpty(rowPosition, columnPosition + 3)) {
					board.movement(columnPosition + 3, super.symbol);
				}
				else {
					while (!board.validMove(move)) {
						move = num.nextInt(6) + 1;
					}
					board.movement(move, super.symbol);
				}
			}
			
			
			
			else if (container[arrayPos + 1] == 'v' && container[arrayPos] == super.symbol){
				if (board.isEmpty(rowPosition, columnPosition - 1)) {
					board.movement(rowPosition, super.symbol);
				}
				else {
					while (!board.validMove(move)) {
						move = num.nextInt(6) + 1;
					}
					board.movement(move, super.symbol);
				}
			}
			
			
			
			else if (container[arrayPos + 1] == 'u' && container[arrayPos] == super.symbol) {
				if (board.isEmpty(rowPosition - 1, columnPosition - 1)) {
					board.movement(columnPosition - 1, super.symbol);
				}
				else if (board.isEmpty(rowPosition + 3, columnPosition + 3)) {
					board.movement(columnPosition + 3, super.symbol);
				}
				else {
					while (!board.validMove(move)) {
						move = num.nextInt(6) + 1;
					}
					board.movement(move, super.symbol);
				}
			}
			
			else if (container[arrayPos + 1] == 'd' && container[arrayPos] == super.symbol) {
				if (board.isEmpty(rowPosition + 1, columnPosition - 1)) {
					board.movement(columnPosition - 1, super.symbol);
				}
				else if (board.isEmpty(rowPosition - 3, columnPosition + 3)) {
					board.movement(columnPosition + 3, super.symbol);
				}
				else {
					while (!board.validMove(move)) {
						move = num.nextInt(6) + 1;
					}
					board.movement(move, super.symbol);
				}
			}
			
			else if(container[arrayPos + 1] != 'r' && container[arrayPos + 1] != 'l' && container[arrayPos + 1] != 'v' && container[arrayPos + 1] != 'h') {
				while (!board.validMove(move)) {
					move = num.nextInt(6) + 1;
				}
				board.movement(move, super.symbol);
			}
			
		}
		
		
		
		
		

	}
	}
