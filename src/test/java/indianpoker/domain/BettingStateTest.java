package indianpoker.domain;

import indianpoker.domain.betting.bettingstate.CloseBettingState;
import indianpoker.domain.betting.bettingstate.GeneralBettingState;
import indianpoker.domain.player.HumanPlayer;
import indianpoker.domain.player.Player;
import org.junit.Before;
import org.junit.Test;
import indianpoker.vo.BettingCase;
import indianpoker.vo.Chips;
import static org.junit.Assert.*;

public class BettingStateTest {
    Player player1;
    Player player2;


    @Before
    public void setUp() throws Exception {
        player1 = new HumanPlayer("dom", new Deck(), new Chips(30), true);
        player2 = new HumanPlayer("dom", new Deck(), new Chips(30), false);
    }

    @Test
    public void generalBetting() {
        assertTrue(player2.betting(new Chips(5), BettingCase.RAISE_CASE) instanceof GeneralBettingState);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 첫번째라서콜을못하는상황() {
        player1.betting(new Chips(3), BettingCase.CALL_CASE);
    }

    @Test
    public void init배팅에서general로가는지() {
        assertTrue(player2.betting(new Chips(3), BettingCase.RAISE_CASE) instanceof GeneralBettingState);
    }

    @Test
    public void callcase때close로갈수있는지() {
        assertTrue(player2.betting(new Chips(3), BettingCase.CALL_CASE) instanceof CloseBettingState);
    }

    @Test
    public void die할때close로가는지() {
        assertTrue(player1.betting(new Chips(3), BettingCase.DIE_CASE) instanceof CloseBettingState);
        assertTrue(player2.betting(new Chips(3), BettingCase.DIE_CASE) instanceof CloseBettingState);
    }

}