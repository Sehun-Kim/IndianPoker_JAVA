package dto;

import domain.Player;

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

}
