package org.tddsamples.tictactoe;

public class TicTacToe {

	private Board board = new Board();

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
		return validPlayerInTurn() && board.play(playerInTurn, i, j);
	}

	private boolean validPlayerInTurn() {
		return playerInTurn.equals(players[0]) || playerInTurn.equals(players[1]);
	}

	public boolean occupied(int i, int j) {
		return board.occupied(i, j);
	}

	public String winner() {
		return board.winner();
	}
}
