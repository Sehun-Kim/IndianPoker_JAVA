package domain;

import domain.bettingstate.BettingState;
import dto.BettingDto;
import dto.PlayerDto;
import vo.BettingCase;
import vo.Chips;

public interface Player {

    int NAME_LENGTH = 8;

    Chips getChips(int numberOfChips);

    PlayerDto toDto();

    void prepareTurn();

    Betting betting(int numberOfChips, BettingCase bettingCase, BettingDto preBettingDto);

    void addChips(Chips totalChips);

}
