package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vo.BettingCase;
import vo.Card;
import vo.Chip;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

    List<Chip> chips;

    @Before
    public void setUp() {
        chips = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            chips.add(new Chip());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithException() {
        String name = "player223332";
        Player p1 = new HumanPlayer(name, chips);
    }

    @Test
    public void create() {
        String name = "dom";
        Player p1 = new HumanPlayer(name, chips);
    }

    @Test
    public void sameName() {
        String name = "choising";
        Player p1 = new HumanPlayer(name, chips);
        Assert.assertEquals(name, p1.getName());
    }

    @Test
    public void giveACard() {
        Player p1 = new HumanPlayer("dom", chips);
        assertTrue(p1.giveACard() instanceof Card);

    }

    @Test
    public void firstBetting() {
        Player p1 = new HumanPlayer("dom", chips);
        assertTrue(p1.firstBetting(3, BettingCase.RAISE_CASE) instanceof Betting);
    }
}
