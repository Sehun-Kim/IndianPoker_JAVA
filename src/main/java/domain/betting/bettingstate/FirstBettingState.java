package domain.betting.bettingstate;

import domain.player.Player;
import vo.BettingCase;
import vo.Chips;

public class FirstBettingState implements BettingState {

    private Chips chips;
    private BettingCase bettingCase;

    public FirstBettingState(Chips chips, BettingCase bettingCase) {
        this.chips = chips;
        this.bettingCase = bettingCase;
    }

    @Override
    public BettingState betting(Chips chips, BettingCase bettingCase, Player player) {
        if(bettingCase.equals(BettingCase.CALL_CASE)) throw new IllegalArgumentException("첫 베팅은 콜할 수 없습니다.");
        return new GeneralBettingState(chips, bettingCase);
    }
}
