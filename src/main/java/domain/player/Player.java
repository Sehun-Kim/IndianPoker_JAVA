package domain.player;

import domain.betting.bettingstate.BettingState;
import vo.BettingCase;
import vo.Chips;

public interface Player {
    Chips showChips();
    Chips payChips(int i);
    boolean isFirst();
    BettingState betting(Chips chips, BettingCase bettingCase);
}
