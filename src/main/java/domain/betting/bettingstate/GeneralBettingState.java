package domain.betting.bettingstate;

import domain.player.Player;
import vo.BettingCase;
import vo.Chips;

public class GeneralBettingState extends AbstractBettingState {


    public GeneralBettingState(Chips chips, BettingCase bettingCase, Player player) {
        super(chips, bettingCase, player);
    }

    @Override
    public BettingState betting(Chips chips, BettingCase bettingCase) {
        if(isIdiot()) return createIdiotBettingState();
        if(isClose()) return createCloseBettingState(chips, bettingCase);
        return createGeneralBettingState(chips, bettingCase);
    }
}
