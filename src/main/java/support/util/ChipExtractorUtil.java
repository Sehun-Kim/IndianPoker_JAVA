package support.util;

import indianpoker.domain.betting.BettingTable;
import indianpoker.domain.betting.bettingstate.BettingState;

public class ChipExtractorUtil {
    public static void addBettingChips(BettingState bettingState, BettingTable bettingTable) {
        if (bettingState.isFirst())
            bettingTable.addFirst(bettingState.getChips());
        if (!bettingState.isFirst())
            bettingTable.addLast(bettingState.getChips());
    }
}
