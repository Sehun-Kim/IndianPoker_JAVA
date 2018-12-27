package indianpoker.controller;

import indianpoker.domain.Dealer;
import indianpoker.domain.betting.BettingTable;
import indianpoker.domain.player.Player;
import indianpoker.exception.EmptyChipException;

// 너는 게임의 한판이야
// 승패를 판단한 다음에 스테이트도 판단해야할 듯
public class Turn {
    public static void start(Player player1, Player player2, Dealer dealer) {
        dealer.drawPlayerCards(player1, player2); // 뷰에 상대 카드가 뭔지 보여줄 것을 리턴
        BettingTable bettingTable = BettingTable.ofPlayers(player1, player2);
        // 위에꺼 의심하지 맙시다. 익셉션이 안납니다. 저희 다 검증했습니다.
        // 배팅 테이블 만들 때 0개에서 칩빼려고 한다면 익셉션이 나겠지만, 그런 상황이 오지 않게끔 윗단에서 막아야 할 것이야. 정신차리게.
        try {
            run(player1, player2, bettingTable);
        } catch (EmptyChipException e) {
            dealer.judgeTurn(player1, player2, bettingTable.calcWinningChips());
        }
    }

    static void run(Player player1, Player player2, BettingTable bettingTable) {
        if (player1.showChips().isEmpty() || player2.showChips().isEmpty()) {
            throw new EmptyChipException("chip is empty \n player1 :"
                    + player1.showChips() + " player2 : " + player2.showChips());
        }


    }

    // 게임start
    // 지금 문제는 배팅할때 케이스를 먼저 입력하고 그에 따라 칩수를 결정해야하는데 인풋을 어디에서 받아야 할지가 문제다.
}
