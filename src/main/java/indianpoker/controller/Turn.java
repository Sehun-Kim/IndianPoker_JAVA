package indianpoker.controller;

import indianpoker.domain.betting.BettingTable;
import indianpoker.domain.player.Player;

// 너는 게임의 한판이야
// 승패를 판단한 다음에 스테이트도 판단해야할 듯
// 왜냐면 idiot이면 게임을 종료해야하니깐
public class Turn {
    public static void start(Player p1, Player p2) {
        BettingTable bettingTable;
        try {
            bettingTable = init(p1, p2);
            run(p1, p2, bettingTable);
        } catch (Exception e) {
            // Exception 정의 필요.

        }
    }

    static void run(Player p1, Player p2, BettingTable bettingTable) {
        if(p1.showChips().isEmpty() || p2.showChips().isEmpty()){
            // 뭔가 조치를 해야됨. 게임종료쪽이긴한데,
        }
    }

    static BettingTable init(Player p1, Player p2) {
        if(p1.isFirst())
            return new BettingTable(p1.initTurn(), p2.initTurn());
        return new BettingTable(p2.initTurn(), p1.initTurn());
    }
    // 게임start
    // 지금 문제는 배팅할때 케이스를 먼저 입력하고 그에 따라 칩수를 결정해야하는데 인풋을 어디에서 받아야 할지가 문제다.
}
