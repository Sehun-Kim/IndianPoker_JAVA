package domain;

import domain.player.HumanPlayer;
import domain.player.Player;
import org.junit.Test;
import vo.Chips;

public class AbstractPlayerTest {

    @Test
    public void referTest() {
        Player player = new HumanPlayer("choising", new Deck(), new Chips(10));
        player.payChips(3);
    }
}