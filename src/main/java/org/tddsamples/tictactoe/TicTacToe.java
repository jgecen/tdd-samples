package org.tddsamples.tictactoe;

public class TicTacToe {

	private String[][] table = new String[3][3];

	private String playerInTurn;

	public void setPlayers(String string, String string2) {
	}

	public TicTacToe player(String player) {
		this.playerInTurn = player;
		return this;
	}

	public boolean play(int i, int j) {
		if (occupied(i, j)) {
			return false;
		}
		table[i][j] = playerInTurn;
		return true;
	}

	public String winner() {
		String winner = lineFull();
		if (winner == null) {
			winner = columnFull();
		}
		if (winner == null) {
			winner = diagonalFull();
		}
		if (winner == null) {
			winner = otherDiagonalFull();
		}
		return winner;
	}

	private String otherDiagonalFull() {
		return checkFull(0, 2, 1, 1, 2, 0);
	}

	private String diagonalFull() {
		return checkFull(0, 0, 1, 1, 2, 2);
	}

	private String columnFull() {
		return checkFull(0, 0, 1, 0, 2, 0);
	}

	private String lineFull() {
		String winner = checkFull(0, 0, 0, 1, 0, 2);
		if (winner == null) {
			winner = checkFull(1, 0, 1, 1, 1, 2);
		}
		if (winner == null) {
			winner = checkFull(2, 0, 2, 1, 2, 2);
		}
		return winner;
	}
	
	private String checkFull(int a, int b, int c, int d, int e, int f) {
		String winner = table[a][b];
		return table[a][b] == winner && table[c][d] == winner
				&& table[e][f] == winner ? winner : null;
	}

	public Boolean occupied(int i, int j) {
		return table[i][j] != null;
	} 	
}
