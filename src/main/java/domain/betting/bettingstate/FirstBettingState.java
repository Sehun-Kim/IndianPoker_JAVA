package domain.betting.bettingstate;

import domain.player.Player;
import vo.BettingCase;
import vo.Chips;

public class FirstBettingState extends AbstractBettingState {

    public FirstBettingState(Chips chips, BettingCase bettingCase, Player player) {
        super(chips, bettingCase, player);
        if (bettingCase.equals(BettingCase.CALL_CASE))
            throw new IllegalArgumentException("첫 베팅은 콜할 수 없습니다.");
    }

    @Override
    public BettingState betting(Chips chips, BettingCase bettingCase) {
        if (isIdiot()) return createIdiotBettingState();
        if (isClose()) return createCloseBettingState(chips, bettingCase);
        return createGeneralBettingState(chips, bettingCase);
    }


}
