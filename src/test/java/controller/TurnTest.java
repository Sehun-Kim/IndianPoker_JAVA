package controller;

import domain.Betting;
import domain.HumanPlayer;
import domain.Player;
import dto.BettingDto;
import dto.TurnOverDto;
import org.junit.Before;
import org.junit.Test;
import vo.Chips;

import static org.junit.Assert.*;

public class TurnTest {
    Player p1;
    Player p2;
    BettingDto p1BettingDto;
    BettingDto p2BettingDto;

    @Before
    public void setUp() throws Exception {
        p1 = new HumanPlayer("dom", new Chips(20));
        p2 = new HumanPlayer("choising", new Chips(20));
        p1BettingDto = p1.zeroBetting().toDto();
        p2BettingDto = p2.zeroBetting().toDto();
    }

    @Test
    public void firstTurn() {
        assertTrue(Turn.firstTurn(p1, p2, p1BettingDto, p2BettingDto) instanceof TurnOverDto);
    }

    @Test
    public void 일반배팅다이때턴종료() {

    }

    @Test
    public void 일반배팅콜일때턴종료() {

    }
}