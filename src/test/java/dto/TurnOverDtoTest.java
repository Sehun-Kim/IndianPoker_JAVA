package dto;

import domain.HumanPlayer;
import domain.Player;
import org.junit.Before;
import org.junit.Test;
import vo.Chips;

import static org.junit.Assert.*;

public class TurnOverDtoTest {
    Player p1;
    Player p2;
    BettingDto p1BettingDto;
    BettingDto p2BettingDto;
    TurnOverDto turnOverDto;

    @Before
    public void setUp() throws Exception {
        p1 = new HumanPlayer("dom", new Chips(20));
        p2 = new HumanPlayer("choising", new Chips(20));
        p1BettingDto = p1.zeroBetting().toDto();
        p2BettingDto = p2.zeroBetting().toDto();
        turnOverDto = new TurnOverDto(p1BettingDto, p2BettingDto);
    }

    @Test
    public void getTotalChips() {
        assertEquals(turnOverDto.getTotalChips(), new Chips(2));
    }

    @Test
    public void getHalfChips() {
        assertEquals(turnOverDto.getHalfChips(), new Chips(1));
    }


}