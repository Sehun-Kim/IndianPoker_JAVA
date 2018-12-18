package support;

import indianpoker.domain.Deck;
import indianpoker.domain.betting.bettingstate.BettingState;
import indianpoker.domain.betting.bettingstate.InitBettingState;
import indianpoker.domain.player.HumanPlayer;
import indianpoker.domain.player.Player;
import indianpoker.vo.BettingCase;
import indianpoker.vo.Chips;

public class Fixture {
    public static Player player1 = new HumanPlayer("dom", new Deck(), new Chips(30), true);
    public static Player player2 = new HumanPlayer("dom", new Deck(), new Chips(30), false);
    public static Chips aChip = new Chips(1);

    public static BettingState player1IntiBettingState = new InitBettingState(new Chips(1), BettingCase.RAISE_CASE, player1);
    public static BettingState player2IntiBettingState = new InitBettingState(new Chips(1), BettingCase.RAISE_CASE, player2);


}
