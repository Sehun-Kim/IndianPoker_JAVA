package domain;

import org.junit.Before;
import org.junit.Test;
import vo.BettingCase;
import vo.Chips;

import static org.junit.Assert.*;

public class BettingCheckerTest {
    Betting zeroBetting;
    Betting firstBetting;
    Betting generalBettingRaise;
    Betting generalBettingDie;
    Betting generalBettingCall;

    Betting zeroBetting2;
    Betting firstBetting2;
    Betting generalBettingRaise2;
    Betting generalBettingDie2;
    Betting generalBettingCall2;

    @Before
    public void setUp(){
        zeroBetting = Betting.ofZero(new Chips(1), "choising");
        zeroBetting2 = Betting.ofZero(new Chips(1), "dom");
        firstBetting = Betting.ofFirst(new Chips(3), BettingCase.RAISE_CASE, zeroBetting.toDto());
        firstBetting2 = Betting.ofFirst(new Chips(4), BettingCase.RAISE_CASE, zeroBetting.toDto());
        generalBettingRaise = Betting.ofGeneral(new Chips(5), BettingCase.RAISE_CASE, firstBetting.toDto());
        generalBettingRaise2 = Betting.ofGeneral(new Chips(5), BettingCase.RAISE_CASE, firstBetting.toDto());
        generalBettingDie = Betting.ofGeneral(new Chips(0), BettingCase.DIE_CASE, firstBetting.toDto());
    }

    @Test
    public void 다이일때_턴_종료() {
        assertFalse(BettingChecker.isProgress(generalBettingDie.toDto()));
    }

    @Test
    public void 콜일때_턴_종료() {
        assertFalse(BettingChecker.isProgress(generalBettingCall.toDto()));
    }

    @Test
    public void 레이즈일때_정상_진행() {
        assertTrue(BettingChecker.isProgress(generalBettingRaise.toDto()));
    }

    @Test
    public void numberOfCallChips() {
        assertEquals(3, BettingChecker.numberOfCallChips(zeroBetting2.toDto(), firstBetting.toDto()));
    }

    @Test
    public void name() {
    }
}