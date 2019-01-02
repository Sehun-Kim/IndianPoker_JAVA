package indianpoker;

import indianpoker.controller.Turn;
import indianpoker.domain.Dealer;
import indianpoker.domain.Deck;
import indianpoker.domain.player.HumanPlayer;
import indianpoker.domain.player.Player;
import indianpoker.vo.Chips;

public class IndianPoker {

    public static void main(String[] args) {
        Player player1 = new HumanPlayer("dom", new Deck(), Chips.ofNumberOfChips(20), true);
        Player player2 = new HumanPlayer("choising", new Deck(), Chips.ofNumberOfChips(20), false);
        Dealer dealer = new Dealer();
        System.out.println("Start indianpoker.IndianPoker Game");

        Turn.start(player1, player2, dealer);
        System.out.println(player1 + "\n" + player2);

    }

}