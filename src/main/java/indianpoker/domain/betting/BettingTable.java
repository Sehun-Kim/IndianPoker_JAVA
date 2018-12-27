package indianpoker.domain.betting;

import indianpoker.domain.betting.bettingstate.BettingState;
import indianpoker.domain.betting.bettingstate.CloseBettingState;
import indianpoker.domain.player.Player;
import indianpoker.vo.Chips;

// 턴에서 칩이 쌓이는 곳
public class BettingTable {
    private Chips firstPlayerBettingChips;
    private Chips lastPlayerBettingChips;

    public static BettingTable ofPlayers(Player player1, Player player2) {
        if (player1.isFirst()) {
            return new BettingTable(player1.initTurn(), player2.initTurn());
        }
        return new BettingTable(player2.initTurn(), player1.initTurn());
    }

    private BettingTable(BettingState firstPlayerInitBettingState, BettingState lastPlayerInitBettingState) {
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
