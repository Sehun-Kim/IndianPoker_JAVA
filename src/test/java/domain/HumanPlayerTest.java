package domain;

import org.junit.Before;
import org.junit.Test;
import vo.Chips;

import static org.junit.Assert.*;

public class HumanPlayerTest {
    
    Player player;

    @Before
    public void setUp() throws Exception {
        Deck deck = new Deck();
        player = new HumanPlayer("dom", deck, new Chips(30));
    }

    @Test
    public void betting() {
        
    }

    @Test
    public void payAChip() {
        assertTrue(player.payAChip(3) instanceof Chips);
    }

    @Test
    public void isIdiot() {

    }
}