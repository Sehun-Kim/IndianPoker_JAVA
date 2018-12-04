package domain.betting.bettingstate;

import domain.player.Player;
import vo.BettingCase;
import vo.Chips;

public class CloseBettingState implements BettingState {

    private Chips chips;
    private BettingCase bettingCase;

    public CloseBettingState(Chips chips, BettingCase bettingCase) {
        this.chips = chips;
        this.bettingCase = bettingCase;
    }

    @Override
    public BettingState betting(Chips chips, Chips remainChips, BettingCase bettingCase) {
        if(player) return new FirstBettingState(chips, bettingCase);
        return new GeneralBettingState(chips, bettingCase);
    }
}
