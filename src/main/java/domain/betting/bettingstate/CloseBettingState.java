package domain.betting.bettingstate;

import domain.player.Player;
import vo.BettingCase;
import vo.Chips;

public class CloseBettingState extends AbstractBettingState {

    public CloseBettingState(Chips chips, BettingCase bettingCase, Player player) {
        super(chips, bettingCase, player);
    }

    @Override
    public BettingState betting(Chips chips, BettingCase bettingCase) {
        return null;
    }
}
