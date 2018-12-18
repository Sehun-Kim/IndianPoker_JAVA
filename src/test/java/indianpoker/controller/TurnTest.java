package indianpoker.controller;

import indianpoker.domain.Deck;
import indianpoker.domain.betting.BettingTable;
import indianpoker.domain.player.HumanPlayer;
import indianpoker.domain.player.Player;
import indianpoker.vo.Chips;
import org.junit.Assert;
import org.junit.Test;

public class TurnTest {
    // 턴테이블에 배팅스테이트를 넘겨줄 때 여기서 검사해서
    // 둘 중의 한명의 플레이어 칩이 더이상 배팅을 할 수 없으면 배팅을 못하게 막는다.
    Player p1 = new HumanPlayer("dom", new Deck(), new Chips(20), true);
    Player p2 = new HumanPlayer("choi", new Deck(), new Chips(20), false);

    @Test
    public void start() {
        // 베팅 테이블 만든다.
        // 플레이어 넘겨받는다.
        Turn.start(p1, p2);
        // 한 판 스타트
        // init()
        // run()
    }

    @Test
    public void init() {
        // init 안에서 Betting table 만들고 p1 p2 에게 init betting 주입
        Assert.assertTrue(Turn.init(p1, p2) instanceof BettingTable);
        // run()
    }

    @Test
    public void run() {
        // 사용자 입력(칩갯수 , 베팅케이스) 유효성 검사.
        //
    }
}