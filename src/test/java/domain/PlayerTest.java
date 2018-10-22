package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
}
