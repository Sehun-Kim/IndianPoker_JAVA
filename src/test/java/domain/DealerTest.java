package domain;

import org.junit.Test;
import vo.Chips;

import java.util.List;
import static org.junit.Assert.*;

public class DealerTest {
    @Test
    public void giveInitChips() {
        int numberOfChips = 30;
        Dealer dealer = new Dealer();
        Chips chips = dealer.giveInitChips(numberOfChips);
        assertEquals(numberOfChips, chips.getChips());
    }


}