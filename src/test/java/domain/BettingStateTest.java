package domain;

import domain.betting.bettingstate.BettingState;
import domain.betting.bettingstate.GeneralBettingState;
import domain.player.HumanPlayer;
import domain.player.Player;
import org.junit.Before;
import org.junit.Test;
import vo.BettingCase;
import vo.Chips;
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
    public void 라운드가정상종료될수있는상황() {
    }

    @Test
    public void 더이상칩이없어서라운드및게임이종료될수있는상황() {
    }

}