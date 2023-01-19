public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] data;
	private int rest = 42;
	private char symbolP1;
	private char symbolP2;

	
	public Board() {
		data = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	}
	
	public void printBoard() {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				if (data[i][j] == '\0') {
					System.out.print("|" + " " + "|");
				}
				else {
					System.out.print("|" + data[i][j] + "|");
				}
			}
			System.out.print("\n");
		}
	}
	
	//if ((data[i][j] == (symbolP1) || data[i][j] == (symbolP2)) && (data[i][j+1] == (symbolP1) || data[i][j+1] == (symbolP2)) && (data[i][j+2] == (symbolP1) || data[i][j+2] == (symbolP2)) && (data[i][j+3] == (symbolP1) || data[i][j+3] == (symbolP2))) {
	public boolean containsWin() {
		char[] a = helpAI(false);
		if (a[0] == 1) {
			return true;
		}
		return false;
	}
	
	public boolean isTie() {
		if (rest == 0) {
			return true;
		}
		return false;
	}
	
	public void reset() {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				data[i][j] = '\0';
			}
		}
	}
	
	public void movement(int move, char symbol) {
		if (move == -1) {
			return;
		}
		for (int i = NUM_OF_ROW - 1; i != -1; i--) {
			if (isEmpty(i, move)) {
				data[i][move] = symbol;
				rest = rest - 1;
				break;
			}
		}
		
	}
	
	public void getPlayer1(char player1) {
		if (symbolP1 == '\0') {
			symbolP1 = player1;
		}
	}
	
	public void getPlayer2(char player2) {
		if (symbolP1 != player2) {
			symbolP2 = player2;
		}
		
	}
	
	public boolean isFull(int move) {
		for (int i = NUM_OF_ROW - 1; i != -1; i--) {
			if (isEmpty(i, move)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validMove(int move) {
		return !isFull(move);
	}
	
	public char[] helpAI(boolean AIPlayer) {
		char[] container = new char[8];
		if (rest <= 38) {
			for (int i = NUM_OF_ROW - 1; i != -1; i--) { 
				int count = 0;
				for (int j = NUM_OF_COLUMNS - 1; j != -1; j--) {
					if (data[i][j] == symbolP1) {
						count ++;
					}
					else {
						count = 0;
					}
					if (count == 3 && AIPlayer) {
						if(isEmpty(i, j-1) || isEmpty(i, j+3)) {
							container[4] = (char)(i+'0');
							container[5] = (char)(j+'0');
							container[6] = symbolP1;
							container[7] = 'h';
						}
					}
					if (count == 4) {
						container[0] = 1;
						return container;
					}
				}
				count = 0;
				for (int j = NUM_OF_COLUMNS - 1; j != -1; j--) {
					if (data[i][j] == symbolP2) {
						count ++;
					}
					else {
						count = 0;
					}
					if (count == 3 && AIPlayer) {
						if (isEmpty(i, j-1) || isEmpty(i, j+3)) {
							container[0] = (char)(i+'0');
							container[1] = (char)(j+'0');
							container[2] = symbolP2;
							container[3] = 'h';
							return container;
						}
					}
					if (count == 4) {
						container[0] = 1;
						return container;
					}
				}
			}
			//horizontal check above;
			
			for (int i = NUM_OF_COLUMNS - 1; i != -1; i--) { 
				int count = 0;
				for (int j = NUM_OF_ROW - 1; j != -1; j--) {
					if (data[j][i] == symbolP1) {
						count ++;
					}
					else {
						count = 0;
					}
					if (count == 3 && AIPlayer) {
						if(isEmpty(j-1, i) || isEmpty(j+3, i)) {
							container[4] = (char)(i+'0');
							container[5] = (char)(j+'0');
							container[6] = symbolP1;
							container[7] = 'v';
						}
					}
					if (count == 4) {
						container[0] = 1;
						return container;
					}
				}
				count = 0;
				for (int j = NUM_OF_ROW - 1; j != -1; j--) {
					if (data[j][i] == symbolP2) {
						count ++;
					}
					else {
						count = 0;
					}
					if (count == 3 && AIPlayer) {
						if(isEmpty(j-1, i) || isEmpty(j+3, i)) {
							container[0] = (char)(i+'0');
							container[1] = (char)(j+'0');
							container[2] = symbolP2;
							container[3] = 'v';
							return container;
						}
					}
					if (count == 4) {
						container[0] = 1;
						return container;
					}
				}
			}
			//Vertical check above
			
			//check from [0][0] to [6][7]

			for (int row = 0; row < NUM_OF_ROW; row++) { 
				for (int column = 0; column < NUM_OF_COLUMNS; column++) {
					int count = 0;
					if (data[row][column] != symbolP1) {
						continue;
					}
					for (int four = 0; four < 4; four++) {
						if (row + four <= 5 && column + four <= 6) {

							if (data[row + four][column + four] == symbolP1) {
								count ++;
							}
							else {
								count = 0;
							}
							if (count == 3 && AIPlayer) {
								if (isEmpty(row - 1, column - 1) || isEmpty(row + 3, column + 3)) {
									container[4] = (char)(row +'0');
									container[5] = (char)(column +'0');
									container[6] = symbolP1;
									container[7] = 'u';
								}
							}
							if (count == 4) {
								container[0] = 1;
								return container;
							}
						}
					}
					
				}
			
			}
			for (int row = 0; row < NUM_OF_ROW; row++) { 
				for (int column = 0; column < NUM_OF_COLUMNS; column++) {
					int count = 0;
					if (data[row][column] != symbolP2) {
						continue;
					}
					for (int four = 0; four < 4; four++) {
						if (row + four <= 5 && column + four <= 6) {
							if (data[row + four][column + four] == symbolP2) {
								count ++;
							}
							else {
								count = 0;
							}
							if (count == 3 && AIPlayer) {
								if (isEmpty(row - 1, column - 1) || isEmpty(row + 3, column + 3)) {
									container[0] = (char)(row+'0');
									container[1] = (char)(column+'0');
									container[2] = symbolP2;
									container[3] = 'u';
									return container;
								}
							}
							if (count == 4) {
								container[0] = 1;
								return container;
							}
						}
					}
					
				}
			
			}
			
			//check from [6][0] to [0][7]
			for (int row = 5; row != 0; row--) { 
				for (int column = 0; column < NUM_OF_COLUMNS; column++) {
					int count = 0;
					if (data[row][column] != symbolP1) {
						continue;
					}
					for (int four = 0; four < 4; four++) {
						if (row - four >= 0 && column + four <= 6) {
							if (data[row - four][column + four] == symbolP1) {
								count ++;
							}
							else {
								count = 0;
							}
							if (count == 3 && AIPlayer) {
								if (isEmpty(row + 1, column - 1) || isEmpty(row - 3, column + 3)) {
									container[4] = (char)(row +'0');
									container[5] = (char)(column +'0');
									container[6] = symbolP1;
									container[7] = 'd';
								}

							}
							if (count == 4) {
								container[0] = 1;
								return container;
							}
						}
					}
					
				}
			
			}
			
			for (int row = 5; row != 0; row--) { 
				for (int column = 0; column < NUM_OF_COLUMNS; column++) {
					int count = 0;
					if (data[row][column] != symbolP2) {
						continue;
					}
					for (int four = 0; four < 4; four++) {
						if (row - four >= 0 && column + four <= 6) {
							if (data[row - four][column + four] == symbolP2) {
								count ++;
							}
							else {
								count = 0;
							}
							if (count == 3 && AIPlayer) {
								if (isEmpty(row + 1, column - 1) || isEmpty(row - 3, column + 3)) {
									container[0] = (char)(row +'0');
									container[1] = (char)(column +'0');
									container[2] = symbolP2;
									container[3] = 'd';
									return container;
								}
							}
							if (count == 4) {
								container[0] = 1;
								return container;
							}
						}
					}
					
				}
			
			}
			
			//Diagonal Check above.
			
		
			
		}
		return container;
	}

	
	
	public boolean isEmpty(int i, int j) {
		if (i < 0 || j < 0 || i > 5 || j > 6) {
			return false;
		}
		if (data[i][j] == '\0') {
			return true;
		}
		return false;
	}
	
	public boolean isUserInputColumnFull(int move) {
		for (int i = NUM_OF_ROW - 1; i != -1; i--) {
			if (data[i][move - 1] == '\0') {
				return false;
			}
		}
		return true;
	}
	
}
