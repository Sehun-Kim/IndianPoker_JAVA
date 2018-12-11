package domain;

import domain.player.AbstractPlayer;
import domain.player.HumanPlayer;
import domain.player.Player;
import domain.player.Winner;
import org.junit.Before;
import org.junit.Test;
import vo.Chips;

import static org.junit.Assert.*;

public class WinnerTest {
    Winner winner;

    @Before
    public void setUp() throws Exception {
        winner = new HumanPlayer("dom", new Deck(), new Chips(30), true);
    }

    @Test
    public void gainChips() {
        winner.gainChips(new Chips(5));
        Player player = (AbstractPlayer)winner;
        assertEquals(player.showChips(), new Chips(35));
    }
}