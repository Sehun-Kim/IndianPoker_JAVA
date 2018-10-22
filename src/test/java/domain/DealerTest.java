package domain;

import org.junit.Test;
import vo.Chip;

import java.util.List;

import static org.junit.Assert.*;

public class DealerTest {
    @Test
    public void giveInitChips() {
        int numberOfChips = 30;
        Dealer dealer = new Dealer();
        List<Chip> chips = dealer.giveInitChips(numberOfChips);
        assertEquals(numberOfChips, chips.size());
    }
}