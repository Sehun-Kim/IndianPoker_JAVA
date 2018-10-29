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



    @Before
    public void setUp(){
        zeroBetting = Betting.ofZero(new Chips(1), "choising");
        firstBetting = Betting.ofFirst(new Chips(3), BettingCase.RAISE_CASE, zeroBetting.toDto());
        generalBettingRaise = Betting.ofGeneral(new Chips(5), BettingCase.RAISE_CASE, firstBetting.toDto());
        generalBettingDie = Betting.ofGeneral(new Chips(0), BettingCase.DIE_CASE, firstBetting.toDto());
        generalBettingCall = Betting.ofGeneral(new Chips(3), BettingCase.CALL_CASE, firstBetting.toDto());

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
}