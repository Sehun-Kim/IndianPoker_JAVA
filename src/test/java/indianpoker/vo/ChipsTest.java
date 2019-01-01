package indianpoker.vo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChipsTest {

    @Test(expected = IllegalArgumentException.class)
    public void giveChips() {
        Chips chips = Chips.ofNumberOfChips(20);
        chips.giveChips(30);
    }

    @Test
    public void subChips() {
        Chips chips1 = Chips.ofNumberOfChips(3);
        Chips chips2 = Chips.ofNumberOfChips(20);
        assertEquals(Chips.ofNumberOfChips(17), chips1.subChips(chips2));
        assertEquals(Chips.ofNumberOfChips(17), chips2.subChips(chips1));
    }
}