package domain.bettingstate;

import domain.Betting;
import dto.BettingDto;
import vo.BettingCase;
import vo.Chips;

public interface BettingState {
    BettingState changeState(Chips remainChips, BettingDto bettingDto);
    Betting betting(Chips chips, BettingCase bettingCase);
}
