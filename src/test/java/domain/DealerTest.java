package domain;

import dto.BettingDto;
import dto.TurnOverDto;
import org.junit.Before;
import org.junit.Test;
import vo.Chips;

import java.util.List;
import static org.junit.Assert.*;

public class DealerTest {
    Dealer dealer;
    Player p1;
    Player p2;
    BettingDto p1BettingDto;
    BettingDto p2BettingDto;
    TurnOverDto turnOverDto;

    @Before
    public void setUp() throws Exception {
        dealer = new Dealer();
        p1 = new HumanPlayer("dom", new Chips(20));
        p2 = new HumanPlayer("choising", new Chips(20));
        p1BettingDto = p1.zeroBetting().toDto();
        p2BettingDto = p2.zeroBetting().toDto();
        turnOverDto = new TurnOverDto(p1BettingDto, p2BettingDto);
    }

    @Test
    public void judgeTurn() {
        dealer.judgeTurn(p1, p2, turnOverDto);
        System.out.println(p1.toDto());
        System.out.println(p2.toDto());

    }
}