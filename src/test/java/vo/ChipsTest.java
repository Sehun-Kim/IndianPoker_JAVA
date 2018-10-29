package vo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChipsTest {
    @Test
    public void create() {
        Chips chips = new Chips(10);
    }

    @Test
    public void add() {
        Chips chips = new Chips(10);
        Chips chips2 = new Chips(20);
        Chips chips3 = new Chips(30);
        assertEquals(chips3, chips.add(chips2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void minus() {
        Chips chips = new Chips(10);
        Chips chips2 = new Chips(20);
        System.out.println(chips.minus(chips2).getChips());
    }
}