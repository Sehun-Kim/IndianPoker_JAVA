package domain.betting.bettingstate;

import domain.player.Player;
import vo.BettingCase;
import vo.Chips;

public class IdiotBettingState extends AbstractBettingState {


    public IdiotBettingState(Chips chips, BettingCase bettingCase, Player player) {
        super(chips, bettingCase, player);
    }

    @Override
    public BettingState betting(Chips chips, BettingCase bettingCase) {
        return null;
    }
}
