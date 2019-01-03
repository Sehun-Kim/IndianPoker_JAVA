package indianpoker.domain;

import indianpoker.domain.betting.BettingTable;
import indianpoker.domain.player.Loser;
import indianpoker.domain.player.Player;
import indianpoker.domain.player.Winner;
import indianpoker.dto.*;
import indianpoker.exception.GameOverException;
import indianpoker.vo.Card;
import indianpoker.vo.Chips;

import java.util.HashMap;
import java.util.Map;

public class Dealer {
    private Map<Player, Card> playerCards;

    public BettingInfoDto generateBettingInfo(Player better, BettingTable bettingTable) {
        return new BettingInfoDto(bettingTable.toDto(better),
                getOtherPlayerCard(better),
                better.toDto());
    }

    private Card getOtherPlayerCard(Player better) {
        for (Player player : playerCards.keySet()){
            if(!player.equals(better)) return playerCards.get(player);
        }
        return null;
    }

    public void drawPlayerCards(Player firstPlayer, Player lastPlayer) {
        this.playerCards = receivePlayerCards(firstPlayer, lastPlayer);
    }

    // for TEST
    public void drawPlayerCards(Map<Player, Card> playerCards) {
        this.playerCards = playerCards;
    }

    Map<Player, Card> receivePlayerCards(Player firstPlayer, Player lastPlayer) {
        Map<Player, Card> playerCards = new HashMap<>();
        playerCards.put(firstPlayer, firstPlayer.drawACard());
        playerCards.put(lastPlayer, lastPlayer.drawACard());

        return playerCards;
    }

    public TurnResultDto judgeDieCase(Player loser, Player winner, Chips winningChips) {
        return this.winOrLose(winner.toWinner(), loser.toLoser(), winningChips);
    }

    public TurnResultDto judgeCallCase(Player player1, Player player2, Chips winningChips) {
        System.out.println(player1.toDto().getName() + " : " + getPlayerCard(player1));
        System.out.println(player2.toDto().getName() + " : " + getPlayerCard(player2));

        if (getPlayerCard(player1).compareTo(getPlayerCard(player2)) == 0) {
            return this.draw(player1.toWinner(), player2.toWinner(), winningChips);
        }

        if (getPlayerCard(player1).compareTo(getPlayerCard(player2)) == 1) {
            return this.winOrLose(player1.toWinner(), player2.toLoser(), winningChips);
        }

        return this.winOrLose(player2.toWinner(), player1.toLoser(), winningChips);
    }

    public Card getPlayerCard(Player player) {
        return this.playerCards.get(player);
    }
    TurnResultDto draw(Winner winner1, Winner winner2, Chips winningChips) {
        winner1.gainChips(winningChips.halfChips());
        winner2.gainChips(winningChips.halfChips());

        return TurnResultDto.of()
                .addWinner(winner1.toPlayer().toDto())
                .addWinner(winner2.toPlayer().toDto())
                .addWinningChips(winningChips.halfChips());
    }

    TurnResultDto winOrLose(Winner winner, Loser loser, Chips winningChips) {
        winner.gainChips(winningChips);
        winner.changeFirstBetter();
        loser.changeLastBetter();
        return TurnResultDto.of()
                .addWinner(winner.toPlayer().toDto())
                .addWinningChips(winningChips);
    }

    public void checkGameOver(Player player1, Player player2) {
        if(player1.showChips().isEmpty() || player2.showChips().isEmpty())
            throw new GameOverException("GAME OVER");
    }

    public WinnerDto judgeGameWinner(Player player1, Player player2) {
        WinnerDto winnerDto = new WinnerDto();
        if(player1.showChips().compareTo(player2.showChips()) > 0) {
            winnerDto.addWinnerName(player1.toWinner().getName());
        }
        if(player1.showChips().compareTo(player2.showChips()) < 0) {
            winnerDto.addWinnerName(player2.toWinner().getName());
        }
        if(player1.showChips().compareTo(player2.showChips()) == 0) {
            winnerDto.addWinnerName(player1.toWinner().getName());
            winnerDto.addWinnerName(player2.toWinner().getName());
        }
        return winnerDto;
    }
}
