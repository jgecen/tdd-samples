package org.tddsamples.tictactoe;

public class TicTacToe {

	private String[][] table = new String[3][3];

	private String playerInTurn;

	private String[] players = new String[2];

	public void setPlayers(String player1, String player2) {
		this.players[0] = player1;
		this.players[1] = player2;
	}

	public TicTacToe player(String player) {
		this.playerInTurn = player;
		return this;
	}

	public boolean play(int i, int j) {
		if (validPlayerInTurn() || occupied(i, j)) {
			return false;
		}
		table[i][j] = playerInTurn;
		return true;
	}

	private boolean validPlayerInTurn() {
		return !playerInTurn.equals(players[0])
				&& !playerInTurn.equals(players[1]);
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
		for (int i = 0; i <= 2; i++) {
			String winner = checkFull(0, i, 1, i, 2, i);
			if (winner != null) {
				return winner;
			}
		}
		return null;
	}

	private String lineFull() {
		for (int i = 0; i <= 2; i++) {
			String winner = checkFull(i, 0, i, 1, i, 2);
			if (winner != null) {
				return winner;
			}
		}
		return null;
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
