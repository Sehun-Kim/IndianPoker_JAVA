package domain;

import dto.BettingDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vo.BettingCase;
import vo.Card;
import vo.Chips;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

    Chips chips;
    Player player;

    @Before
    public void setUp() {
        chips = new Chips(20);
        player = new HumanPlayer("dom", chips);

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

//    @Test
//    public void sameName() {
//        String name = "choising";
//        Player p1 = new HumanPlayer(name, chips);
//        Assert.assertEquals(name, p1.getName());
//    }

    @Test
    public void zeroBetting() {
        Assert.assertTrue(player.betting(0, ) instanceof Betting);
    }
}
