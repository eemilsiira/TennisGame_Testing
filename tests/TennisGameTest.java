import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}

	 @Test
	    public void testTennisGame_Player1Wins() throws TennisGameException {
	        // Arrange
	        TennisGame game = new TennisGame();
	        game.player1Scored();
	        game.player1Scored();
	        game.player1Scored();
	        game.player1Scored(); // Player 1 voittaa.
	        // Act
	        String score = game.getScore();
	        // Assert
	        assertEquals("Player 1 winning scenario failed", "player1 wins", score);
	    }

	    // Testataan tilanne, jossa Player 2 voittaa pelin.
	    @Test
	    public void testTennisGame_Player2Wins() throws TennisGameException {
	        // Arrange
	        TennisGame game = new TennisGame();
	        game.player2Scored();
	        game.player2Scored();
	        game.player2Scored();
	        game.player2Scored(); // Player 2 voittaa.
	        // Act
	        String score = game.getScore();
	        // Assert
	        assertEquals("Player 2 winning scenario failed", "player2 wins", score);
	    }

	    // Testataan tilanne, jossa Player 1:llä on etu.
	    @Test
	    public void testTennisGame_Player1Advantage() throws TennisGameException {
	        // Arrange
	        TennisGame game = new TennisGame();
	        game.player1Scored();
	        game.player1Scored();
	        game.player1Scored();
	        game.player2Scored();
	        game.player2Scored();
	        game.player2Scored(); // Molemmat saavuttavat deucen.
	        game.player1Scored(); // Player 1 saa edun.
	        // Act
	        String score = game.getScore();
	        // Assert
	        assertEquals("Player 1 advantage scenario failed", "player1 has advantage", score);
	    }

	    // Testataan tilanne, jossa Player 2:lla on etu.
	    @Test
	    public void testTennisGame_Player2Advantage() throws TennisGameException {
	        // Arrange
	        TennisGame game = new TennisGame();
	        game.player1Scored();
	        game.player1Scored();
	        game.player1Scored();
	        game.player2Scored();
	        game.player2Scored();
	        game.player2Scored(); // Molemmat saavuttavat deucen.
	        game.player2Scored(); // Player 2 saa edun.
	        // Act
	        String score = game.getScore();
	        // Assert
	        assertEquals("Player 2 advantage scenario failed", "player2 has advantage", score);
	    }
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}		
}
