package indianpoker.domain;

import indianpoker.domain.betting.bettingstate.InitBettingState;
import indianpoker.domain.player.HumanPlayer;
import indianpoker.domain.player.Player;
import org.junit.Before;
import org.junit.Test;
import indianpoker.vo.Chips;

import static org.junit.Assert.*;

public class HumanPlayerTest {
    
    Player player;

    @Before
    public void setUp() throws Exception {
        Deck deck = new Deck();
        player = new HumanPlayer("dom", deck, new Chips(30), true);
    }

    @Test
    public void initTurn() {
        assertTrue(player.initTurn() instanceof InitBettingState);
        assertTrue(player.initTurn().getChips().equals(new Chips(1)));
    }

    @Test
    public void betting() {
        
    }

    @Test
    public void payAChip() {
        assertTrue(player.payChips(3) instanceof Chips);
    }

    @Test
    public void isIdiot() {

    }
}