package domain;

import dto.BettingDto;
import dto.PlayerDto;
import vo.BettingCase;
import vo.Card;
import vo.Chips;

import java.util.List;

public interface Player {

    int NAME_LENGTH = 8;

    Betting zeroBetting();

    Betting firstBetting(int numberOfChips, BettingCase bettingCase, BettingDto preBettingDto);

    Betting generalBetting(int numberOfChips, BettingCase bettingCase, BettingDto preBettingDto);

    String getName();

    Chips getChips(int numberOfChips);

    PlayerDto toDto();

    void addChips(Chips totalChips);
}
