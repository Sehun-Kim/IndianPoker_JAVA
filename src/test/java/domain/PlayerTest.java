package domain;

import dto.BettingDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vo.BettingCase;
import vo.Card;
import vo.Chips;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

    Chips chips;

    @Before
    public void setUp() {
        chips = new Chips(20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithException() {
        String name = "player223332";
        Player p1 = new HumanPlayer(name, chips);
    }

    @Test
    public void create() {
        String name = "dom";
        Player p1 = new HumanPlayer(name, chips);
    }

    @Test
    public void sameName() {
        String name = "choising";
        Player p1 = new HumanPlayer(name, chips);
        Assert.assertEquals(name, p1.getName());
    }

    @Test
    public void zeroBetting() {
        Player p1 = new HumanPlayer("dom", chips);
        assertTrue(p1.zeroBetting() instanceof Betting);
        System.out.println(p1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void firstBettingWitheException() {
        Player p1 = new HumanPlayer("dom", chips);
        BettingDto zeroBettingDto = p1.zeroBetting().toDto();

        p1.firstBetting(2, BettingCase.CALL_CASE, zeroBettingDto);
        System.out.println(p1);
    }

    @Test
    public void firstBetting() {
        Player p1 = new HumanPlayer("dom", chips);
        BettingDto zeroBettingDto = p1.zeroBetting().toDto();

        Betting betting = p1.firstBetting(2, BettingCase.RAISE_CASE, zeroBettingDto);
        assertTrue(betting instanceof Betting);
        System.out.println(betting);
    }

    @Test
    public void generalBetting() {
        Player p1 = new HumanPlayer("dom", chips);
        BettingDto zeroBettingDto = p1.zeroBetting().toDto();

        BettingDto bettingDto = p1.firstBetting(2, BettingCase.RAISE_CASE, zeroBettingDto).toDto();

        Betting betting = p1.generalBetting(3, BettingCase.RAISE_CASE, bettingDto);
        assertTrue(betting instanceof Betting);
        System.out.println(betting);
    }

    @Test
    public void generalBettingWithException() {
        Player p1 = new HumanPlayer("dom", chips);
        BettingDto zeroBettingDto = p1.zeroBetting().toDto();

        BettingDto bettingDto = p1.firstBetting(2, BettingCase.RAISE_CASE, zeroBettingDto).toDto();

        try {
            p1.generalBetting(20, BettingCase.RAISE_CASE, bettingDto);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


}
