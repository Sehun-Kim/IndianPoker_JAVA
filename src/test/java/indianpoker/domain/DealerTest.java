package indianpoker.domain;

import indianpoker.domain.player.Loser;
import indianpoker.domain.player.Winner;
import org.junit.Before;
import org.junit.Test;
import support.Fixture;

import static org.junit.Assert.*;

// 1224에는 여기를 해야해
public class DealerTest extends Fixture {

    @Before
    public void setUp() throws Exception {
        dealer.receivePlayerCards(player1.drawACard(), player2.drawACard());
    }

    @Test
    public void name() {
    }

    @Test
    public void draw() {
        dealer.draw((Winner) player1, (Winner)player2);
    }

    @Test
    public void winOrLose() {
        dealer.winOrLose((Winner) player1, (Loser) player2);
    }
}