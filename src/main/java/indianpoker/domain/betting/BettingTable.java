package indianpoker.domain.betting;

import indianpoker.vo.Chips;

// 턴에서 칩이 쌓이는 곳
public class BettingTable {
    private Chips firstPlayerBettingChips;
    private Chips lastPlayerBettingChips;

    public BettingTable() {
        this.firstPlayerBettingChips = Chips.ofZero();
        this.lastPlayerBettingChips = Chips.ofZero();
    }

    public void addFirst(Chips chips) {
        this.firstPlayerBettingChips = this.firstPlayerBettingChips.addChips(chips);
    }

    public void addLast(Chips chips) {
        this.lastPlayerBettingChips = this.lastPlayerBettingChips.addChips(chips);
    }

    public Chips calcDiffChips() {
        return this.firstPlayerBettingChips.subChips(this.lastPlayerBettingChips);
    }

    public Chips calcWinningChips() {
        return this.firstPlayerBettingChips.addChips(this.lastPlayerBettingChips);
    }

    public Chips getFirstPlayerBettingChips() {
        return firstPlayerBettingChips;
    }

    public Chips getLastPlayerBettingChips() {
        return lastPlayerBettingChips;
    }
}
