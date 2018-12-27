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
        bettingTable = BettingTable.ofPlayers(player1, player2);
    }

    // player 모두 칩하나씩 걸게한다.

    @Test
    public void addBettingChips() {
        BettingState newBettingState = new FirstBettingState(new Chips(3), BettingCase.RAISE_CASE, player1);
        Chips curChips = bettingTable.getFirstPlayerBettingChips();

        bettingTable.addBettingChips(newBettingState);
        Assert.assertEquals(curChips.addChips(new Chips(3)), bettingTable.getFirstPlayerBettingChips());
    }

    @Test
    public void calcDiffChips() {
        Assert.assertEquals(bettingTable.calcDiffChips(), new Chips(0));
    }

    @Test
    public void calcWinningChips() {
        bettingTable.addBettingChips(player1.betting(new Chips(3), BettingCase.RAISE_CASE));
        Assert.assertEquals(bettingTable.calcWinningChips(), new Chips(5));
        bettingTable.addBettingChips(player2.betting(bettingTable.calcDiffChips(), BettingCase.RAISE_CASE));
        Assert.assertEquals(bettingTable.calcWinningChips(), new Chips(8));
    }
}