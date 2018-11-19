package controller;

import domain.HumanPlayer;
import domain.Player;
import dto.BettingDto;
import dto.TurnOverDto;
import org.junit.Before;
import org.junit.Test;
import vo.BettingCase;
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

    // 수동 테스트 완료
    @Test
    public void startTurn() {

    }

    @Test
    public void firstOrder() {
        assertTrue(Turn.startOrder(p1, p2, p1BettingDto, p2BettingDto) instanceof TurnOverDto);
    }

    @Test
    public void 배팅확인() {
        p1BettingDto = p1.firstBetting(2, BettingCase.RAISE_CASE, p1BettingDto).toDto();
        Turn.run(p1, p2, p1BettingDto, p2BettingDto);
    }

    // 수동 테스트 완료
    @Test
    public void 일반배팅다이때턴종료() {

    }

    // 수동 테스트 완료
    @Test
    public void 일반배팅콜일때턴종료() {

    }
}