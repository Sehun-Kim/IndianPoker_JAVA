package indianpoker.domain.player;

import indianpoker.domain.betting.bettingstate.BettingState;
import indianpoker.vo.BettingCase;
import indianpoker.vo.Chips;

public interface Player {
    Chips showChips();
    Chips payChips(int i);
    boolean isFirst();
    BettingState initTurn();
    BettingState betting(Chips chips, BettingCase bettingCase);
}
