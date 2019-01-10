package indianpoker.domain;

import indianpoker.domain.betting.bettingstate.InitBettingState;
import indianpoker.domain.player.HumanPlayer;
import indianpoker.domain.player.Player;
import indianpoker.vo.Card;
import org.junit.Before;
import org.junit.Test;
import indianpoker.vo.Chips;
import support.domain.Deck;

import static org.junit.Assert.*;

public class HumanPlayerTest {
    
    Player player;

    @Before
    public void setUp() throws Exception {
        Deck deck = new Deck();
        player = new HumanPlayer("dom", deck, Chips.ofNumberOfChips(30), true);
    }

    @Test
    public void initTurn() {
        assertTrue(player.initTurn() instanceof InitBettingState);
        assertTrue(player.initTurn().getChips().equals(Chips.ofNumberOfChips(1)));
    }

    @Test
    public void drawACard() {
        Card card = player.drawACard();
        System.out.println(card);
        assertTrue(card instanceof Card);
        System.out.println(player);
    }

    @Test
    public void payAChip() {
        assertTrue(player.payChips(Chips.ofNumberOfChips(3)) instanceof Chips);
    }

    @Test
    public void isIdiot() {

    }
}