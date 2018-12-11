package domain.betting.bettingstate;

import domain.player.Player;
import vo.BettingCase;
import vo.Chips;

public class InitBettingState extends AbstractBettingState {

    public InitBettingState(Chips chips, BettingCase bettingCase, Player player) {
        super(chips, bettingCase, player);
    }

    @Override
    public BettingState betting(Chips chips, BettingCase bettingCase) {
        if (isIdiot()) return createIdiotBettingState();
        return createGeneralBettingState(chips, bettingCase);
    }
}
