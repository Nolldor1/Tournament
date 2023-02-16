package GameTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import player.Game;
import player.NotRegistredException;
import player.Player;

public class GameTest {
    @Test
    public void testWhenPlayer1IsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Петя", 10);
        Player player2 = new Player(2, "Вася", 5);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Петя", "Вася");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayer2IsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Петя", 5);
        Player player2 = new Player(2, "Вася", 10);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Петя", "Вася");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenBothPlayersAreEqual() {
        Game game = new Game();
        Player player1 = new Player(1, "Петя", 5);
        Player player2 = new Player(2, "Вася", 5);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Петя", "Вася");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayer1HasNoName() {
        Game game = new Game();
        Player player1 = new Player(1, "", 5);
        Player player2 = new Player(1, "Вася", 5);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegistredException.class,
                () -> game.round("Петя", "Вася")
        );
    }

    @Test
    public void testPlayer2HasNoName() {
        Game game = new Game();
        Player player1 = new Player(1, "Петя", 5);
        Player player2 = new Player(1, "", 5);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegistredException.class,
                () -> game.round("Петя", "Вася")
        );
    }

    @Test
    public void testBothPlayersHaveNoNames() {
        Game game = new Game();
        Player player1 = new Player(1, "", 5);
        Player player2 = new Player(1, "", 5);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegistredException.class,
                () -> game.round("Петя", "Вася")
        );
    }

}
