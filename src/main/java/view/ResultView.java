package view;

import dto.PlayerDto;
import vo.Chips;

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

    public static void showOpositPlayerStatus(PlayerDto playerDto){
        System.out.println(playerDto);
    }

}
