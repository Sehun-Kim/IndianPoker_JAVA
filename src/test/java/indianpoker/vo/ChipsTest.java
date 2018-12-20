package indianpoker.vo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChipsTest {

    @Test(expected = IllegalArgumentException.class)
    public void giveChips() {
        Chips chips = new Chips(20);
        chips.giveChips(30);
    }

    @Test
    public void subChips() {
        Chips chips1 = new Chips(3);
        Chips chips2 = new Chips(20);
        assertEquals(new Chips(17), chips1.subChips(chips2));
        assertEquals(new Chips(17), chips2.subChips(chips1));
    }
}