package indianpoker.domain.betting;

import indianpoker.domain.betting.bettingstate.BettingState;
import indianpoker.domain.betting.bettingstate.FirstBettingState;
import indianpoker.vo.BettingCase;
import indianpoker.vo.Chips;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import support.Fixture;

public class BettingTableTest extends Fixture {
    BettingTable bettingTable;

    @Before
    public void setUp() throws Exception {
        bettingTable = new BettingTable(player1IntiBettingState, player2IntiBettingState);
    }

    // player 모두 칩하나씩 걸게한다.
    @Test
    public void constructor() {
        new BettingTable(player1IntiBettingState, player2IntiBettingState);
    }

    @Test
    public void addState() {
        BettingState newBettingState = new FirstBettingState(new Chips(3), BettingCase.RAISE_CASE, player1);
        Chips curChips = bettingTable.getFirstPlayerBettingChips();

        bettingTable.addState(newBettingState);
        Assert.assertEquals(curChips.addChips(new Chips(3)), bettingTable.getFirstPlayerBettingChips());

    }
}