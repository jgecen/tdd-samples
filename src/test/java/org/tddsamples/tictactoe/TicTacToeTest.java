package org.tddsamples.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest {

	@Test
	public void testPlayOnlyOnFreeSpots() {
		TicTacToe game = new TicTacToe();
		game.setPlayers("A", "B");
		Assert.assertTrue(game.player("A").play(0, 0));
		Assert.assertNull(game.winner());
		Assert.assertTrue(game.occupied(0, 0));
		Assert.assertFalse(game.player("B").play(0, 0));
	}

	@Test
	public void testInvalidPlayersCantPlay() {
		TicTacToe game = new TicTacToe();
		game.setPlayers("A", "B");
		Assert.assertFalse(game.player("C").play(0, 0));
		Assert.assertNull(game.winner());
	}

	@Test
	public void testPlayerAFullLineWins() {
		TicTacToe game = new TicTacToe();
		game.setPlayers("A", "B");
		game.player("A").play(0, 0);
		game.player("A").play(0, 1);
		game.player("A").play(0, 2);
		Assert.assertEquals("A", game.winner());

		game = new TicTacToe();
		game.setPlayers("A", "B");
		game.player("A").play(1, 0);
		game.player("A").play(1, 1);
		game.player("A").play(1, 2);
		Assert.assertEquals("A", game.winner());
		
		game = new TicTacToe();
		game.setPlayers("A", "B");
		game.player("A").play(2, 0);
		game.player("A").play(2, 1);
		game.player("A").play(2, 2);
		Assert.assertEquals("A", game.winner());		
	}

	@Test
	public void testPlayerAFullColumnWins() {
		TicTacToe game = new TicTacToe();
		game.setPlayers("A", "B");
		game.player("A").play(0, 0);
		game.player("A").play(1, 0);
		game.player("A").play(2, 0);
		Assert.assertEquals("A", game.winner());

		game = new TicTacToe();
		game.setPlayers("A", "B");
		game.player("A").play(0, 1);
		game.player("A").play(1, 1);
		game.player("A").play(2, 1);
		Assert.assertEquals("A", game.winner());

		game = new TicTacToe();
		game.setPlayers("A", "B");
		game.player("A").play(0, 2);
		game.player("A").play(1, 2);
		game.player("A").play(2, 2);
		Assert.assertEquals("A", game.winner());
	}


	@Test
	public void testPlayerBFullColumnWins() {
		TicTacToe game = new TicTacToe();
		game.setPlayers("A", "B");
		game.player("B").play(0, 0);
		game.player("B").play(1, 0);
		game.player("B").play(2, 0);
		Assert.assertEquals("B", game.winner());
	}

	@Test
	public void testPlayerBFullDiagonalWins() {
		TicTacToe game = new TicTacToe();
		game.setPlayers("A", "B");
		game.player("B").play(0, 0);
		game.player("B").play(1, 1);
		game.player("B").play(2, 2);
		Assert.assertEquals("B", game.winner());

		game = new TicTacToe();
		game.setPlayers("A", "B");
		game.player("B").play(0, 2);
		game.player("B").play(1, 1);
		game.player("B").play(2, 0);
		Assert.assertEquals("B", game.winner());
	}
}
