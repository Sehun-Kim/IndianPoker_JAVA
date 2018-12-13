package indianpoker.view;

import indianpoker.vo.Chips;

import java.util.List;

public class ResultView {
    private String winnerName;
    private List<Chips> winningChips;

    public List<Chips> getWinningChips() {
        return winningChips;
    }

    public String getWinnerName() {
        return winnerName;
    }

}
