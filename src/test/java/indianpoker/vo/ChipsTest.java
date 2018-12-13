package indianpoker.vo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChipsTest {

    @Test(expected = IllegalArgumentException.class)
    public void giveChips() {
        Chips chips = new Chips(20);
        chips.giveChips(30);
    }
}