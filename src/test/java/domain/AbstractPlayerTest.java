package domain;

import org.junit.Test;
import vo.Chips;

import static org.junit.Assert.*;

public class AbstractPlayerTest {

    @Test
    public void referTest() {
        Player player = new HumanPlayer("choising", new Deck(), new Chips(10));
        player.payAChip(3);
    }
}