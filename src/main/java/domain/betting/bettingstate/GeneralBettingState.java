package domain.betting.bettingstate;

import domain.player.Player;
import vo.BettingCase;
import vo.Chips;

public class GeneralBettingState implements BettingState {

    private Chips chips;
    private BettingCase bettingCase;

    public GeneralBettingState(Chips chips, BettingCase bettingCase) {
        this.chips = chips;
        this.bettingCase = bettingCase;
    }

    @Override
    public BettingState betting(Chips chips, BettingCase bettingCase, Player player) {
        return null;
    }
}
