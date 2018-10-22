package view;

import vo.Chip;

import java.util.List;

public class ResultView {
    private String winnerName;
    private List<Chip> winningChips;

    public List<Chip> getWinningChips() {
        return winningChips;
    }

    public String getWinnerName() {
        return winnerName;
    }

}
