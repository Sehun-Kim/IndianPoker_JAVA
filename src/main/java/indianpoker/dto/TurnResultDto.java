package indianpoker.dto;

import indianpoker.vo.Chips;

import java.util.ArrayList;
import java.util.List;

public class TurnResultDto {
    private List<PlayerDto> winners;
    private Chips winningChips;

    public static TurnResultDto of() {
        return new TurnResultDto();
    }

    private TurnResultDto() {
        this.winners = new ArrayList<>();
    }

    public TurnResultDto addWinner(PlayerDto playerDto) {
        this.winners.add(playerDto);
        return this;
    }

    public TurnResultDto addWinningChips(Chips winningChips) {
        this.winningChips = winningChips;
        return this;
    }

    public List<PlayerDto> getWinners() {
        return winners;
    }

    public boolean isDraw() {
        return this.winners.size() == 2;
    }

    public Chips getWinningChips() {
        return winningChips;
    }

    @Override
    public String toString() {
        return "TurnResultDto{" +
                "winners=" + winners + "\n" +
                ", winningChips=" + winningChips +
                '}';
    }
}
