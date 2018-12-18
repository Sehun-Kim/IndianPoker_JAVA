package indianpoker.domain.betting;

import indianpoker.domain.betting.bettingstate.BettingState;
import indianpoker.domain.betting.bettingstate.CloseBettingState;
import indianpoker.vo.Chips;

// 턴에서 베팅이 쌓이는 곳
public class BettingTable {
    private Chips firstPlayerBettingChips;
    private Chips lastPlayerBettingChips;

    // addState할 때 first last 골라서 알아서 들어가게
    public BettingTable(BettingState firstPlayerInitBettingState, BettingState lastPlayerInitBettingState) {
        this.firstPlayerBettingChips = new Chips(0);
        this.lastPlayerBettingChips = new Chips(0);
//        addFirst(firstPlayerInitBettingState);
//        addLast(lastPlayerInitBettingState);
    }

    public Chips getFirstPlayerBettingChips() {
        return firstPlayerBettingChips;
    }

    public Chips getLastPlayerBettingChips() {
        return lastPlayerBettingChips;
    }

    public void addState(BettingState bettingState) {
//        if (bettingState.isFirst())
    }

    private void addFirst(BettingState bettingState) {
        firstPlayerBettingChips.addChips(check(bettingState).getChips());
    }

    private void addLast(BettingState bettingState) {
        lastPlayerBettingChips.addChips(check(bettingState).getChips());
    }

    private BettingState check(BettingState bettingState) {
        if (bettingState instanceof CloseBettingState)
            throw new RuntimeException();
        return bettingState;
    }


}
