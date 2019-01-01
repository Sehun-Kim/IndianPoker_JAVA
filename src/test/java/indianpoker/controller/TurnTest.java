package indianpoker.controller;

import indianpoker.domain.Dealer;
import indianpoker.domain.Deck;

import indianpoker.domain.player.HumanPlayer;
import indianpoker.domain.player.Player;
import indianpoker.exception.EmptyChipException;
import indianpoker.vo.Chips;

import org.junit.Test;
import support.Fixture;

public class TurnTest extends Fixture {
    // 턴테이블에 배팅스테이트를 넘겨줄 때 여기서 검사해서
    // 둘 중의 한명의 플레이어 칩이 더이상 배팅을 할 수 없으면 배팅을 못하게 막는다.
    Player p1 = new HumanPlayer("dom", new Deck(), Chips.ofNumberOfChips(20), true);
    Player p2 = new HumanPlayer("choi", new Deck(), Chips.ofNumberOfChips(20), false);
    Dealer dealer = new Dealer(); // dummy data, yet

    @Test
    public void start() {
        // 베팅 테이블 만든다.
        // 플레이어 넘겨받는다.
        Turn.start(p1, p2, dealer);
        // 한 판 스타트
        // init()
        // run()
    }

    @Test(expected = EmptyChipException.class)
    public void run_with_empty_chip() {
        // 사용자 입력(칩갯수 , 베팅케이스) 유효성 검사.
        Player dom = new HumanPlayer("dom", new Deck(), Chips.ofZero(), false);
        Turn.run(dom, p1, bettingTable);
    }
}