package domain.betting.bettingstate;

import domain.player.Player;
import vo.BettingCase;
import vo.Chips;

public abstract class AbstractBettingState implements BettingState {
    private Chips chips;
    private BettingCase bettingCase;
    private Player player;

    public AbstractBettingState(Chips chips, BettingCase bettingCase, Player player) {
        this.chips = chips;
        this.bettingCase = bettingCase;
        this.player = player;
    }

    protected BettingState createIdiotBettingState() {
        return new IdiotBettingState(new Chips(0), BettingCase.NONE_CASE, player);
    }

    protected BettingState createFirstBettingState(Chips chips, BettingCase bettingCase) {
        return new FirstBettingState(chips, bettingCase, this.player);
    }

    protected BettingState createGeneralBettingState(Chips chips, BettingCase bettingCase) {
        return new GeneralBettingState(chips, bettingCase, this.player);
    }

    protected BettingState createCloseBettingState(Chips chips, BettingCase bettingCase) {
        return new CloseBettingState(chips, bettingCase, this.player);
    }

    protected boolean isIdiot() {
        return player.showChips().isEmpty();
    }

    protected boolean isFirst() {
        return player.isFirst();
    }

    protected boolean isClose() {
        return this.bettingCase.equals(BettingCase.CALL_CASE) || this.bettingCase.equals(BettingCase.DIE_CASE);
    }
}
