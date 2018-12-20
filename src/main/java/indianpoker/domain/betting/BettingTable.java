package indianpoker.domain.betting;

import indianpoker.domain.betting.bettingstate.BettingState;
import indianpoker.domain.betting.bettingstate.CloseBettingState;
import indianpoker.vo.Chips;

// 턴에서 칩이 쌓이는 곳
public class BettingTable {
    private Chips firstPlayerBettingChips;
    private Chips lastPlayerBettingChips;

    // addState할 때 first last 골라서 알아서 들어가게
    public BettingTable(BettingState firstPlayerInitBettingState, BettingState lastPlayerInitBettingState) {
        this.firstPlayerBettingChips = firstPlayerInitBettingState.getChips();
        this.lastPlayerBettingChips = lastPlayerInitBettingState.getChips();
    }

    public Chips getFirstPlayerBettingChips() {
        return firstPlayerBettingChips;
    }

    public Chips getLastPlayerBettingChips() {
        return lastPlayerBettingChips;
    }

    public void addBettingChips(BettingState bettingState) {
        if (bettingState.isFirst())
            addFirst(bettingState);
        if (!bettingState.isFirst())
            addLast(bettingState);
    }

    private void addFirst(BettingState bettingState) {
        this.firstPlayerBettingChips = this.firstPlayerBettingChips.addChips(check(bettingState).getChips());
    }

    private void addLast(BettingState bettingState) {
        this.lastPlayerBettingChips = this.lastPlayerBettingChips.addChips(check(bettingState).getChips());
    }

    private BettingState check(BettingState bettingState) {
        if (bettingState instanceof CloseBettingState)
            throw new RuntimeException();
        return bettingState;
    }

    public Chips calcDiffChips() {
        return this.firstPlayerBettingChips.subChips(this.lastPlayerBettingChips);
    }

    public Chips calcWinningChips() {
        return this.firstPlayerBettingChips.addChips(this.lastPlayerBettingChips);
    }
}
