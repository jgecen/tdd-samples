package org.tddsamples.tictactoe;

public class Board {
	private String[][] table;

	public Board() {
		this.table = new String[3][3];
	}

	public boolean play(String player, int i, int j) {
		if (occupied(i, j)) {
			return false;
		}
		table[i][j] = player;
		return true;
	}

	public String checkWinner(int a, int b, int c, int d, int e, int f) {
		String winner = table[a][b];
		return table[a][b] == winner && table[c][d] == winner
				&& table[e][f] == winner ? winner : null;
	}

	public Boolean occupied(int i, int j) {
		return table[i][j] != null;
	}

	public String winner() {
		String winner = winnerInLine();
		if (winner == null) {
			winner = winnerIncolumns();
		}
		if (winner == null) {
			winner = winnerInDiagonals();
		}
		return winner;
	}

	private String winnerInDiagonals() {
		String winner = checkWinner(0, 2, 1, 1, 2, 0);
		return winner == null ? checkWinner(0, 0, 1, 1, 2, 2) : winner;
	}

	private String winnerIncolumns() {
		for (int i = 0; i <= 2; i++) {
			String winner = checkWinner(0, i, 1, i, 2, i);
			if (winner != null) {
				return winner;
			}
		}
		return null;
	}

	private String winnerInLine() {
		for (int i = 0; i <= 2; i++) {
			String winner = checkWinner(i, 0, i, 1, i, 2);
			if (winner != null) {
				return winner;
			}
		}
		return null;
	}
}