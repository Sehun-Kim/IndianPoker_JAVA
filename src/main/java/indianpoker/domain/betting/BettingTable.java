package indianpoker.domain.betting;

import indianpoker.domain.betting.bettingstate.BettingState;

import java.util.ArrayList;
import java.util.List;

// 턴에서 베팅이 쌓이는 곳
public class BettingTable {
    private List<BettingState> firstPlayerBettings;
    private List<BettingState> lastPlayerBettings;

    public BettingTable() {
        this.firstPlayerBettings = new ArrayList<>();
        this.lastPlayerBettings = new ArrayList<>();
    }


}
