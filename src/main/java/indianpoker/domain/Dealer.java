package indianpoker.domain;

import indianpoker.controller.Turn;
import indianpoker.domain.betting.BettingTable;
import indianpoker.domain.player.Loser;
import indianpoker.domain.player.Player;
import indianpoker.domain.player.Winner;
import indianpoker.dto.TurnResultDto;
import indianpoker.vo.Card;

public class Dealer {
    private Card firstPlayerCard;
    private Card lastPlayerCard;
    private BettingTable bettingTable;

    public void initTurn(Card firstPlayerCard, Card lastPlayerCard, BettingTable bettingTable){
        receivePlayerCards(firstPlayerCard, lastPlayerCard);
        this.bettingTable = bettingTable;
    }

    public void receivePlayerCards(Card firstPlayerCard, Card lastPlayerCard) {
        this.firstPlayerCard = firstPlayerCard;
        this.lastPlayerCard = lastPlayerCard;
    }

    public TurnResultDto judgeTurn(Player player1, Player player2) {
        if (firstPlayerCard.compareTo(lastPlayerCard) == 0) {
            return this.draw((Winner) player1, (Winner) player2);
        }

        if (firstPlayerCard.compareTo(lastPlayerCard) == 1) {

            return this.winOrLose((Winner) player1, (Loser) player2);
        }

        return this.winOrLose((Winner) player2, (Loser) player1);
    }

    TurnResultDto draw(Winner winner1, Winner winner2) {
        winner1.gainChips(this.bettingTable.calcWinningChips().halfChips());
        winner2.gainChips(this.bettingTable.calcWinningChips().halfChips());
        return null;
    }

    TurnResultDto winOrLose(Winner winner, Loser loser){
        winner.gainChips(this.bettingTable.calcWinningChips());
        winner.changeFirstBetter();
        loser.changeLastBetter();
        return null;
    }
}
