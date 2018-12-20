package indianpoker.controller;

import indianpoker.domain.Dealer;
import indianpoker.domain.betting.BettingTable;
import indianpoker.domain.player.Player;

// 너는 게임의 한판이야
// 승패를 판단한 다음에 스테이트도 판단해야할 듯
public class Turn {
    public static void start(Player player1, Player player2, Dealer dealer) {
        BettingTable bettingTable;
        try {
            bettingTable = init(player1, player2, dealer);
            run(player1, player2, bettingTable);
        } catch (Exception e) {
            // Exception 정의 필요.

        }
    }

    static void run(Player player1, Player player2, BettingTable bettingTable) {
        if (player1.showChips().isEmpty() || player2.showChips().isEmpty()) {
            // 뭔가 조치를 해야됨. 게임종료쪽이긴한데,
        }
    }

    static BettingTable init(Player player1, Player player2, Dealer dealer) {
        if (player1.isFirst()) {
            dealer.receivePlayerCards(player1.drawACard(), player2.drawACard());
            return new BettingTable(player1.initTurn(), player2.initTurn());
        }
        dealer.receivePlayerCards(player2.drawACard(), player1.drawACard());
        return new BettingTable(player2.initTurn(), player1.initTurn());
    }
    // 게임start
    // 지금 문제는 배팅할때 케이스를 먼저 입력하고 그에 따라 칩수를 결정해야하는데 인풋을 어디에서 받아야 할지가 문제다.
}
