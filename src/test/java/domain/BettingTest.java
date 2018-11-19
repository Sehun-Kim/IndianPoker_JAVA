package domain;

import static org.junit.Assert.assertTrue;

import dto.BettingDto;
import org.junit.Test;
import vo.BettingCase;
import vo.Chips;


public class BettingTest {

    @Test
    public void ofZero() {
        assertTrue(Betting.ofZero(new Chips(1), "dom") instanceof Betting);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ofFirstWithException() {
        BettingDto preBettingDto = Betting.ofZero(new Chips(1), "dom").toDto();
        Betting.ofFirst(new Chips(5), BettingCase.CALL_CASE, preBettingDto);
    }

    @Test
    public void ofFirstExpectRaise() {
        BettingDto preBettingDto = Betting.ofZero(new Chips(1), "dom").toDto();
        assertTrue(Betting.ofFirst(new Chips(5), BettingCase.RAISE_CASE, preBettingDto) instanceof Betting);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ofFirstExpectDieWithException() {
        BettingDto preBettingDto = Betting.ofZero(new Chips(1), "dom").toDto();
        Betting.ofFirst(new Chips(5), BettingCase.DIE_CASE, preBettingDto);
    }

    @Test
    public void ofFirstExpectDie() {
        BettingDto preBettingDto = Betting.ofZero(new Chips(1), "dom").toDto();
        assertTrue(Betting.ofFirst(new Chips(0), BettingCase.DIE_CASE, preBettingDto) instanceof Betting);
    }


    @Test
    public void ofGeneral() {
        BettingDto zeroBettingDto = Betting.ofZero(new Chips(1), "dom").toDto();
        BettingDto preBettingDto = Betting.ofFirst(new Chips(5), BettingCase.RAISE_CASE, zeroBettingDto).toDto();

        Betting newBetting = Betting.ofGeneral(new Chips(3), BettingCase.RAISE_CASE, preBettingDto);

        System.out.println(newBetting);

        assertTrue(newBetting instanceof Betting);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ofGeneralDieCase() {
        BettingDto zeroBettingDto = Betting.ofZero(new Chips(1), "dom").toDto();
        BettingDto preBettingDto = Betting.ofFirst(new Chips(5), BettingCase.RAISE_CASE, zeroBettingDto).toDto();

        Betting.ofGeneral(new Chips(3), BettingCase.DIE_CASE, preBettingDto);
    }
}