package indianpoker.dto;

import indianpoker.vo.Card;

// betting 했을 때 배팅 정보를 뷰단에 뿌려줌
public class BettingInfoDto {
    private BettingTableDto currentTableDto;
    private Card otherPlayerCard;
    private BetterDto ownBetterDto;

    public BettingInfoDto(BettingTableDto currentTableDto, Card otherPlayerCard, BetterDto ownBetterDto) {
        this.currentTableDto = currentTableDto;
        this.otherPlayerCard = otherPlayerCard;
        this.ownBetterDto = ownBetterDto;
    }

    public BettingTableDto getCurrentTableDto() {
        return currentTableDto;
    }

    public Card getOtherPlayerCard() {
        return otherPlayerCard;
    }

    public BetterDto getOwnBetterDto() {
        return ownBetterDto;
    }

    @Override
    public String toString() {
        return "BettingInfoDto{" +
                "currentTableDto=" + currentTableDto +
                ", otherPlayerCard=" + otherPlayerCard +
                ", ownBetterDto=" + ownBetterDto +
                '}';
    }
}
