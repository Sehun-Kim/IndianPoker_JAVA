package dto;

import domain.Player;
import vo.Chips;

public class TurnOverDto {

    BettingDto player1BettingDto;
    BettingDto player2BettingDto;

    public TurnOverDto(BettingDto player1BettingDto, BettingDto player2BettingDto) {
        this.player1BettingDto = player1BettingDto;
        this.player2BettingDto = player2BettingDto;
    }

    public BettingDto getPlayer1BettingDto() {
        return player1BettingDto;
    }

    public BettingDto getPlayer2BettingDto() {
        return player2BettingDto;
    }

    @Override
    public String toString() {
        return "TurnOverDto{" +
                "player1BettingDto=" + player1BettingDto + System.lineSeparator() +
                ", player2BettingDto=" + player2BettingDto +
                '}';
    }

    public Chips getTotalChips() {
        return player1BettingDto.getChips().add(player2BettingDto.getChips());
    }


    public Chips getHalfChips() {
        return getTotalChips().divide(2);
    }
}
