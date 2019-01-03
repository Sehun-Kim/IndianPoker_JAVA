package indianpoker.domain.player;

import indianpoker.domain.betting.bettingstate.BettingState;
import indianpoker.dto.BetterDto;
import indianpoker.vo.BettingCase;
import indianpoker.vo.Card;
import indianpoker.vo.Chips;

public interface Player {
    Chips showChips();
    Chips payChips(Chips minusChips);
    boolean isFirst();
    BettingState initTurn();
    BettingState betting(Chips chips, BettingCase bettingCase);
    Card drawACard();
    BetterDto toDto();
    Winner toWinner();
    Loser toLoser();
}
